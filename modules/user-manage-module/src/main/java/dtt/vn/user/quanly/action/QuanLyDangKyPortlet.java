package dtt.vn.user.quanly.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import dtt.vn.user.service.model.DataImport;
import dtt.vn.user.service.service.DataImportLocalServiceUtil;
import dtt.vn.user.utils.LiferayUserUtil;
import dtt.vn.user.utils.QuanLyThongTinDangKyUtils;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=DangKyTaiKhoan",
		"com.liferay.portlet.header-portlet-css=/css/oep-style.css",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"com.liferay.portlet.header-portlet-javascript=/js/oep-commons.js",
		"com.liferay.portlet.header-portlet-javascript=/js/fontawesome.js",
		"com.liferay.portlet.header-portlet-javascript=/js/multiple-select.js",
		"com.liferay.portlet.header-portlet-javascript=/js/bootstrap.js",
		"com.liferay.portlet.header-portlet-javascript=/js/bootstrap-select.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery-1.11.3.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery-1.9.1.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.ui.core.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.ui.timepicker.js",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.display-name=QuanLyDangKyPortlet", "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.view-template=/quanlydangky/view.jsp" }, service = Portlet.class)
public class QuanLyDangKyPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(QuanLyThongTinDangKyUtils.class.getName());

	public void kichhoat(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, IOException {
		User currentUser = PortalUtil.getUser(request);
		List<Role> roles = currentUser.getRoles();
		boolean isadmin = false;
		for (Role role : roles) {
			if (role.getName().equals("Administrator") || role.getName().equals("Site Administrator")) {
				isadmin = true;
				break;
			}
		}
		if (isadmin) {
			long ttdkId = ParamUtil.getLong(request, "ttdkId", 0);
			if (ttdkId > 0) {
				boolean res = QuanLyThongTinDangKyUtils.kichHoatTaiKhoanByAdmin(ttdkId, request, response);
				request.setAttribute("isSuccess", res);
			} else {
				// error
				log.info("That bai");
				request.setAttribute("isSuccess", false);
			}
		} else {
			request.setAttribute("isSuccess", false);
		}
	}

	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException {

		User currentUser = PortalUtil.getUser(request);
		List<Role> roles = currentUser.getRoles();
		boolean isadmin = false;
		for (Role role : roles) {
			if (role.getName().equals("Administrator") || role.getName().equals("Site Administrator")) {
				isadmin = true;
				break;
			}
		}
		if (isadmin) {
			long ttdkId = ParamUtil.getLong(request, "ttdkId", 0);
			if (ttdkId > 0) {
				boolean res = QuanLyThongTinDangKyUtils.xoaTaiKhoanByAdmin(ttdkId);
				request.setAttribute("isSuccess", res);
			} else {
				// error
				log.info("That bai");
				request.setAttribute("isSuccess", false);
			}
		} else {
			request.setAttribute("isSuccess", false);
		}
	}
	
	public void importData(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, IOException {
		List<DataImport> listData = DataImportLocalServiceUtil.getDataByI("0");
		if (Validator.isNotNull(listData) && listData.size()>0) {
			LiferayUserUtil.importUser(listData);
		} else {
			log.info("[importData] listData size 0");
		}
	}
}
