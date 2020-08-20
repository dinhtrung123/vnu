package org.oep.core.form.data.checker;

import java.io.File;

import org.oep.core.form.data.DataChecker;

public class DefaultDataChecker implements DataChecker{
	@Override
	public boolean validate(Object ... objs) {
		Object value = objs[0];
		if(value instanceof Integer){
			return (Integer) value > 0;
		}
		if(value instanceof Long){
			return (Long) value > 0;
		}
		if(value instanceof Boolean){
			return (Boolean) value;
		}
		if(value instanceof String){
			return !((String) value).isEmpty();
		}
		if(value instanceof File){
			File file = (File) value;
			return file != null && file.canRead(); 
		}
		return true;
	}
}
