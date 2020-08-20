package org.oep.core.form.data.checker;

import org.oep.core.form.data.DataChecker;

public abstract class NonArrayDataChecker implements DataChecker{
	public boolean validate(Object ... objs){
		return validate(objs[0]);
	}
	
	public abstract boolean validate(Object value);
}
