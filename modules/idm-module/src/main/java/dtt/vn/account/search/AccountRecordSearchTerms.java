package dtt.vn.account.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.util.ParamUtil;

public class AccountRecordSearchTerms extends AccountDisplayTerms{
	public AccountRecordSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		keywords = ParamUtil.getString(portletRequest, AccountDisplayTerms.KEYWORDS);
	}	
}
