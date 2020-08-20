package org.oep.danhmuc.portlet.quanly.configuration;
import aQute.bnd.annotation.metatype.Configurable;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.oep.danhmuc.portlet.quanly.action.QuanLyAction;
import org.oep.danhmuc.portlet.quanly.keys.QuanLyKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
@Component(
        configurationPid = "org.oep.danhmuc.portlet.quanly.configuration.QuanLyConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
        property = {
            "javax.portlet.name=org_oep_danhmuc_portlet_quanly_action_QuanLyAction"
        },
        service = ConfigurationAction.class
    )

public class QuanLyConfigurationAction extends DefaultConfigurationAction implements ConfigurationAction{
	Log log = LogFactoryUtil.getLog(QuanLyConfigurationAction.class);
	   @Override
	    public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
	            HttpServletResponse httpServletResponse) throws Exception {

	        httpServletRequest.setAttribute(QuanLyConfiguration.class.getName(), _quanlyConfiguration);

	        super.include(portletConfig, httpServletRequest, httpServletResponse);
	    }
		@Override
		public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
				ActionResponse actionResponse) throws Exception {
			// TODO Auto-generated method stub
			PortletPreferences prefs = actionRequest.getPreferences();
			String groupIds = ParamUtil.getString(actionRequest, QuanLyKeys.Base.GROUP_IDS);
			prefs.setValue(QuanLyKeys.Prefs.NHOM_DANH_MUC,  String.valueOf(groupIds));
			prefs.store();
		}

		public String render(PortletConfig arg0, RenderRequest arg1,
				RenderResponse arg2) throws Exception {
			// TODO Auto-generated method stub
			return "/quanlyaction/config.jsp";
		}
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		log.info("#####Calling activate() method######");
		
		_quanlyConfiguration = ConfigurableUtil.createConfigurable(QuanLyConfiguration.class, properties);
		
	}
	private volatile QuanLyConfiguration _quanlyConfiguration;  
}
