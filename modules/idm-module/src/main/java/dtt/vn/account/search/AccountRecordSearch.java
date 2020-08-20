package dtt.vn.account.search;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import dtt.vn.vnpost.model.Account;


public class AccountRecordSearch extends SearchContainer<Account>{
	public static final String EMPTY_RESULTS_MESSAGE =
			"accountrecord-empty-results-message";

	public static final int DELTA = 10;
	
	public AccountRecordSearch(
			PortletRequest portletRequest, String curParam,
			PortletURL iteratorURL) {

			super(
				portletRequest, new AccountRecordSearchTerms(portletRequest),
				new AccountRecordSearchTerms(portletRequest), curParam,
				DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

			AccountDisplayTerms displayTerms = 	(AccountDisplayTerms)getDisplayTerms();

			iteratorURL.setParameter(AccountDisplayTerms.KEYWORDS,displayTerms.getKeywords());
	}
	
	private static Log _log = LogFactoryUtil.getLog(AccountRecordSearch.class);
}
