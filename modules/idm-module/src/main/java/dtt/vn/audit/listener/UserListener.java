package dtt.vn.audit.listener;

import com.liferay.portal.kernel.audit.AuditRequestThreadLocal;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import org.osgi.service.component.annotations.Component;

import dtt.vn.account.util.DateUtil;
import dtt.vn.audit.service.AuditEventLocalServiceUtil;
import dtt.vn.vnpost.model.Account;

@Component(
		immediate = true,
	    service = ModelListener.class
	)
public class UserListener extends BaseModelListener<User>{
	private static final Configuration _configuration = ConfigurationFactoryUtil
		    .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
   @Override
public void onBeforeUpdate(User model) throws ModelListenerException {
	// TODO Auto-generated method stub
	  try {
		User usold = UserLocalServiceUtil.getUser(model.getUserId());
		String logindateold = DateUtil.parseDateToString(usold.getLoginDate(), DateUtil.DATE_FORMAT_D_M_Y_H_M_S);
		String logindatenew = DateUtil.parseDateToString(model.getLoginDate(), DateUtil.DATE_FORMAT_D_M_Y_H_M_S);
		if(!logindatenew.equals(logindateold)) {
			
			String eventType = _configuration.get("idm.vnpost.audit.massage.login").replace("[$USERNAME]", model.getScreenName());
			this.addlogLogin(model, eventType);
		}
		String loginerrordateold = DateUtil.parseDateToString(usold.getLastFailedLoginDate(), DateUtil.DATE_FORMAT_D_M_Y_H_M_S);
		String loginerrordatenew = DateUtil.parseDateToString(model.getLastFailedLoginDate(), DateUtil.DATE_FORMAT_D_M_Y_H_M_S);
		if(!loginerrordateold.equals(loginerrordatenew)) {
			
			String eventType = _configuration.get("idm.vnpost.audit.massage.loginerror").replace("[$USERNAME]", model.getScreenName());
			this.addlogLogin(model, eventType);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   super.onBeforeUpdate(model);
}
 private void addlogLogin(User us, String message) {
	 try {
		 long companyId = us.getCompanyId();
			String realUserName = UserLocalServiceUtil.getUser(us.getUserId()).getFullName();
			String eventType = message;
			String className = Account.class.getName();
			 AuditRequestThreadLocal auditRequestThreadLocal = AuditRequestThreadLocal.getAuditThreadLocal();
			String clientHost = auditRequestThreadLocal.getClientHost();
			   String clientIP = auditRequestThreadLocal.getClientIP();
			   String serverName = auditRequestThreadLocal.getServerName();
			   int serverPort = auditRequestThreadLocal.getServerPort();
			   String sessionID = auditRequestThreadLocal.getSessionID();
			   AuditEventLocalServiceUtil.addAuditEvent(companyId, us.getUserId(), us.getScreenName(), "Login", className, us.getUserId()+"", realUserName, clientHost, clientIP, serverName, serverPort, sessionID, eventType);
	} catch (Exception e) {
		// TODO: handle exception
	}
 }
}
