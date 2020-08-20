package dtt.vn.account.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import dtt.vn.vnpost.model.Account;


public class AccountSearchContainer extends SearchContainer<Account> {
	public static final String EMPTY_RESULTS_MESSAGE = "No Record Found";
	public static final int DEFAULT_DELTA = 5;
	static List<String> headerNames = new ArrayList<String>();
	static {
		headerNames.add("fullName");
		headerNames.add("email");
		headerNames.add("telNo");
		headerNames.add("personalId");
		headerNames.add("address");
	}

	public AccountSearchContainer(PortletRequest portletRequest, 	PortletURL iteratorURL) {
		super(portletRequest, new AccountDisplayTerms(portletRequest),new AccountDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		AccountDisplayTerms displayTerms = (AccountDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter("fullName", "" + displayTerms.getFullName());
		iteratorURL.setParameter("email", displayTerms.getEmail());
		iteratorURL.setParameter("telNo", displayTerms.getTelNo());
		iteratorURL.setParameter("personalId", displayTerms.getPersonalId());
		iteratorURL.setParameter("address", displayTerms.getAddress());
	}
}
