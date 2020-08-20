package dtt.vn.user.utils;

import org.oep.core.model.ThamSo;
import org.oep.core.service.ThamSoLocalServiceUtil;

import com.google.gson.Gson;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import dtt.vn.user.service.service.util.CongDanExtraModel;
import dtt.vn.user.service.service.util.ToChucExtraModel;

public class QuanLyTaiKhoanUtil {
	private static Log log = LogFactoryUtil.getLog(QuanLyTaiKhoanUtil.class.getName()); 
	
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
	
	
	public static String getJsonFromCongDanExtraModel (CongDanExtraModel model){
		String json ="";
		try {
			Gson gson = new Gson();
			json = gson.toJson(model);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return json;
		
	}
	public static String getJsonFromToChucExtraModel (ToChucExtraModel model){
		String json ="";
		try {
			Gson gson = new Gson();
			json = gson.toJson(model);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return json;
		
	}
	public static CongDanExtraModel getModelFromJsonNoiDungCongDan(String jsonNoiDung){
		Gson gson = new Gson();
		try{
			return gson.fromJson(jsonNoiDung, CongDanExtraModel.class);
		}catch(Exception e){
			log.error(e);
		}
		return null;
	}
	public static ToChucExtraModel getModelFromJsonNoiDungToChuc(String jsonNoiDung){
		Gson gson = new Gson();
		try{
			return gson.fromJson(jsonNoiDung, ToChucExtraModel.class);
		}catch(Exception e){
			log.error(e);
		}
		return null;
	}
	
	
}
