package org.oep.core.service.util;

import com.liferay.portal.kernel.util.PrimitiveIntList;
import com.liferay.portal.kernel.util.PrimitiveLongList;

public class DataConvertUtil {
	public static long[] convertToLongArray(String source, String separate) {
		PrimitiveLongList temp = new PrimitiveLongList();
		if (source != null) {
			String[] array = source.split(separate);
			if (array != null && array.length > 0) {
				for (String item : array) {
					try {
						temp.add(Long.parseLong(item.trim().replace(".", "")));
					} catch (NumberFormatException ex) {						
					}
				}
			}
		}
		return temp.getArray();
	}
	
	public static String convertLongArrayToString(long[] arr, String seperator){
		StringBuilder builder = new StringBuilder();
		if(arr != null && arr.length>0){
			for(int i = 0; i < arr.length; i++){
				builder.append(arr[i]);
				if(i < arr.length - 1){
					builder.append(seperator);
				}
			}
		}
		return builder.toString();
	}
	
	public static int[] convertToIntArray(String source, String separate) {
		PrimitiveIntList temp = new PrimitiveIntList();
		if (source != null) {
			String[] array = source.split(separate);
			if (array != null && array.length > 0) {
				for (String item : array) {
					try {
						temp.add(Integer.parseInt(item.trim()));
					} catch (NumberFormatException ex) {						
					}
				}
			}
		}
		return temp.getArray();
	}
	
	public static String convertIntArrayToString(int[] arr, String seperator){
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
