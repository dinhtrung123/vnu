package dtt.vn.account.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.exception.DuplicateFileException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

public class UploadFileUtils {

	static Log log = LogFactoryUtil.getLog(UploadFileUtils.class);
	
	private static final String FOLDER_NAME_BY_TIME = "HHmmss ddMMyyyy";
	private static long FILE_STORE_ID = 0;
	private static long companyId = PortalUtil.getDefaultCompanyId();
	
	public static List<FileEntry> upload(UploadPortletRequest uploadRequest, PortletRequest request, String fileUploadURL, String fileNameUpload) {
		List<FileEntry> listFileEntries = new ArrayList<FileEntry>();
		File[] file = removeNullFile(uploadRequest.getFiles(fileUploadURL));
		String[] fileName = removeNullString(ParamUtil.getParameterValues(uploadRequest, fileNameUpload));
		try {
			if (file != null && file.length > 0) {
				for (int i = 0; i < file.length; i++) {
					File item = file[i];
					if (item != null && fileName[i].length() != 0) {
						FileEntry fileEntry = addAttach(item, request, PortalUtil.getThemeDisplay(request), fileName[i]);
						if (fileEntry != null) {
							listFileEntries.add(fileEntry);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		Collections.sort(listFileEntries, new Comparator<FileEntry>() {
			@Override
			public int compare(FileEntry file1, FileEntry file2) {
				return file1.getMimeType().compareTo(file2.getMimeType());
			}

		});
		return listFileEntries;
	}

	public static List<FileEntry> upload(UploadPortletRequest uploadRequest, PortletRequest request, String fileUploadURL, String fileNameUpload, long folderRootId) {
		List<FileEntry> listFileEntries = new ArrayList<FileEntry>();
		File[] file = removeNullFile(uploadRequest.getFiles(fileUploadURL));
		String[] fileName = new String[file.length];
		long folderId = 0;
		for(int i = 0 ; i < file.length; i ++){
			fileName[i] = file[i].getName();
		}
		try {
			if (file != null && file.length > 0) {
				Folder root = null;
				if (folderRootId == 0) {
					root = isExitsOrCreateFolder(request, PortalUtil.getThemeDisplay(request), getDefaultPortletTitle(request), folderRootId);
					folderId = isExitsOrCreateFolder(root.getFolderId(), request);
				} else {
					root = DLAppServiceUtil.getFolder(folderRootId);
				}
				if (root != null) {
					for (int i = 0; i < file.length; i++) {
						File item = file[i];
						if (item != null && fileName[i].length() != 0) {
							FileEntry fileEntry = addAttachFile(item, request, PortalUtil.getThemeDisplay(request), fileName[i], folderId);
							if (fileEntry != null) {
								listFileEntries.add(fileEntry);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(request, "upload-error");
		}
		Collections.sort(listFileEntries, new Comparator<FileEntry>() {
			@Override
			public int compare(FileEntry file1, FileEntry file2) {
				return file1.getMimeType().compareTo(file2.getMimeType());
			}

		});
		return listFileEntries;
	}

	public static long isExitsOrCreateFolder(long folderRootId, PortletRequest request) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		User user = getAdmin();
		Folder folder = null;
		long roleId = getRoleById(companyId, "CanBoXacMinh").getRoleId();
		if (user != null) {
			String year = String.valueOf(cal.get(Calendar.YEAR));
			folder = isExitsOrCreateFolder(year, folderRootId,  user, request);
			folderRootId = folder.getFolderId();
			if (folder != null) {
				String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
				folder = isExitsOrCreateFolder(month, folderRootId,  user, request);
				folderRootId = folder.getFolderId();
				if (folder != null) {
					String date = String.valueOf(cal.get(Calendar.DATE));
					folder = isExitsOrCreateFolder(date, folderRootId,  user, request);
					if (folder != null) {
						if (!hasPermissions(folder.getFolderId(), roleId)) {
							setFolderPermissions(folder, RoleConstantsExt.CANBO_XACMINH);
						}
						return folder.getFolderId();
					}
				}
			}
		}
		return 0;
	}
	
	public static boolean hasPermissions(long folderId, long roleId) {
		boolean retval = false;
		ResourcePermission resourcePermission = null;
		try {
			resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(companyId,
					DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(folderId), roleId);
			retval = Validator.isNotNull(resourcePermission) ? true : false;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		}
		return retval;
	}

	private static Folder isExitsOrCreateFolder(String folderName, long folderRootId, User user, PortletRequest request) {
		ThemeDisplay themeDisplay = PortalUtil.getThemeDisplay(request);
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), folderRootId, folderName);
		} catch (PortalException | SystemException e) {
			log.error("Folder " + folderName + " not exits");
		}
		if (folder != null) {
			return folder;
		} else {
			return createFolder(folderName, folderRootId, request, user, themeDisplay);
		}
	}
	
	private static Folder isExitsOrCreateFolder(PortletRequest request, ThemeDisplay themeDisplay, String folderName, long parentId) {
		long groupId = themeDisplay.getScopeGroupId();
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentId, folderName);
		} catch (Exception e) {
			if (folder == null) {
				User user = getAdmin();
				try {
					folder = addFolder(user, folderName, parentId, groupId, getServiceContext(user.getUserId()));
				} catch (Exception ex) {
					if (folder == null) {
						try {
							folder = addFolder(user, getDateTime(), parentId, groupId, getServiceContext(user.getUserId()));
						} catch (Exception exp) {
							log.error(exp);
						}
					}
				}
			}
		}
		return folder;
	}

	private static Folder createFolder(String folderName, long folderRootId, PortletRequest request, User user,
			ThemeDisplay themeDisplay) {
		ServiceContext serviceContext;
		try {
			serviceContext = PortalUtil.getServiceContext(user.getUserId(), themeDisplay.getCompanyId());
			PrincipalThreadLocal.setName(user.getUserId());
			PermissionChecker permissionChecker;
			permissionChecker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(permissionChecker);
			Folder folder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), folderRootId, folderName, folderName, serviceContext);
			return folder;
		} catch (Exception e) {
			log.error(e.toString());
		}
		return null;
	}
	
	private static Folder addFolder(User user, String name, long parentId, long groupId,
			ServiceContext serviceContext) throws PortalException {
		try {
			PrincipalThreadLocal.setName(user.getUserId());
			PermissionChecker permissionChecker;
			permissionChecker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(permissionChecker);
			return DLAppServiceUtil.addFolder(groupId, parentId, name, name, serviceContext);
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	private static User getAdmin() {
		long companyId = PortalUtil.getDefaultCompanyId();
		try {
			Role role = getRoleById(companyId, RoleConstants.ADMINISTRATOR);
			if (role != null) {
				for (User admin : UserLocalServiceUtil.getRoleUsers(role.getRoleId())) {
					return admin;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	private static Role getRoleById(final long companyId, final String roleStrId) {
		try {
			return RoleLocalServiceUtil.getRole(companyId, roleStrId);
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	private static File[] removeNullFile(File[] array) {
		List<File> result = new ArrayList<File>();

		for (int i = 0; i < array.length; i++) {
			if (Validator.isNotNull(array[i])) {
				result.add(array[i]);
			}
		}
		return (File[]) result.toArray(new File[result.size()]);
	}

	private static String[] removeNullString(String[] array) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			if (Validator.isNotNull(array[i])) {
				result.add(array[i]);
			}
		}
		return (String[]) result.toArray(new String[result.size()]);
	}
	
	private static FileEntry addAttachFile(File file, PortletRequest request, ThemeDisplay themeDisplay, String title,
			long folderId) {
		File newFile = new File(file.getAbsolutePath());
		ServiceContext serviceContext = null;
		try {
			byte[] imageBytes = FileUtil.getBytes(newFile);
			InputStream is = new ByteArrayInputStream(imageBytes);
			serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
			serviceContext.setAddGuestPermissions(true);
			String mimeType = "";
			if (title != null) {
				String type = title.substring(title.indexOf(CommonConstants.DOT), title.length());
				if (type.equalsIgnoreCase(".doc")) {
					mimeType = "application/doc";
				} else if (type.equalsIgnoreCase(".pdf")) {
					mimeType = "application/pdf";
				} else if (type.equalsIgnoreCase(".xls")) {
					mimeType = "application/vnd.ms-excel";
				} else if (type.equalsIgnoreCase(".xlsx")) {
					mimeType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
				} else if (type.equalsIgnoreCase(".zip")) {
					mimeType = "application/zip";
				} else if (type.equalsIgnoreCase(".rtf")) {
					mimeType = "application/msword";
				}
			}
			FileEntry fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), folderId, title,
					mimeType, title, title, StringPool.BLANK, is, file.length(), serviceContext);
			if (fileEntry != null) {
				log.info("Add fileEntry " + fileEntry.getFileName() + " success");
				return fileEntry;
			}
		} catch (Exception e) {
			if (e instanceof DuplicateFileException) {
				try {
					byte[] imageBytes = FileUtil.getBytes(newFile);
					InputStream is = new ByteArrayInputStream(imageBytes);
					User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());
					Folder folder = createFolder(DateUtil.formatDate(new Date(), FOLDER_NAME_BY_TIME), folderId, request, user, themeDisplay);
					FileEntry fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),
							folder.getFolderId(), title, MimeTypesUtil.getContentType(file), title, title,
							StringPool.BLANK, is, file.length(), serviceContext);
					if (fileEntry != null) {
						/* setFilePermissions(fileEntry); */
						return fileEntry;
					}
				} catch (Exception ex) {
					try {
						return DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, title);
					} catch (PortalException | SystemException exp) {
						log.error(exp);
					}
				}
			} else {
				log.error(e.toString());
			}
		}
		return null;
	}
	
	private static FileEntry addAttach(File file, PortletRequest request, ThemeDisplay themeDisplay, String title) {
		Folder folder = null;
		try {
			String uploadFolderName = "uploadFolderName";
			folder = isExitsOrCreateFolder(request, themeDisplay, uploadFolderName, 0);
			if (folder != null) {
				folder = isExitsOrCreateFolder(request, themeDisplay, getDefaultPortletTitle(request),
						folder.getFolderId());
				if (folder != null) {
					folder = isExitsOrCreateFolder(request, themeDisplay,
							formatFolderName(title.substring(0, title.lastIndexOf("."))), folder.getFolderId());
					if (folder != null) {
						File newFile = new File(file.getAbsolutePath());
						byte[] imageBytes = FileUtil.getBytes(newFile);
						InputStream is = new ByteArrayInputStream(imageBytes);
						ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),request);
						serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
						serviceContext.setAddGuestPermissions(true);
						return DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), folder.getFolderId(),
								title, MimeTypesUtil.getContentType(file), title,
								String.valueOf(request.getAttribute(CommonConstants.QUESTION_MODEL_FIELD.QUESTION_ATTACHED_FILE_NAME)),
								StringPool.BLANK, is, file.length(), serviceContext);
					}
				}
			}
		} catch (Exception e) {
			if (e instanceof DuplicateFileException) {
				try {
					folder = isExitsOrCreateFolder(request, themeDisplay, getDateTime(), folder.getFolderId());
					if (folder != null) {
						File newFile = new File(file.getAbsolutePath());
						byte[] imageBytes = FileUtil.getBytes(newFile);
						InputStream is = new ByteArrayInputStream(imageBytes);
						ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
								request);
						serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
						serviceContext.setAddGuestPermissions(true);
						return DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), folder.getFolderId(),
								title, MimeTypesUtil.getContentType(file), title,
								String.valueOf(request.getAttribute(CommonConstants.QUESTION_MODEL_FIELD.QUESTION_ATTACHED_FILE_NAME)),
								StringPool.BLANK, is, file.length(), serviceContext);
					}
				} catch (Exception ex) {
					log.error(e);
				}
			} else {
				try {
					File newFile = new File(file.getAbsolutePath());
					byte[] imageBytes = FileUtil.getBytes(newFile);
					InputStream is = new ByteArrayInputStream(imageBytes);
					ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
							request);
					serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
					serviceContext.setAddGuestPermissions(true);
					long QA_DOCUMENT_ID = FILE_STORE_ID;
					return DLAppServiceUtil.addFileEntry(PortalUtil.getGlobalGroupId(), QA_DOCUMENT_ID,
							title.substring(title.indexOf("_") + 1, title.length()), MimeTypesUtil.getContentType(file),
							title, String.valueOf(request.getAttribute(CommonConstants.QUESTION_MODEL_FIELD.QUESTION_ATTACHED_FILE_NAME)),
							StringPool.BLANK, is, file.length(), serviceContext);
				} catch (Exception ex) {
					log.error(e);
				}
			}
		}
		return null;
	}
	
	private static String getDefaultPortletTitle(PortletRequest request) {
		String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
		return formatFolderName(LanguageUtil.get(LocaleUtil.fromLanguageId("vi_VN"), "javax.portlet.title." + portletId));
	}
	
	private static String formatFolderName(String symbol) {
		return symbol.replaceAll("[\\/?%*:|\"<>]", "-");
	}
	
	private static ServiceContext getServiceContext(long userId) throws Exception {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setPortletPreferencesIds(null);
		serviceContext.setCompanyId(companyId);
		serviceContext.setUserId(userId);
		return serviceContext;
	}
	
	private static String getDateTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmssSSS");
		return sdf.format(date);
	}
	
	private static void setFilePermissions(FileEntry fileEntry) throws Exception {
		ResourcePermission resourcePermission = null;
		final Role siteMemberRole = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(), RoleConstants.GUEST);
		final Role ownerRole = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(), RoleConstants.OWNER);
		
		ResourceAction resourceAction = ResourceActionLocalServiceUtil.getResourceAction(DLFileEntry.class.getName(),
				ActionKeys.VIEW);
		try {
			resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(fileEntry.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(fileEntry.getPrimaryKey()), ownerRole.getRoleId());
			
			if (Validator.isNotNull(resourcePermission)) {
				resourcePermission.setRoleId(siteMemberRole.getRoleId());
				resourcePermission.setActionIds(resourceAction.getBitwiseValue());
				ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
			}
		} catch (NoSuchResourcePermissionException e) {
			log.error(e);
		}
	}
	
	private static void setFolderPermissions(Folder folder, String roleName) throws Exception {
		ResourcePermission resourcePermission = null;
		Role role = getRoleById(companyId, roleName);
		ResourceAction resourceAction = ResourceActionLocalServiceUtil.getResourceAction(DLFolder.class.getName(), ActionKeys.ADD_DOCUMENT);
		
		long resourcePermissionId = CounterLocalServiceUtil.increment(ResourcePermission.class.getName());
		resourcePermission = ResourcePermissionLocalServiceUtil.createResourcePermission(resourcePermissionId);
		resourcePermission.setCompanyId(companyId);
		resourcePermission.setName(DLFolder.class.getName());
		resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
		resourcePermission.setPrimKey(String.valueOf(folder.getFolderId()));
		resourcePermission.setPrimaryKey(folder.getFolderId());
		resourcePermission.setRoleId(role.getRoleId());
		resourcePermission.setActionIds(resourceAction.getBitwiseValue());
		resourcePermission.setViewActionId(true);
		ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
	}
}
