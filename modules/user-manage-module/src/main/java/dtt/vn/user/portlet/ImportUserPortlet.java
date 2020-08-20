package dtt.vn.user.portlet;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;*/

import com.google.gson.Gson;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.exception.NoSuchFileException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import dtt.vn.user.business.ImportUserBussiness;
import dtt.vn.user.common.utils.DateUtil;
import dtt.vn.user.service.model.DataImport;
import dtt.vn.user.service.service.DataImportLocalServiceUtil;
import dtt.vn.user.utils.LiferayUserUtil;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=DangKyTaiKhoan",
		"com.liferay.portlet.instanceable=false", "javax.portlet.init-param.template-path=/",
		"javax.portlet.display-name=QuanLyImportUserPortlet", "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.view-template=/quanlyimportuser/view.jsp" }, service = Portlet.class)
public class ImportUserPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(ImportUserPortlet.class.getName());

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		PrintWriter writer = resourceResponse.getWriter();
		String resourceId = resourceRequest.getResourceID();
		if (resourceId.equals("viewedit")) {
			long idedit = ParamUtil.getLong(resourceRequest, "idedit", 0);
			DataImport datai = DataImportLocalServiceUtil.fetchDataImport(idedit);
			if (datai != null) {
				writer.write(new Gson().toJson(datai));
			} else {
				writer.write("");
			}

		}
	}

	public void importData(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, IOException {
		List<DataImport> listData = DataImportLocalServiceUtil.getDataByI("0");
		if (Validator.isNotNull(listData) && listData.size() > 0) {
			LiferayUserUtil.importUser(listData);
		} else {
			log.info("[importData] listData size 0");
		}
	}

	public static byte[] toByteArray(InputStream in) throws IOException {

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		byte[] buffer = new byte[1024];
		int len;

		// read bytes from the input stream and store them in buffer
		while ((len = in.read(buffer)) != -1) {
			// write bytes from the buffer into output stream
			os.write(buffer, 0, len);
		}

		return os.toByteArray();
	}


	public void edit(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, IOException {

		String screenName = ParamUtil.getString(request, "ScreenName", "");
		String lastName = ParamUtil.getString(request, "lastName", "");
		String email = ParamUtil.getString(request, "Email", "");
		long idedit = ParamUtil.getLong(request, "idedit", 0);
		if (screenName == "" || lastName == "" || email == "") {
			request.setAttribute("isSuccess", false);
			return;
		} else {
			request.setAttribute("isSuccess", true);
		}
		DataImport datai = DataImportLocalServiceUtil.fetchDataImport(idedit);

		datai.setScreenName(screenName);
		datai.setLastName(lastName);
		datai.setEmailAddress(email);
		datai.setHasImport("0");
		datai.setErrorMsg("");

		datai = DataImportLocalServiceUtil.updateDataImport(datai);
		

	}

	public void export(ActionRequest request, ActionResponse response) {
		try {
			String hasImport = ParamUtil.getString(request, "hasImport3", "2");
			List<DataImport> listData = new ArrayList<DataImport>();
			if (hasImport.equals("2")) {
				List<DataImport> listData1 = DataImportLocalServiceUtil.getDataByI("-1", -1, -1);
				List<DataImport> listData2 = DataImportLocalServiceUtil.getDataByI("0", -1, -1);
				List<DataImport> listData3 = DataImportLocalServiceUtil.getDataByI("1", -1, -1);
				listData.addAll(listData1);
				listData.addAll(listData2);
				listData.addAll(listData3);
			} else {
				listData = DataImportLocalServiceUtil.getDataByI(hasImport, -1, -1);
			}

			byte[] exfilebyte = ImportUserBussiness.exportCSVFile(listData);
			HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
			res.getOutputStream().write(exfilebyte);
			res.addHeader("Content-disposition", "attachment; filename=" + "Import-User-"
					+ DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_D_M_Y) + ".csv");
			res.setContentType(ContentTypes.APPLICATION_TEXT);
			res.flushBuffer();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void uploadexport(ActionRequest actionRequest, ActionResponse actionResponse) throws NoSuchFileException {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		File fileupload = uploadRequest.getFile("file-import");
		String fileName = fileupload.getName();
		int pos = fileName.lastIndexOf('.');
		String fileExtension = fileName.substring(pos + 1);
		if (Validator.isNull(fileExtension) || !(fileExtension.equalsIgnoreCase("csv"))) {
			throw new NoSuchFileException();
		}

		if (fileExtension.equalsIgnoreCase("csv") /* || (fileExtension == "csv") */) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(fileupload.getAbsolutePath()));
				int count = 0;
				for (int itri = 0;; itri++) {
					String strLine = br.readLine();
					if(count == 0){
						count++;
						continue;
					}
					if (strLine == null) {
						break;
					}
					log.info("Line number " + itri + " value : " + strLine);
					
					String[] arrstr = strLine.split(",");
					ArrayList<String> larray = new ArrayList<String>();
					List<String> larray1 =  Arrays.asList(arrstr);
					larray.addAll(larray1);
					if(larray.size() <11){
						for(int i = larray.size(); i<11;i++){
							
							larray.add("");
						}
					}
					List<DataImport> data = DataImportLocalServiceUtil.getData(-1, -1);
					DataImport dat = DataImportLocalServiceUtil.createDataImport(CounterLocalServiceUtil.increment());
					dat.setScreenName(larray.get(1));
					dat.setLastName(larray.get(2));
					dat.setEmailAddress(larray.get(3));
					dat.setPhone(larray.get(4));
					dat.setJobTitle(larray.get(5));
					dat.setUnit(larray.get(6));
					dat.setNameRole(larray.get(7));
					dat.setNumberId(larray.get(8));
					dat.setHasImport(larray.get(9).equals("")?"0":larray.get(9));
					dat.setErrorMsg(larray.get(10));
					dat.setInsertDate(new Date());
					DataImportLocalServiceUtil.addDataImport(dat);
					count++;
				}
			} catch (Exception ex) {
				log.error(ex.toString());
			}
		}
	}
}