package org.oep.core.form.data.validator;

import org.oep.core.form.data.DataChecker;

public class ParamValidator {
	private String param;
	private String htmlId;
	private String errorMessage;
	private DataChecker dataChecker;
		
	public ParamValidator(String param, String htmlId, String errorMessage, DataChecker dataChecker){
		this.param = param;
		this.htmlId = htmlId;
		this.errorMessage = errorMessage;
		this.dataChecker = dataChecker;
	}
	
	public String getParam(){
		return param;
	}
	
	public String getHtmlId() {
		return htmlId;
	}
	
	public String getValidatedMessage(Object ... objs) {
		if(!dataChecker.validate(objs)){
			return errorMessage;
		}
		return null;
	}
}
