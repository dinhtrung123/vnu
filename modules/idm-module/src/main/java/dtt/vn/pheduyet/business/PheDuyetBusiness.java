package dtt.vn.pheduyet.business;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.ContentUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import org.oep.core.service.MailLocalServiceUtil;
import org.oep.core.service.ThamSoLocalServiceUtil;
import org.oep.danhmuc.service.DanhMucLocalServiceUtil;

import dtt.vn.account.util.DateUtil;
import dtt.vn.account.util.MailService;
import dtt.vn.account.util.MyLanguageUtil;
import dtt.vn.vnpost.model.Account;
import dtt.vn.xacminh.business.XacMinhBusiness;

public class PheDuyetBusiness {
	private static final Configuration _configuration = ConfigurationFactoryUtil
		    .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	
	
	private static Log log = LogFactoryUtil.getLog(PheDuyetBusiness.class.getName()); 
	
	public static String getGiaTriThamSo(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	
	public static String getMoTaThamSo(long groupId, String key){
		return ThamSoLocalServiceUtil.getValue(groupId, key)!=null?ThamSoLocalServiceUtil.getValue(groupId, key).getMoTa():"";
	}
	
	
	
	
	public static void sendEmailNotification(String[] emailAddress,String Hoten,boolean isPheduyet,String username) {
		try {	
			InternetAddress[] internetAddresses = new InternetAddress[emailAddress.length];
			InternetAddress fromAddresses = new InternetAddress("vnpostmail1@gmail.com");
			for (int i = 0; i < emailAddress.length; i++) {
				internetAddresses[i] = new InternetAddress(emailAddress[i]);
			}

			String body = ContentUtil.get("/formbbxn/emailxacminh.tmpl", true);
			String bodycontent = isPheduyet?_configuration.get("mail.remind.pheduyet.setBody"):_configuration.get("mail.remind.tuchoipheduyet.setBody");
			bodycontent = bodycontent.replace("[$tendangnhap$]", username);
			body = StringUtil.replace(body, new String[] { "[$NAME$]", "[$CONTENT]", "[$SIGNATURE]" },
					new String[] { Hoten,bodycontent, "VNPOST" });

			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(fromAddresses);
			mailMessage.setTo(internetAddresses);
			mailMessage.setSubject(_configuration.get("mail.remind.pheduyet.setSubject"));
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	public static final String[] arrattrkey = {"hoten","ngaysinh","gioitinh","cmnd","cccd",
			"sohochieu","tentochuc","diachithuongtru","diachihientai","masothuetochuc",
			"nguoidaidientochuc","cmndnguoidaidien","cccdnguoidaidien"};
	public static final String[] arrattrname = {"Họ và tên","Ngày sinh","Giới tính","Số CMND","Số CCCD","Số hộ chiếu","Tên tổ chức","Địa chỉ thường trú","Địa chỉ nơi ở hiện tại","Mã số thuế tổ chức","Người đại diện tổ chức","Số CMND người đại diện","Số CCCD người đại diện"};
	
	public static Map<String,ThuocTinhObject> createObejctTT(Account account,HttpServletRequest request){
		Map<String,ThuocTinhObject> res = new HashMap<String, ThuocTinhObject>();
		try {
			for(int i =0; i < arrattrkey.length;i++) {
				if(arrattrkey[i].equals("hoten")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = account.getFullName()==null?"":account.getFullName();
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("ngaysinh")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = account.getBirthdate()==null?"":DateUtil.convertDateToString(account.getBirthdate(), DateUtil.DATE_FORMAT_D_M_Y);
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("gioitinh")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = (account.getGender()== 0)?MyLanguageUtil.get(request, request.getLocale(), "portlet.quanlytaikhoan.gioitinhnu"):MyLanguageUtil.get(request, request.getLocale(), "portlet.quanlytaikhoan.gioitinhnam");
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("cmnd")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = account.getPersonalId()==null?"":account.getPersonalId();
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("cccd")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = account.getPersonalId()==null?"":account.getPersonalId();
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("sohochieu")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = account.getPersonalId()==null?"":account.getPersonalId();
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("tentochuc")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = account.getFullName()==null?"":account.getFullName();
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("diachithuongtru")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					String diaChiChiTiet =account.getAddress()+"-"+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getWardCode()))
					.getTen()+"-"+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getDistrictCode())).
					getTen()+"-"+ DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getCityCode())).getTen();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = diaChiChiTiet;
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("diachihientai")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = "";
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("masothuetochuc")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = account.getTaxCode()==null?"":account.getTaxCode();
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("nguoidaidientochuc")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = account.getLegalDelegate()==null?"":account.getLegalDelegate();
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("cmndnguoidaidien")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = account.getPersonalId()==null?"":account.getPersonalId();
					res.put(arrattrkey[i],tt);
				}
				if(arrattrkey[i].equals("cccdnguoidaidien")) {
					ThuocTinhObject tt = new ThuocTinhObject();
					tt.tenThuocTinh = arrattrname[i];
					tt.giatrithuoctinh = account.getPersonalId()==null?"":account.getPersonalId();
					res.put(arrattrkey[i],tt);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return res;
	}
	public static ThuocTinhObject getnameandvaluett(Map<String,ThuocTinhObject> arrmap,String keySttr) {
		System.out.println("keySttr:"+keySttr);
		ThuocTinhObject tt = new ThuocTinhObject();
		try {
			Iterator it = arrmap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        if(pair.getKey().toString().equals(keySttr)) {
		        	tt = (ThuocTinhObject) pair.getValue();
		        	System.out.println("======:"+tt.giatrithuoctinh);
		        }
		       
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tt;
	}
	public static void sendMailThongBaoPheDuyetSai(ThemeDisplay themeDisplay, String emailAddress, String hoTen, String username){
		try {
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_TB_PD_SAI");
			String body = getMoTaThamSo(themeDisplay.getScopeGroupId(), "MAIL_TEMPLATE_TB_PD_SAI");
			body = body.replace("[$tendangnhap$]", username);
			body = body.replace("[$ten]", hoTen);
			body = body.replace("[$email]", emailAddress);
			if(MailLocalServiceUtil.send(emailAddress, subject, body)){
				log.info("In XacMinhBusiness gui mail thong bao thanh cong");
			}else {
				log.info("In XacMinhBusiness gui mail thong bao that bai");
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	public static void sendMailThongBaoPheDuyetDung(ThemeDisplay themeDisplay, String emailAddress, String hoTen, String username){
		try {
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_TB_PD_DUNG");
			String body = getMoTaThamSo(themeDisplay.getScopeGroupId(), "MAIL_TEMPLATE_TB_PD_DUNG");
			body = body.replace("[$tendangnhap$]", username);
			body = body.replace("[$ten]", hoTen);
			body = body.replace("[$email]", emailAddress);
			if(MailLocalServiceUtil.send(emailAddress, subject, body)){
				log.info("In XacMinhBusiness gui mail thong bao thanh cong");
			}else {
				log.info("In XacMinhBusiness gui mail thong bao that bai");
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
