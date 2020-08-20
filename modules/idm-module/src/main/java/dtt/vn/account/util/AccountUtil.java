package dtt.vn.account.util;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import javax.portlet.RenderRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.oep.core.service.ThamSoLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.ParamUtil;

import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.DanhMuc;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;
import dtt.vn.vnpost.service.DanhMucLocalServiceUtil;
import dtt.vn.account.business.Constantes;
import dtt.vn.xml.model.ThongTinAccount;

public class AccountUtil {
	private static Log log= LogFactoryUtil.getLog(AccountUtil.class);
	
	
	public static String getGiaTriThamSo(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}

	
	public static String getMoTaThamSo(long groupId, String key){
		return ThamSoLocalServiceUtil.getValue(groupId, key)!=null?ThamSoLocalServiceUtil.getValue(groupId, key).getMoTa():"";
	}
	
	public static Account getAccount(long Id)	throws SystemException {
		return AccountLocalServiceUtil.fetchAccount(Id);
	}

	public static Account getAccount(RenderRequest request) throws PortalException, SystemException {

		long accountId = ParamUtil.getLong(request,"accountId",0L);
		long tinhId = 0L;
		long huyenId =0L;
		long xaId = 0L;
		DanhMuc danhMuc = null;
		Account account = null;
		if (accountId > 0) {
			account = AccountLocalServiceUtil.getAccount(accountId);
			danhMuc = DanhMucLocalServiceUtil. getDanhMuc_By_Nhom_Muc_Ma(Constantes.MA, 1, account.getCityCode(), true);
			tinhId = (danhMuc == null) ? 0 :danhMuc.getId();
			danhMuc = DanhMucLocalServiceUtil. getDanhMuc_By_Nhom_Muc_Ma(Constantes.MA, 2, account.getDistrictCode(), true);
			huyenId = (danhMuc == null) ? 0 :danhMuc.getId();
			danhMuc = DanhMucLocalServiceUtil. getDanhMuc_By_Nhom_Muc_Ma(Constantes.MA, 3, account.getWardCode(), true);
			xaId = (danhMuc == null) ? 0 :danhMuc.getId();
			
			
		}

		request.setAttribute("account", account);
		request.setAttribute("accountId", accountId);
		request.setAttribute("tinhId", tinhId);
		request.setAttribute("huyenId", huyenId);
		request.setAttribute("xaId", xaId);
		
		return account;
	}

/*	public static Account getAccount(PortletRequest portletRequest) throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil	.getHttpServletRequest(portletRequest);

		return getAccount(request);
	}

	public static Account getAccount(ActionRequest actionRequest) throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);

		return getAccount(request);
	}*/

	/*public static Account getAccount(RenderRequest actionRequest) throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);

		return getAccount(request);
	}*/
	public static Organization getToChucByMa(String maToChuc) throws SystemException{
		for(Organization org : OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS)){
			if(maToChuc.equals(getMaToChuc(org))){
				return org;
			}
		}
		return null;
	}
	public static String getMaToChuc(Organization organization){
		Serializable wfids=organization.getExpandoBridge().getAttribute("MA");
		if(wfids != null){
			return wfids.toString();
		}
		return "";
	}	
	
	public static String getXmlExtraString(Object ttdon){
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(ThongTinAccount.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
			
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			jaxbMarshaller.marshal(ttdon, bo);
			return bo.toString();
		}catch(JAXBException e){
			
		}
		
		return "";
	}	
	
	public static boolean deleteTaiKhoan (long accountId, long companyId){
		boolean result = false;
		Account account = null;
		boolean isSuccessLR = false;
		boolean isSuccessKC = false;
		Session session = null; 
		try {
			account = AccountLocalServiceUtil.fetchAccount(accountId);
			
			if(account != null){
				log.info("In AccountUtil thuc hien delete HoSoAccount....");
				if(!account.getEmail().equals("")){
					try {
						log.info("In AccountUtil thuc hien delete Liferay User.......");
						isSuccessLR = LiferayUserUtil.deleteUserByEmail(companyId, account.getEmail());
						log.info("In AccountUtil thuc hien delete Liferay User thanh cong");
					} catch (Exception e) {
						log.error(e.getMessage());
					}		
				}
				if(!account.getAccountName().equals("")){
					try {
						log.info("In AccountUtil thuc hien delete KC User........");
						isSuccessKC = KeycloakUtils.deleteUserByUseNameKC(account.getAccountName());
						log.info("In AccountUtil thuc hien delete KC User thanh cong");
					} catch (Exception e) {
						log.error(e.getMessage());
					}
					
				}
				if(isSuccessKC == true && isSuccessLR == true){
					try {
						log.info("In AccountUtil thuc hien delete TaiKhoan......");
						AccountLocalServiceUtil.deleteAccount(account);
						result = true;
						log.info("In AccountUtil thuc hien delete TaiKhoan thanh cong");
						log.info("In AccountUtil thuc hien delete HoSoAccount thanh cong");
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				}
				
				
				
			}else {
				log.info("In AccountUtil Exception Account null");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
}
