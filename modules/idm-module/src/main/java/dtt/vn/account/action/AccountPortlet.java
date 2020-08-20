/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dtt.vn.account.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.bind.DatatypeConverter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import dtt.vn.account.business.AccountBusiness;
import dtt.vn.account.business.Constantes;
import dtt.vn.account.util.AccountEnum;
import dtt.vn.account.util.AccountUtil;
import dtt.vn.account.util.MessageUtils;
import dtt.vn.account.util.QRUtils;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;
import dtt.vn.vnpost.service.WorkItemLocalServiceUtil;
import org.apache.commons.lang3.EnumUtils;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=IdmPortlet",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.header-portlet-css=/css/bootstrap-datetimepicker.min.css",
        "com.liferay.portlet.header-portlet-css=/css/bootstrap.min.css",
        "com.liferay.portlet.header-portlet-css=/css/bootstrapValidator.min.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/jQueryRotate.js",
        "com.liferay.portlet.footer-portlet-javascript=/js/bootstrap-datetimepicker.min.js",
        "com.liferay.portlet.footer-portlet-javascript=/js/bootstrap.min.js",
        "com.liferay.portlet.footer-portlet-javascript=/js/bootstrapValidator.min.js",
        "com.liferay.portlet.footer-portlet-javascript=/js/jquery-2.1.3.min.js",
        "javax.portlet.name=account",
        "javax.portlet.display-name=Account",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=administrator,guest,power-user,user",
        "javax.portlet.init-param.view-template=/accountportlet/view.jsp"
    },
    service = Portlet.class
)
public class AccountPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest,	RenderResponse renderResponse) throws PortletException, IOException {

