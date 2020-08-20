package org.oep.danhmuc.util;

import com.liferay.portal.kernel.util.PrimitiveLongList;

public class DataConvertUtil {

	public static long[] convertToLongArray(String source, String separate) {
		PrimitiveLongList temp = new PrimitiveLongList();
		if (source != null) {
			String[] array = source.split(separate);
			if (array != null && array.length > 0) {
				for (String item : array) {
					try {
						temp.add(Long.parseLong(item.trim()));
					} catch (NumberFormatException ex) {						
					}
				}
			}
		}
		return temp.getArray();
	}
	
	public static String convertLongArrayToString(long[] arr, String seperator){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < arr.length; i++){
			builder.append(arr[i]);
			if(i < arr.length - 1){
				builder.append(seperator);
			}
		}
		return builder.toString();
	}
}
