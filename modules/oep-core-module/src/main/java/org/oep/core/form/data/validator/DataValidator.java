package org.oep.core.form.data.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oep.core.form.ActionForm;
import org.oep.core.form.data.DataChecker;
import org.oep.util.FieldUtil;

public class DataValidator {
private List<ParamValidator> paramValidators = new ArrayList<ParamValidator>();
	
	public void addChecker(String param, String htmlId, String errorMessage, DataChecker checker){
		paramValidators.add(new ParamValidator(param, htmlId, errorMessage, checker));
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, List<String>> validate(ActionForm form) throws NoSuchFieldException{
		Map<String, List<String>> errorMap = new HashMap<String, List<String>>();
		
		for(ParamValidator paramValidator : paramValidators){
			String param = paramValidator.getParam();
			String htmlId = paramValidator.getHtmlId();
			int pos = param.indexOf('.');
			
			if(pos > 0){
				String arrayName = param.substring(0, pos);
				String fieldName = param.substring(pos + 1);				
				Object arrObj = FieldUtil.getField(form, arrayName);
				
				if(arrObj instanceof List){
					List arrayContent = (List) arrObj;
					for(int i = 0; i < arrayContent.size(); i++){
						HashMap element = (HashMap) arrayContent.get(i);
						Object value = element.get(fieldName);
						String iHtmlId = htmlId.isEmpty()? "" : htmlId + "_" + i;
						
						String errorMessage = paramValidator.getValidatedMessage(value, i);
						if(errorMessage != null){
							if(errorMap.get(iHtmlId) == null){
								errorMap.put(iHtmlId, new ArrayList<String>());
							}
							errorMap.get(iHtmlId).add(errorMessage);
						}
					}
				}
			}else{
				Object value = FieldUtil.getField(form, param);
				
				String errorMessage = paramValidator.getValidatedMessage(value);
				if(errorMessage != null){
					if(errorMap.get(htmlId) == null){
						errorMap.put(htmlId, new ArrayList<String>());
					}
					errorMap.get(htmlId).add(errorMessage);
				}
			}
		}
		return errorMap;
	}
}
