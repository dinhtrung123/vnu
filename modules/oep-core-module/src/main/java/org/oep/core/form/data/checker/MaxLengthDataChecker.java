package org.oep.core.form.data.checker;

import org.oep.core.form.data.DataChecker;

public class MaxLengthDataChecker implements DataChecker{
	private int maxLength;
	public MaxLengthDataChecker(int maxLength) {
		this.maxLength = maxLength;
	}
	
	@Override
	public boolean validate(Object ... objs) {
		Object value = objs[0];
		if(value != null){
			return value.toString().length() <= maxLength;
		}
		return true;
	}
}
