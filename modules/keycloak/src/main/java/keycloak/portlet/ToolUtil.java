package keycloak.portlet;

import org.oep.core.service.ThamSoLocalServiceUtil;

import com.google.gson.Gson;


public class ToolUtil {
	public static ToolModel[] getModelFromJsonNoiDung(String jsonNoiDung){
		Gson gson = new Gson();
		try{
			return gson.fromJson(jsonNoiDung, ToolModel[].class);
		}catch(Exception e){
		}
		return null;
	}
	
	public static String getGiaTriThamSo(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	public static String getHinhThucKichHoat(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	
	public static String getMoTaThamSo(long groupId, String key){
		return ThamSoLocalServiceUtil.getValue(groupId, key)!=null?ThamSoLocalServiceUtil.getValue(groupId, key).getMoTa():"";
	}
}
