package dtt.vn.vnpost.service.util;

import java.util.Date;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.WorkItemLocalServiceUtil;


public class APIUtils {
	private static Log log = LogFactoryUtil.getLog(APIUtils.class);
	public static String doAddWorkItem (long accountId, int method){
		WorkItem workItem = WorkItemLocalServiceUtil.getWorkItemByAccountId(accountId);
		workItem.setEndTime(new Date());
		workItem.setUserId(149003);
		workItem.setStatus("COMPLETE");
		WorkItemLocalServiceUtil.updateWorkItem(workItem);
		
		// Insert new Item
		workItem = WorkItemLocalServiceUtil.createWorkItem();
		workItem.setGroupId(20126);
		workItem.setCreateDate(new Date());
		workItem.setStartTime(new Date());
		if(method == APIKeys.CapNhat.PheDuyet.PHE_DUYET){
			workItem.setTitle("Accept Approved");
		}else {
			workItem.setTitle("Reject Approved");
		}
		workItem.setStatus("NEW");
		workItem.setAccountId(accountId);			
		WorkItemLocalServiceUtil.addWorkItem(workItem);
		return null;
	}
	
	public static boolean setFilePermissions(FileEntry fileEntry) throws Exception {
		boolean result = false;
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
				result = true;
			}
		} catch (NoSuchResourcePermissionException e) {
			log.error(e);
		}
		return result;
	}
}
