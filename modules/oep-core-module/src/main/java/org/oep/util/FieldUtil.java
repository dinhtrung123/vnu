package org.oep.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

public class FieldUtil {
private static Log log = LogFactoryUtil.getLog(FieldUtil.class);
	
	@SuppressWarnings("rawtypes")
	public static boolean setField(Class cl, Object obj, String fieldName, Object value) throws NoSuchFieldException {
		Field field = cl.getDeclaredField(fieldName);
		field.setAccessible(true);
		try {				
			Class dataType = field.getType();
			if(dataType.equals(long.class)){						
				field.set(obj, GetterUtil.getLong(value));					 				
			}else if(dataType.equals(int.class)){
				field.set(obj, GetterUtil.getInteger(value));
			}else if(dataType.equals(boolean.class)){					
				field.set(obj, GetterUtil.getBoolean(value));
			}else{
				field.set(obj, value);
			}
			return true;
		} catch (IllegalArgumentException e) {			
		} catch (IllegalAccessException e){			
		}
		return false;
	}
			
	public static boolean setField(Object obj, String fieldName, Object value) throws NoSuchFieldException {		
		
		if(!fieldName.contains(".")){
			try{
				return setField(obj.getClass().getSuperclass().getSuperclass(), obj, fieldName, value);				
			}catch(Exception e){			
			}
			
			try{
				return setField(obj.getClass().getSuperclass(), obj, fieldName, value);				
			}catch(Exception e){			
			}
			
			return setField(obj.getClass(), obj, fieldName, value);
		}
		return false;
	}	
	
	@SuppressWarnings("rawtypes")
	private static Object getField(Class cl, Object obj, String fieldName) throws NoSuchFieldException{
		Field field = cl.getDeclaredField(fieldName);
		field.setAccessible(true);
		try {
			return field.get(obj);
		} catch (IllegalArgumentException e) {
		} catch(IllegalAccessException e){
		}
		return null;
	}
	
	public static Object getField(Object obj, String fieldName) throws NoSuchFieldException {
		if(!fieldName.contains(".")){
			try{
				return getField(obj.getClass().getSuperclass().getSuperclass(), obj, fieldName);
			}catch(Exception e){			
			}
			
			try{
				return getField(obj.getClass().getSuperclass(), obj, fieldName);
			}catch(Exception e){			
			}
			
			return getField(obj.getClass(), obj, fieldName);
		}
		return null;
	}
	public static String[] getFieldName(Object obj){
		if(obj != null){
			Field[] fields =obj.getClass().getDeclaredFields();
			String [] values = new String[fields.length-2];
			int i=0;
			log.debug("Object:"+obj.getClass().getName());
			for (Field field:fields) {
				String val =field.getName();
				if(val.indexOf("Model") ==-1 
						&& val.indexOf("Class") ==-1){					
					if(val.indexOf("_")!=-1){
						val =StringUtil.replaceAll(val, "_", "");
					}
					values[i] =val;	
					log.debug(i+"."+val);
					i++;
				}
			}
			return values;
		}
		return null;
	}
	
	public static Object getFieldValue(Object obj, String fieldName){
		try{
			Field field = obj.getClass().getDeclaredField(fieldName);
			if(field !=null){
				field.setAccessible(true);
				return field.get(obj);
			}
		} catch(NoSuchFieldException e){
			//log.debug("No field \"" + fieldName + "\" for class " + obj.getClass().getName()+":"+e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		}
		
		String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
		//log.debug(methodName);
		try{			
			Method method = obj.getClass().getMethod(methodName);
			Object value = method.invoke(obj);			
			return value;
		} catch(NoSuchMethodException e){
			//log.error("No method \"" + methodName + "\" for class " + obj.getClass().getName());			
		} catch(IllegalArgumentException e){
			log.error(e);
		}catch (IllegalAccessException e) {
			log.error(e);
		} catch (InvocationTargetException e) {
			log.error(e);
		}
		
		methodName = "is" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
		try{
			Method method = obj.getClass().getMethod(methodName);
			return method.invoke(obj);
		} catch(NoSuchMethodException e){
			//log.error("No method \"" + methodName + "\" for class " + obj.getClass().getName());			
		} catch(IllegalArgumentException e){
			log.error(e);
		}catch (IllegalAccessException e) {
			log.error(e);
		} catch (InvocationTargetException e) {
			log.error(e);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public static long[] getArrayLongField(List data, String fieldName){
		if(data == null) return null;
		long[] fieldData = new long[data.size()];
		for(int i = 0; i < fieldData.length; i++){
			if(data.get(i) != null){
				fieldData[i] = (Long) getFieldValue(data.get(i), fieldName);
			}else{
				fieldData[i] = 0l;
			}
		}
		return fieldData;
	}

	@SuppressWarnings("rawtypes")
	public static int[] getArrayIntField(List data, String fieldName){
		int[] fieldData = new int[data.size()];
		for(int i = 0; i < fieldData.length; i++){
			if(data.get(i) != null){
				fieldData[i] = (Integer) getFieldValue(data.get(i), fieldName);
			}else{
				fieldData[i] = 0;
			}
		}
		return fieldData;
	}
	
	public static double[] getArrayDoubleField(List data, String fieldName){
		double[] fieldData = new double[data.size()];
		for(int i = 0; i < fieldData.length; i++){
			if(data.get(i) != null){
				Object obj = getFieldValue(data.get(i), fieldName);
				fieldData[i] = Double.valueOf(obj.toString());
			}else{
				fieldData[i] = 0;
			}
		}
		return fieldData;
	}
	
	@SuppressWarnings("rawtypes")
	public static String[] getArrayStringField(List data, String fieldName){
		String[] fieldData = new String[data.size()];
		for(int i = 0; i < fieldData.length; i++){
			if(data.get(i) != null){
				fieldData[i] = (String) getFieldValue(data.get(i), fieldName);
			}else{
				fieldData[i] = "";
			}
		}
		return fieldData;
	}
	
	public static String getStringField(List data, String fieldName,String split){
		if(data != null && fieldName != null && split != null){
			StringBuffer result = new StringBuffer("");
			for(int i = 0; i < data.size(); i++){
				Object obj = data.get(i);
				if(i==0){
					result.append(String.valueOf(getFieldValue(obj, fieldName)));
				}else{
					result.append(split+String.valueOf(getFieldValue(obj, fieldName)));
				}
			
			}
			return result.toString();
		}
		return "";
	}
	
	public static Map<String, Object> getObjectProjector(Object obj, String[] fieldsName){
		Map<String, Object> projector = new HashMap<String, Object>();
		for(String fieldName : fieldsName){
			//log.debug("class:"+obj.getClass().getName()+":"+fieldName);			
			projector.put(fieldName, getFieldValue(obj, fieldName));
		}
		return projector;
	}
	
	@SuppressWarnings("rawtypes")
	public static Map[] getListProjector(List list, String[] fieldsName){
		Map[] projector = new Map[list.size()];
		for(int i = 0; i < list.size(); i++){			
			projector[i] = getObjectProjector(list.get(i), fieldsName);
		}
		return projector;
	}
}
