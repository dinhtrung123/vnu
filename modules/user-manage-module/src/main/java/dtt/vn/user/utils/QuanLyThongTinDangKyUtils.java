package dtt.vn.user.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.core.model.ThamSo;
import org.oep.core.service.ThamSoLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import dtt.vn.user.business.DangKyTaiKhoanBusiness;
import dtt.vn.user.keycloak.connect.ConvertAttributes;
import dtt.vn.user.keycloak.connect.KeycloakUtils;
import dtt.vn.user.keys.Constantes;
import dtt.vn.user.keys.DangKyTaiKhoanKeys;
import dtt.vn.user.model.DangKyCongDanModel;
import dtt.vn.user.model.DangKyToChucModel;
import dtt.vn.user.service.model.ThongTinDangKy;
import dtt.vn.user.service.service.ThongTinDangKyLocalServiceUtil;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;
import dtt.vn.vnpost.service.WorkItemLocalServiceUtil;

public class QuanLyThongTinDangKyUtils {
	private static Log log = LogFactoryUtil.getLog(QuanLyThongTinDangKyUtils.class.getName()); 
	
	public static String getGiaTriThamSo(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	public static String getHinhThucKichHoat(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	
	public static String getMoTaThamSo(long groupId, String key){
		return ThamSoLocalServiceUtil.getValue(groupId, key)!=null?ThamSoLocalServiceUtil.getValue(groupId, key).getMoTa():"";
	}
	
	public static ThamSo updateThamSo(long groupId, String maThamSo, Object giaTri) throws SystemException{
		ThamSo thamSo = ThamSoLocalServiceUtil.getValue(groupId, maThamSo);
		if(thamSo == null){
			
			thamSo = ThamSoLocalServiceUtil.createThamSo(CounterLocalServiceUtil.increment(ThamSo.class.getName()));
			thamSo.setTrangThai(true);
			thamSo.setQuyenTacDong(0);
			thamSo.setMa(maThamSo);
			thamSo.setLoaiId(1);
			thamSo.setGroupId(groupId);
		}
		thamSo.setGiaTri(String.valueOf(giaTri));
		return ThamSoLocalServiceUtil.updateThamSo(thamSo);
	}
	
	public static boolean xoaTaiKhoanByAdmin (long thongTinDangKyId){
		boolean result = false;
		try {
			ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.fetchThongTinDangKy(thongTinDangKyId);
			if(ttdk != null){
				ThongTinDangKyLocalServiceUtil.deleteThongTinDangKy(ttdk);
				result = true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;
		
	}
	
	public static boolean kichHoatTaiKhoanByAdmin (long thongTinDangKyId , ActionRequest request, ActionResponse response){
		boolean result = false;
			ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.fetchThongTinDangKy(thongTinDangKyId);
			if(ttdk != null){
				if(ttdk.getDoiTuongSuDungId() == DangKyTaiKhoanKeys.Base.DOITUONG_SUDUNG_CONGDAN){
					DangKyCongDanModel model = DangKyQuyTrinhUtil.getModelFromJsonNoiDungCongDan(ttdk.getNoiDung());
					try {
						taoTaiKhoanCongDan(model, request, response);
						log.info("In QuanLyThongTinDangKyUtils.kichHoat xoa thong tin dang ky trong bang thongtindangky....");
						ThongTinDangKyLocalServiceUtil.deleteThongTinDangKy(ttdk);
						log.info("In QuanLyThongTinDangKyUtils.kichHoat xoa thong tin dang ky thanh cong.");
						result = true;
					} catch (Exception e) {
						log.error(e.getMessage());
					}
					
				}
				if(ttdk.getDoiTuongSuDungId() == DangKyTaiKhoanKeys.Base.DOITUONG_SUDUNG_TOCHUC){
					DangKyToChucModel model = DangKyQuyTrinhUtil.getModelFromJsonNoiDungToChuc(ttdk.getNoiDung());
					try {
						taoTaiKhoanTochuc(model, request, response);
						log.info("In QuanLyThongTinDangKyUtils.kichHoat xoa thong tin dang ky trong bang thongtindangky....");
						ThongTinDangKyLocalServiceUtil.deleteThongTinDangKy(ttdk);
						log.info("In QuanLyThongTinDangKyUtils.kichHoat xoa thong tin dang ky thanh cong.");
						result = true;
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				}
			}
			
		return result;
		
	}
	private static void taoTaiKhoanCongDan (DangKyCongDanModel model, ActionRequest request, ActionResponse response){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		int gender = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean choPhepAdminKichHoatTK = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_ADMIN_KICHHOAT_TK").equals("1");
		Account acc_cd = null;
		if(model != null){
			if(choPhepAdminKichHoatTK){
				try {
					
					if(model.getGioiTinhId()==20501){
						gender = Constantes.Gender.NAM;
					}else {
					gender = Constantes.Gender.NU ;
					}
					try {
						date = formatter.parse(model.getNgaySinh());
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					
					acc_cd = AccountLocalServiceUtil.themMoi(themeDisplay.getCompanyId(), themeDisplay.getLayout().getGroupId(), themeDisplay.getUserId(), new Date(), new Date(), null,
							Constantes.TrangThaiKeys.Cho_Xac_Minh, Constantes.XuLy.XULY, Constantes.AccountType.CONG_DAN, model.getUserName(), null, model.getHoTen(), gender, date,
							model.getDiaChiChiTiet(), model.getEmail(), model.getSoCMND(), model.getDienThoai(),
							String.valueOf(model.getTinhId()), String.valueOf(model.getQuanHuyenId()), String.valueOf(model.getPhuongXaId()), Constantes.IpLevel.MUC_1, null);
					
				
					
					WorkItem workItem = WorkItemLocalServiceUtil.createWorkItem();
					workItem.setGroupId(themeDisplay.getLayout().getGroupId());
					workItem.setCreateDate(new Date());
					workItem.setStartTime(new Date());
					workItem.setEndTime(new Date());
					workItem.setTitle(Constantes.WorkItem.Title.TAO_MOI);
					workItem.setStatus(Constantes.WorkItem.STATUS.NEW);
					workItem.setAccountId(acc_cd.getAccountId());
					workItem.setUserId(themeDisplay.getUserId());
					WorkItemLocalServiceUtil.addWorkItem(workItem);
					log.info("In QuanLyThongTinDangKyUtils.kichHoatCongDan tao ho so CD tren LF thanh cong");
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				
				try {
					boolean choPhepTaoTaiKhoanLR = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_LR").equals("1");
					if(choPhepTaoTaiKhoanLR){
						try {
							long userId = LiferayUserUtil.createUser(themeDisplay.getCompanyId(), model.getEmail(), model.getUserName(), model.getPassword(), model.getPassword(), false, model.getSoCMND());
							log.info("In QuanLyThongTinDangKyUtils.kichHoatCongDan tao tai khoan cho cong dan thanh cong, userId = " + userId);
						} catch (PortalException e) {
							log.error("Create user Liferay error :"+e.getMessage());
						}
					}else {
						log.info("Quan tri vien dang tat chuc nang tao tai khoan LR");
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				
				try {
					boolean choPhepTaoTaiKhoanKC = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_KC").equals("1");
					if(choPhepTaoTaiKhoanKC){
						log.info("In QuanLyThongTinDangKyUtils.kichHoatCongDan tao tai khoan cho cong dan tren POSTID trong truong hop cho phep tao tai khoan....");
						try {
							KeycloakUtils.addUser(model.getUserName(), model.getEmail(), model.getPassword(), model.getSoCMND(), model.getHoTen(), ConvertAttributes._Convert_CD(acc_cd, 2, model.getDaYeuTo()),model.getDaYeuTo());
							log.info("In QuanLyThongTinDangKyUtils.kichHoatCongDan tao tai khoan cho cong dan tren POSTID thanh cong");
						} catch (Exception e) {
							log.error(e);
						}
					}else {
						log.info("Quan tri vien dang tat chuc nang tao tai khoan KC");
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				
				
				
				
				
				
			}
		}
	}
	
	
	
	
	private static void taoTaiKhoanTochuc (DangKyToChucModel model, ActionRequest request, ActionResponse response){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		Account acc_tc = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean choPhepAdminKichHoatTK = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_ADMIN_KICHHOAT_TK").equals("1");
		if(model != null){
			if(choPhepAdminKichHoatTK){
				try {
					
					acc_tc = AccountLocalServiceUtil.themMoi(themeDisplay.getCompanyId(), themeDisplay.getLayout().getGroupId(), themeDisplay.getUserId(),
							new Date(), new Date(), null, Constantes.TrangThaiKeys.Cho_Xac_Minh,
							Constantes.XuLy.XULY, Constantes.AccountType.TO_CHUC, model.getUserName(), model.getNguoiDaiDien(),
							model.getTenToChuc(), 0, null, model.getDiaChiChiTiet(), model.getEmail(),
							model.getSoCMND_NDD(), model.getDienThoaiNDD(),
							String.valueOf(model.getTinhId()), String.valueOf(model.getQuanHuyenId()), String.valueOf(model.getPhuongXaId()),
							Constantes.IpLevel.MUC_1, model.getTaxCode());
					
					WorkItem workItem = WorkItemLocalServiceUtil.createWorkItem();
					workItem.setGroupId(themeDisplay.getLayout().getGroupId());
					workItem.setCreateDate(new Date());
					workItem.setStartTime(new Date());
					workItem.setEndTime(new Date());
					workItem.setTitle(Constantes.WorkItem.Title.TAO_MOI);
					workItem.setStatus(Constantes.WorkItem.STATUS.NEW);
					workItem.setAccountId(acc_tc.getAccountId());
					workItem.setUserId(themeDisplay.getUserId());
					WorkItemLocalServiceUtil.addWorkItem(workItem);
					log.info("In QuanLyThongTinDangKyUtils.kichhoattochuc: them moi to chuc tren LF thanh cong");
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				log.info("In QuanLyThongTinDangKyUtils.kichHoatToChuc tao tai khoan cho to chuc trong truong hop cho phep tao tai khoan....");
				try {
					boolean choPhepTaoTaiKhoanLR = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_LR").equals("1");
					if(choPhepTaoTaiKhoanLR){
						try {
							long userId = LiferayUserUtil.createUser(themeDisplay.getCompanyId(), model.getEmail(), model.getUserName(), model.getPassword(), model.getTenToChuc(), true, model.getTaxCode());
							log.info("In QuanLyThongTinDangKyUtils.kichHoatToChuc tao tai khoan cho to chuc thanh cong, userId = " + userId);
						}  catch (PortalException e) {
							log.error("Create user Liferay error :"+e.getMessage());
						}
					}else {
						log.info("Quan tri vien tat chuc nang tao tk LR");
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				
				try {
					boolean choPhepTaoTaiKhoanKC = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_KC").equals("1");
					if(choPhepTaoTaiKhoanKC){
						log.info("In QuanLyThongTinDangKyUtils.kichHoatToChuc tao tai khoan cho to chuc tren POSTID trong truong hop cho phep tao tai khoan....");
						try {
							KeycloakUtils.addUser(model.getUserName(), model.getEmail(), model.getPassword(), model.getTaxCode(), model.getTaxCode(), ConvertAttributes._Convert_TC(acc_tc, 2, model.getDaYeuTo()), model.getDaYeuTo());
							log.info("In QuanLyThongTinDangKyUtils.kichHoatCongDan tao tai khoan cho to chuc tren POSTID thanh cong");
						} catch (Exception e) {
							log.error(e);
						}
					}else {
						log.info("quan tri vien tat chuc nang tao tai khoan tren KC");
					}
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		}
	}
	

}
