package org.oep.danhmuc.portlet.quanly.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.oep.danhmuc.util.PortletKeys;
import org.oep.danhmuc.exception.DuplicateCodeException;
import org.oep.danhmuc.exception.DuplicateNameException;
import org.oep.danhmuc.model.DanhMuc;
import org.oep.danhmuc.portlet.quanly.keys.QuanLyKeys;
import org.oep.danhmuc.service.DanhMucLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

public class QuanLyBusiness {
	public static boolean validateXoaListDanhMuc(List<DanhMuc> listItems, ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, IOException{
		if(listItems.size()>0){
			for(DanhMuc i : listItems){
				List<DanhMuc> listCon = DanhMucLocalServiceUtil.getByP(i.getId());
				if(listCon.size()>0){
					SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_ITEM_HAS_CHILD);
					actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
					return true;
				}
			}
			return false;
		}
		else{
			SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_ITEMS_HAS_NO_CHILD);
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
			return false;
		}
		
	}
	
	public static void xoaTatDanhMuc(List<DanhMuc> listItems){
		for(DanhMuc i: listItems){
			DanhMucLocalServiceUtil.xoaDanhMuc(i.getId());
		}
	}
	
	public static void getListDescendantDanhMuc(DanhMuc item, List<DanhMuc> listOuput) throws SystemException{
		boolean isActive = false;
		List<DanhMuc> listAnhChi = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(item.getId(), isActive);
		if(listAnhChi !=null && listAnhChi.size() >0){
			for(DanhMuc i: listAnhChi){
				listOuput.add(i);
				getListDescendantDanhMuc(i, listOuput);
			}
		}
	}
	
	public static boolean validateData(int checkAddEdit, long itemId, long nhomId, String ten, String ma, ActionRequest actionRequest) throws SystemException, PortalException {
		boolean check = true;
		if(Validator.isBlank(ten)){
			check = false;
			SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_EMPTY_TEN);
		}
		if(Validator.isBlank(ma)){
			check = false;
			SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_EMPTY_MA);
		}
		
		if(checkAddEdit == 0) {
			/*TH them moi*/
			if(DanhMucLocalServiceUtil.getDanhMucByNhomIdMa(nhomId, ma) != null){
				check = false;
				SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_DUPLICATE_MA);
			}
		} else if(checkAddEdit == 1){
			/*TH sua danh muc*/
			if(DanhMucLocalServiceUtil.fetchDanhMuc(itemId) != null && DanhMucLocalServiceUtil.getDanhMucByNhomIdMa(nhomId, ma) != null) {
				if(DanhMucLocalServiceUtil.getDanhMucByNhomIdMa(nhomId, ma).getId() != DanhMucLocalServiceUtil.fetchDanhMuc(itemId).getId()){
					check = false;
					SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_DUPLICATE_MA);
				}
			}
		}
		
		return check;
	}
	
	public static int setAndUpdateThutuHienThi(long danhMucId,long nhomId, long idTiepTheo,int checkAddEdit,boolean trangThai, int thuTuHienThiMoi) throws SystemException {
		thuTuHienThiMoi = 0;
		List<DanhMuc> listAnhChi = new ArrayList<DanhMuc>();
		DanhMuc selectedDanhMuc =DanhMucLocalServiceUtil.fetchDanhMuc(danhMucId > 0 ? danhMucId : nhomId);
		if(selectedDanhMuc.getChaId()!=0){
			listAnhChi = DanhMucLocalServiceUtil.getByP(selectedDanhMuc.getChaId());
		}else{
			listAnhChi = DanhMucLocalServiceUtil.getAllByNhomIdMuc(selectedDanhMuc.getNhomId(), selectedDanhMuc.getMuc());
		}
		
		if(checkAddEdit == 0){
			
			if(idTiepTheo == 0){
				if(listAnhChi.size() >0){
					DanhMuc anhChiCuoiCung = listAnhChi.get(listAnhChi.size()-1);
					thuTuHienThiMoi = anhChiCuoiCung.getThuTuHienThi() +1;
				}
			}else{
				int thuTuHienThiTiepTheo = DanhMucLocalServiceUtil.fetchDanhMuc(idTiepTheo).getThuTuHienThi();
				thuTuHienThiMoi = thuTuHienThiTiepTheo +1;
				for (DanhMuc dm: listAnhChi)
					if(dm.getThuTuHienThi()>thuTuHienThiTiepTheo){
						dm.setThuTuHienThi(dm.getThuTuHienThi()+1);
						DanhMucLocalServiceUtil.updateDanhMuc(dm);
					}
			}
			
		}else{
			if(idTiepTheo != 0){
				int thuTuHienThiCu = DanhMucLocalServiceUtil.fetchDanhMuc(danhMucId).getThuTuHienThi();
				int thuTuHienThiNext = DanhMucLocalServiceUtil.fetchDanhMuc(idTiepTheo).getThuTuHienThi();
				if(thuTuHienThiCu < thuTuHienThiNext ){
					thuTuHienThiMoi = thuTuHienThiNext;
					for(DanhMuc dm : listAnhChi){
						if(dm.getThuTuHienThi()> thuTuHienThiCu && dm.getThuTuHienThi() <= thuTuHienThiNext){
							dm.setThuTuHienThi(dm.getThuTuHienThi() -1);
							DanhMucLocalServiceUtil.updateDanhMuc(dm);
						}
						else{
							//do nothing
						}
					}
				}
				else{
					thuTuHienThiMoi = thuTuHienThiNext + 1;
					for(DanhMuc dm : listAnhChi){
						if(dm.getThuTuHienThi() > thuTuHienThiNext && dm.getThuTuHienThi() < thuTuHienThiCu){
							dm.setThuTuHienThi(dm.getThuTuHienThi()+1);
							DanhMucLocalServiceUtil.updateDanhMuc(dm);
						}
					}
				}
			}
		}
		return thuTuHienThiMoi;
	}
	public static int setMuc(long danhMucId, int checkAddEdit) throws PortalException, SystemException {
		int muc = 0;
			if(DanhMucLocalServiceUtil.fetchDanhMuc(danhMucId) != null){
				DanhMuc cha = DanhMucLocalServiceUtil.fetchDanhMuc(danhMucId);
				muc=cha.getMuc()+1;
			}
		return muc;
	}
	public static String setMaGiaPha(long danhMucId) throws SystemException {
		String maGiaPha = null;
		
			DanhMuc cha = DanhMucLocalServiceUtil.fetchDanhMuc(danhMucId);
			if(cha.getMaGiaPha() != "" || !cha.getMaGiaPha().isEmpty()){
				maGiaPha = cha.getMaGiaPha() + "," + cha.getMa();
			}
			else maGiaPha = cha.getMa();
		
		return maGiaPha;
		
	}
	public static void updateMaGiaPha(long danhMucId,String maMoi, String maCu ) throws SystemException {
		DanhMuc danhMuc = DanhMucLocalServiceUtil.fetchDanhMuc(danhMucId);
		List<DanhMuc> listConChau = new ArrayList<DanhMuc>();
		getListDescendantDanhMuc(danhMuc, listConChau);
		for(DanhMuc dm : listConChau){
			String maGiaPha ="";
			String[] maGiaPhaArr = dm.getMaGiaPha().split(",");
			for(int i = 0; i< maGiaPhaArr.length ; i++){
				if(maGiaPhaArr[i].equals(maCu)){
					maGiaPhaArr[i] = maMoi;
				}
			}
			for(int i = 0; i<maGiaPhaArr.length; i++){
				maGiaPha += maGiaPhaArr[i] + ",";	
			}
			maGiaPha = maGiaPha.substring(0, maGiaPha.length()-1);
			dm.setMaGiaPha(maGiaPha);
			DanhMucLocalServiceUtil.updateDanhMuc(dm);
		}
		
	}
	public static void suanhomIdConChau(DanhMuc danhMuc, long nhomId) throws SystemException {
		List<DanhMuc> listConChau = new ArrayList<DanhMuc>();
		getListDescendantDanhMuc(danhMuc, listConChau);
		for(DanhMuc dm : listConChau){
			dm.setNhomId(nhomId);
			DanhMucLocalServiceUtil.updateDanhMuc(dm);
		}
		
	}
	public static void addUpdateItem(long danhMucId, String ten, String ma, String moTa, long nhomId, boolean trangThai, long idTiepTheo,int checkAddEdit, ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException{
		int thuTuHienThi = 0;
		int muc = 1;
		String maGiaPha = "";
		
		thuTuHienThi=setAndUpdateThutuHienThi(danhMucId,nhomId, idTiepTheo, checkAddEdit, trangThai, thuTuHienThi);
		if(checkAddEdit == 0){
//			muc = setMuc(danhMucId, checkAddEdit);
			if(DanhMucLocalServiceUtil.fetchDanhMuc(danhMucId) != null){
				DanhMuc cha = DanhMucLocalServiceUtil.fetchDanhMuc(danhMucId);
				muc=cha.getMuc()+1;
			}
			if(DanhMucLocalServiceUtil.fetchDanhMuc(danhMucId) != null){
				maGiaPha = setMaGiaPha(danhMucId);
			}
			long chaId = danhMucId;
			DanhMucLocalServiceUtil.themMoiDanhMuc(nhomId, chaId, ma, maGiaPha, ten, moTa, trangThai,muc, thuTuHienThi);
		}else{
			DanhMuc danhMuc = DanhMucLocalServiceUtil.fetchDanhMuc(danhMucId);
			if(!ma.equals(danhMuc.getMa())){
				updateMaGiaPha(danhMucId,ma,danhMuc.getMa());
			}
			if( danhMuc.getChaId() == 0  && nhomId != danhMuc.getNhomId()){
				suanhomIdConChau(danhMuc,nhomId);
			}
			DanhMucLocalServiceUtil.suaDanhMuc(danhMucId, nhomId,  ma, ten, moTa, trangThai, thuTuHienThi);
		}
	}
	public static void deleteDanhMucUpdateDisplayIndex(long selectedId) throws SystemException{
		DanhMuc danhMuc = DanhMucLocalServiceUtil.fetchDanhMuc(selectedId);
		if(danhMuc != null){
			boolean isActive = false;
			List<DanhMuc> listAnhChi = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(danhMuc.getChaId(), isActive);
			if(listAnhChi.size()>0){
				for (DanhMuc dm: listAnhChi){
					if(dm.getThuTuHienThi() > danhMuc.getThuTuHienThi()){
						dm.setThuTuHienThi(dm.getThuTuHienThi() -1);
						DanhMucLocalServiceUtil.updateDanhMuc(dm);
					}
				}
				DanhMucLocalServiceUtil.deleteDanhMuc(danhMuc);
			}
		}
	}
	
	public static void importItem(long chaId, String ten, String ma, String moTa, long nhomId, boolean trangThai, int thuTuHienThi) throws SystemException, PortalException{
		if(DanhMucLocalServiceUtil.getByT(ten) != null){
			throw new DuplicateNameException();
		}
		if(DanhMucLocalServiceUtil.getByM(ma) != null){
			throw new DuplicateCodeException();
		}
		
		int muc = 0;
		String maGiaPha = "";
		if (DanhMucLocalServiceUtil.fetchDanhMuc(chaId) != null)
		{
			DanhMuc cha = DanhMucLocalServiceUtil.fetchDanhMuc(chaId);
			muc = cha.getMuc()+1;
			if(cha.getMaGiaPha() != "" || !cha.getMaGiaPha().isEmpty()){
				maGiaPha = cha.getMaGiaPha() + "," + cha.getMa();
			}
			else maGiaPha = cha.getMa();
		}
		
		long id = CounterLocalServiceUtil.increment(DanhMuc.class.getName());
		DanhMuc danhMuc = null;
		danhMuc.setId(id);
		danhMuc.setNhomId(nhomId);
		danhMuc.setChaId(chaId);
		danhMuc.setMa(ma);
		danhMuc.setTen(ten);
		danhMuc.setMoTa(moTa);
		danhMuc.setTrangThai(trangThai);
		danhMuc.setMuc(muc);
		danhMuc.setThuTuHienThi(thuTuHienThi);
		danhMuc.setMaGiaPha(maGiaPha);
		DanhMucLocalServiceUtil.updateDanhMuc(danhMuc);
	}
//	private void suaMaGiaPhaConChau(DanhMuc item, String maMoi, String maCu) throws SystemException{
//		List<DanhMuc> listConChau = new ArrayList<DanhMuc>();
//		getListDescendantDanhMuc(item, listConChau);
//		
//		for(DanhMuc conChau :listConChau){
//			String maGiaPha = "";
//			String[] maArr = conChau.getMaGiaPha().split(",");
//			for(int i = 0; i < maArr.length; i ++){
//				if(maArr[i].equals(maCu)){
//					maArr[i] = maMoi;
//				}
//			}
//			for(int i = 0; i < maArr.length; i ++){
//				maGiaPha += maArr[i] + ",";
//			}
//			maGiaPha = maGiaPha.substring(0, maGiaPha.length()-1);
//			conChau.setMaGiaPha(maGiaPha);
//			DanhMucLocalServiceUtil.updateDanhMuc(conChau);
//		}
//	}
//	private void suanhomIdConChau(DanhMuc item, long nhomId) throws SystemException{
//		List<DanhMuc> listConChau = new ArrayList<DanhMuc>();
//		getListDescendantDanhMuc(item, listConChau);
//		for(DanhMuc conChau :listConChau){
//			conChau.setNhomId(nhomId);
//			DanhMucLocalServiceUtil.updateDanhMuc(conChau);
//		}
//	}
}
