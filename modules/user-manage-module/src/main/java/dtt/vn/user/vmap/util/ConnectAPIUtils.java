package dtt.vn.user.vmap.util;

import org.oep.core.service.ThamSoLocalServiceUtil;

public class ConnectAPIUtils {
	public static String getGiaTriThamSo(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	public static String getHinhThucKichHoat(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
}
