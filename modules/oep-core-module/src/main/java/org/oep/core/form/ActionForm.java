package org.oep.core.form;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;

import org.oep.core.form.data.DataChecker;
import org.oep.core.form.data.validator.DataValidator;
import org.oep.util.FieldUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;

public abstract class ActionForm {
	public String redirectPage;
	public String jspPage;
	public String mvcPath;
	public String descriptionEditor;
	public String formDate;
	public String p_p_lifecycle;
	public String p_p_id;
	public String p_l_id;
	public String p_p_col_count;
	public String p_p_col_id;
	public String p_p_state;
	public String p_auth;
	public String p_p_mode;
	public String p_v_l_s_g_id;
	
	private DataValidator dataValidator = new DataValidator();
	
	public void saveForm(ActionRequest actionRequest, boolean validate) throws NoSuchFieldException{
		
		setParams(actionRequest.getParameterMap(), null);		
		if(validate){
			validate(actionRequest);
		}
	}
	
	public void saveForm(UploadPortletRequest uploadPortletRequest, ActionRequest actionRequest, boolean validate) throws NoSuchFieldException{
		Map<String, String[]>  pMap = uploadPortletRequest.getParameterMap();
		Map<String, File> fMap =getFileMap(uploadPortletRequest);
		//set file parameter
		if(fMap != null && fMap.size()>0){
			for (String fileParameter: fMap.keySet()) {
				pMap.put(fileParameter, null);
			}
		}
		//set get file
		setParams(pMap, fMap);
		if(validate){
			validate(actionRequest);
		}
	}
	
	private Map<String, File> getFileMap(UploadPortletRequest uploadPortletRequest){
		Map<String,FileItem[]> multiFiles =uploadPortletRequest.getMultipartParameterMap();		
		if(multiFiles != null && !multiFiles.isEmpty()){
			Map<String, File> fileMap = new HashMap<String, File>();
			Set<String> keys = multiFiles.keySet();
			for (String key : keys) {
				fileMap.put(key, uploadPortletRequest.getFile(key));
				
			}
			return fileMap;
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List trimArrayContent(List arrayContent){
		List trimList = new ArrayList();
		for(Object obj : arrayContent){
			HashMap element = (HashMap) obj;
			if(!element.isEmpty()){
				trimList.add(obj);
			}
		}
		return trimList;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setParams(Map<String, String[]> paramMap, Map<String, File> fileMap) throws NoSuchFieldException{
		
		Map<String, List> mapArrayParam = new HashMap<String, List>();		
		for(String param : paramMap.keySet()){
			try{
				Object value = null;
				String[] values = paramMap.get(param);
				
				if(values != null && values.length > 0){
					value = values[0];
				}
				if(values == null && fileMap != null && fileMap.containsKey(param)){
					value = fileMap.get(param);
				}
							
				if(value != null){
					int pos = param.indexOf('.');		// param ~ arrName.fieldName_i
					int pos2 = param.lastIndexOf('_');
					
					if(pos > 0 && pos2 > pos + 1){					
						String arrayName = param.substring(0, pos);
						String fieldName = param.substring(pos +1, pos2);
						int arrayIndex = GetterUtil.getInteger(param.substring(pos2 + 1), -1);
						
						if(arrayIndex >= 0){
							if(!mapArrayParam.containsKey(arrayName)){
								mapArrayParam.put(arrayName, new ArrayList());
							}
							
							List arrayContent = mapArrayParam.get(arrayName);						
							if(arrayContent.size() <= arrayIndex){
								for(int i = arrayContent.size(); i <= arrayIndex; i++){
									arrayContent.add(new HashMap<String, String>());
								}
							}
							HashMap element = (HashMap) arrayContent.get(arrayIndex);
							element.put(fieldName, value);
						}
					}else{
						FieldUtil.setField(this, param, value);
					}
				}	
			}catch(Exception e){
			
				e.printStackTrace();
			}	
		}
		
		for(String arrayName : mapArrayParam.keySet()){
			try{
				FieldUtil.setField(this, arrayName, trimArrayContent(mapArrayParam.get(arrayName)));
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}	
	
	private void validate(ActionRequest actionRequest) throws NoSuchFieldException{
		if(dataValidator != null){		
			String portletId = PortalUtil.getPortletId(actionRequest);
			List<String[]> plainErrorList = new ArrayList<String[]>();
			List<String[]> htmlErrorList = new ArrayList<String[]>();
			Map<String, List<String>> errorMap = dataValidator.validate(this);
			
			for(String htmlId : errorMap.keySet()){
				for(int i = 0; i < errorMap.get(htmlId).size(); i++){
					String errorMessage = errorMap.get(htmlId).get(i);
					String errorKey = "";
					
					if(htmlId.isEmpty()){
						errorKey = portletId + "._plain_." + (i+1);
						plainErrorList.add(new String[]{errorKey, errorMessage});
					}else{
						errorKey = portletId + "." + htmlId + "." + (i+1);
						htmlErrorList.add(new String[]{htmlId, errorKey, errorMessage });
					}
					
					SessionErrors.add(actionRequest, errorKey);
					
				}
			}
			actionRequest.setAttribute("plainErrorList", plainErrorList);
			actionRequest.setAttribute("htmlErrorList", htmlErrorList);
		}
	}
	
	public void addValidator(String param, String htmlId, String errorMessage, DataChecker checker){
		dataValidator.addChecker(param, htmlId, errorMessage, checker);
	}
	
	public void addValidator(String param, String errorMessage, DataChecker checker){
		dataValidator.addChecker(param, param, errorMessage, checker);
	}
}