		try {

			AccountUtil.getAccount(renderRequest);
			

			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void serveResource(ResourceRequest resourceRequest,	ResourceResponse resourceResponse) throws IOException,
			PortletException {
		PrintWriter writer = resourceResponse.getWriter();
		String resourceId  = resourceRequest.getResourceID();
		String cmd         = ParamUtil.getString(resourceRequest, Constants.CMD);
		
		if (cmd.equalsIgnoreCase("checkDuplicate")) { 
			String emailAddress = ParamUtil.getString(resourceRequest, "emailAddress");
			long accountId = ParamUtil.getLong(resourceRequest, "accountId");
	        writer.println(AccountLocalServiceUtil.isEmailExists(accountId, emailAddress));
	        writer.flush();
		}
		
		if (cmd.equalsIgnoreCase("personalIdcheckDuplicate")) { 

			String personalId = ParamUtil.getString(resourceRequest, "personalId");
			long accountId = ParamUtil.getLong(resourceRequest, "accountId");
	        writer.println(AccountLocalServiceUtil.ispersonalIdExists(accountId, personalId));
	        writer.flush();
		}
		if(resourceId.equals("viewqrcode")) {
			String dataqr = ParamUtil.getString(resourceRequest, "dataqr","");
			byte[] qrCode = QRUtils.generateQRCodeImage(dataqr, 500, 500);
			 String base64qr = DatatypeConverter.printBase64Binary(qrCode);
	            writer.write(base64qr);
		}
		
		
    }	
	

	
	public void saveAccount(ActionRequest request, ActionResponse response) {
	    try {
        	doAddAccout(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(request, "aceitem-add-tech-error");
            
            PortalUtil.copyRequestParameters(request, response);
            MessageUtils.hideDefualtErrorMessage(request);
            response.setRenderParameter("jspPage", "/accountportlet/view.jsp");
            
        }		  
	  
	}
	
	
	public void reOpen(ActionRequest request, ActionResponse response) throws SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    	long accountId = ParamUtil.getLong(request, "accountId");
    	String comment = ParamUtil.getString(request, "comment");
    	Account account = AccountLocalServiceUtil.fetchAccount(accountId);
		account.setAccountStatus(Constantes.XuLy.DOI_PHAN_CONG);
		account.setProcessStatus(Constantes.Status.DANG_XAC_MINH);
		account.setModifiedDate(new Date());
    	account.setAssignUserId(themeDisplay.getUserId());
    	account.setReOpen(true);
    	AccountLocalServiceUtil.updateAccount(account);
    	WorkItem workItem = null; 
		workItem = WorkItemLocalServiceUtil.createWorkItem();
		workItem.setGroupId(themeDisplay.getLayout().getGroupId());
		workItem.setCreateDate(new Date());
		workItem.setStartTime(new Date());
		workItem.setEndTime(new Date());
		workItem.setTitle("Yêu cầu xác minh lại");
		workItem.setStatus("COMPLETE");
		workItem.setAccountId(account.getAccountId());
		workItem.setUserId(themeDisplay.getUserId());
		workItem.setStatusResponse(comment);
		WorkItemLocalServiceUtil.addWorkItem(workItem);
		//insert new Item
		workItem = WorkItemLocalServiceUtil.createWorkItem();
		workItem.setGroupId(themeDisplay.getLayout().getGroupId());
		workItem.setCreateDate(new Date());
		workItem.setStartTime(new Date());
		
		workItem.setTitle("Phân công hồ sơ");
		workItem.setStatus("NEW");
		workItem.setAccountId(account.getAccountId());			
		WorkItemLocalServiceUtil.addWorkItem(workItem);
		MessageUtils.hideDefualtErrorMessage(request);		
	}
	
	  private void doAddAccout(ActionRequest request, ActionResponse response) throws Exception {
		  long accountId = ParamUtil.getLong(request, "accountId");
		  System.out.println(accountId+"  accountid");
		  Account account = null;
		  account.setAccountId(ParamUtil.getLong(request,"accountId",0L));
		  ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		  AccountBusiness.accountFromRequest(request, account);
		  if (account.getAccountId() == 0) {
			WorkItem workItem = null;  
			AccountLocalServiceUtil.addAccount(account);
			//long hoSoId =  AccountBusiness.addUpdateHoSo(groupId, userId, account);
			//account.setHoSoId(hoSoId);
			account.setCompanyId(themeDisplay.getCompanyId());
			account.setGroupId(themeDisplay.getLayout().getGroupId());
			account.setUserId(themeDisplay.getUserId());
			account.setCreateDate(new Date());
			account.setModifiedDate(new Date());
			account.setMessage(doAddMeassage());
			account.setAccountStatus(Constantes.XuLy.DOI_PHAN_CONG);
			account.setProcessStatus(Constantes.Status.DANG_XAC_MINH);
			AccountLocalServiceUtil.updateAccount(account);  
			workItem = WorkItemLocalServiceUtil.createWorkItem();
			workItem.setGroupId(themeDisplay.getLayout().getGroupId());
			workItem.setCreateDate(new Date());
			workItem.setStartTime(new Date());
			workItem.setEndTime(new Date());
			workItem.setTitle("Tạo mới");
			workItem.setStatus("COMPLETE");
			workItem.setAccountId(account.getAccountId());
			workItem.setUserId(themeDisplay.getUserId());
			WorkItemLocalServiceUtil.addWorkItem(workItem);
			//insert new Item
			workItem = WorkItemLocalServiceUtil.createWorkItem();
			workItem.setGroupId(themeDisplay.getLayout().getGroupId());
			workItem.setCreateDate(new Date());
			workItem.setStartTime(new Date());
			
			workItem.setTitle("Phân công hồ sơ");
			workItem.setStatus("NEW");
			workItem.setAccountId(account.getAccountId());			
			WorkItemLocalServiceUtil.addWorkItem(workItem);
			
		  } else {
				account.setCompanyId(themeDisplay.getCompanyId());
				account.setGroupId(themeDisplay.getLayout().getGroupId());
				account.setUserId(themeDisplay.getUserId());
				account.setModifiedDate(new Date());
				//account.setMessage(doAddMeassage());
				//account.setAccountStatus(Constantes.XuLy.DOI_PHAN_CONG);
				//account.setProcessStatus(Constantes.Status.DANG_XAC_MINH);

			  AccountLocalServiceUtil.updateAccount(account);  
		  }
		  MessageUtils.hideDefualtSuccessMessage(request);
		  response.setRenderParameter("jspPage", "/accountportlet/view.jsp");
	  }
	  
	  private String doAddMeassage() throws Exception {
		  JSONObject additionalInfo = JSONFactoryUtil.createJSONObject();
/*          ArrayList<String> al = new ArrayList<String>();
          try {
              DataSource dataSource = (DataSource) PortalBeanLocatorUtil.locate("liferayDataSource");
              Connection connection =  dataSource.getConnection();
              DatabaseMetaData md = connection.getMetaData();
              ResultSet rs = md.getTables(null, null, "%", null);
              while (rs.next()) {
                 String tableVal = rs.getString(3);
                 if(tableVal.equalsIgnoreCase("idm_account"))
                 {
                     ResultSet cols = md.getColumns(null, null, rs.getString(3), null);
                     while(cols.next()){
                         String str = cols.getString(4);
                         if( EnumUtils.isValidEnum(AccountEnum.class, str) ){
                            al.add(str);
                         }   
                     }  
                 }
             }
          } catch (SQLException e) {
              System.out.println("SQLException: "+ e.getMessage());
          }
          
          Iterator<String> itr = al.iterator();*/
          for(AccountEnum env : AccountEnum.values()) 
          {
          	additionalInfo.put(env.name(), "false");
       
          }            
          
          		  
		  return additionalInfo.toString();
	  }
	  public void deletarAccount(ActionRequest request, ActionResponse response) throws SystemException {
			long accountId = ParamUtil.getLong(request, "accountId");
			
			try {
				AccountLocalServiceUtil.deleteAccount(accountId);
				SessionMessages.add(request, "event-deleted-successfuly");
				MessageUtils.hideDefualtSuccessMessage(request);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		  
	  }

		public boolean checkPermission(String actionId,RenderRequest request)
		{
			 boolean result=false;
			 ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			 long groupId = themeDisplay.getScopeGroupId();
			 String name = PortalUtil.getPortletId(request);
			 String primKey = themeDisplay.getLayout().getPlid() + LiferayPortletSession.LAYOUT_SEPARATOR + name;
			 PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
			 result = permissionChecker.hasPermission(groupId, name, primKey, actionId);
			 return result;
		}
	  
	  public static void main(String[] args) {
	     AccountEnum accountEnum = null;
	     String str ="telNo";
	     if( EnumUtils.isValidEnum(AccountEnum.class, str) ){
	    	 accountEnum = AccountEnum.valueOf(str);
	    	 System.out.println("Hello World!" +accountEnum);
	    	}
		 
	    }
}