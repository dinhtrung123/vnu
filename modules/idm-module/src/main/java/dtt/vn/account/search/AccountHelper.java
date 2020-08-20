package dtt.vn.account.search;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.configuration.servlet.ServletServiceContextComponentConfiguration;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;

import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;


public class AccountHelper {
	
	public static List < Account > getAccount(AccountDisplayTerms displayTerms, int start, int end) throws SystemException {
		  List < Account > AccountList = getAccountData(displayTerms.isAdvancedSearch(), displayTerms.isAndOperator(), displayTerms.getFullName(), displayTerms.getEmail(), 
				  displayTerms.getTelNo(), displayTerms.getPersonalId(), displayTerms.getAddress(), displayTerms.getKeywords());
		  return ListUtil.subList(AccountList, start, end);
		 }
		 public static int getTotalAccountCount(AccountDisplayTerms displayTerms, int start, int end) throws SystemException {
		  return getAccountData(displayTerms.isAdvancedSearch(), displayTerms.isAndOperator(), displayTerms.getFullName(), displayTerms.getEmail(), 
				  displayTerms.getTelNo(), displayTerms.getPersonalId(), displayTerms.getAddress(), displayTerms.getKeywords()).size();
		 }

		 public static List < Account > getAccountData(boolean isAdvancedSearch, boolean isAndOperator, String fullname, 
				 String email,String telNo, String personalId, String address, String keywords) throws SystemException {
		  List < Account > AccountList = Collections.EMPTY_LIST;

		  if ((Validator.isBlank(keywords)) && (!isAdvancedSearch)) { // No search
		   AccountList = AccountLocalServiceUtil.getAccounts(0, AccountLocalServiceUtil.getAccountsCount());
		  } else {
		   ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ServletServiceContextComponentConfiguration.class.getName(), "portletClassLoader");
		   DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Account.class, classLoader);
		   Junction junction = null;
		   if (isAdvancedSearch) { // Advance Search
		    if (isAndOperator) {
			     System.out.println("All means And");
			     junction = RestrictionsFactoryUtil.conjunction();
			    } else {
			     System.out.println("Any means OR");
			     junction = RestrictionsFactoryUtil.disjunction();
			    }
			    if (!Validator.isBlank(fullname)) {
			     junction.add(PropertyFactoryUtil.forName("fullname").like("%" + fullname + "%"));
			    }
			    if (!Validator.isBlank(email)) {
			        junction.add(PropertyFactoryUtil.forName("email").like("%" + email + "%"));
			       }
			    if (!Validator.isBlank(telNo)) {
			        junction.add(PropertyFactoryUtil.forName("telNo").like("%" + telNo + "%"));
			       }
			    if (!Validator.isBlank(personalId)) {
			        junction.add(PropertyFactoryUtil.forName("personalId").like("%" + personalId + "%"));
			       }
			    if (!Validator.isBlank(address)) {
			        junction.add(PropertyFactoryUtil.forName("address").like("%" + address + "%"));
			       }
			    

		   } else { // Normal Search
			    junction = RestrictionsFactoryUtil.disjunction();
			    Criterion c1 = PropertyFactoryUtil.forName("fullName").like("%" + keywords + "%");
			    junction.add(c1);
			    //
			    Criterion c2 = PropertyFactoryUtil.forName("telNo").like("%" + keywords + "%");
			    junction.add(c2);
			    //
			    Criterion c3 = PropertyFactoryUtil.forName("personalId").like("%" + keywords + "%");
			    junction.add(c3);
			    //
			    Criterion c4 = PropertyFactoryUtil.forName("address").like("%" + keywords + "%");
			    junction.add(c4);

			    Criterion c5 = PropertyFactoryUtil.forName("email").like("%" + keywords + "%");
			    junction.add(c5);
			    
		   }
		   dynamicQuery.add(junction);
		   AccountList = AccountLocalServiceUtil.dynamicQuery(dynamicQuery);
		  }
		  return AccountList;
		 }


		 
		 public static List < Account > getAccountData(String keywords, int status, long userId) throws SystemException {
		  List < Account > AccountList = Collections.EMPTY_LIST;
		  ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ServletServiceContextComponentConfiguration.class.getName(), "portletClassLoader");
		  DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Account.class, classLoader);
		  Junction junction = RestrictionsFactoryUtil.disjunction();
		  Junction andjunction = RestrictionsFactoryUtil.conjunction();
		  Criterion equalStatus = PropertyFactoryUtil.forName("processStatus").eq(status);  

		  if ((Validator.isBlank(keywords))) { // No search
			    if (userId > 0) {
				    Criterion c6 = PropertyFactoryUtil.forName("assignUserId").eq(userId);
				    andjunction.add(c6);
					
				}	  
			  andjunction.add(equalStatus);
			  dynamicQuery.add(andjunction);
			  AccountList = AccountLocalServiceUtil.dynamicQuery(dynamicQuery);
		  } else {

		   // Normal Search
			    junction = RestrictionsFactoryUtil.disjunction();
			    Criterion c1 = PropertyFactoryUtil.forName("fullName").like("%" + keywords + "%");
			    junction.add(c1);
			    //
			    Criterion c2 = PropertyFactoryUtil.forName("telNo").like("%" + keywords + "%");
			    junction.add(c2);
			    //
			    Criterion c3 = PropertyFactoryUtil.forName("personalId").like("%" + keywords + "%");
			    junction.add(c3);
			    //
			    Criterion c4 = PropertyFactoryUtil.forName("address").like("%" + keywords + "%");
			    junction.add(c4);

			    Criterion c5 = PropertyFactoryUtil.forName("email").like("%" + keywords + "%");
			    junction.add(c5);
			    if (userId > 0) {
				    Criterion c6 = PropertyFactoryUtil.forName("assignUserId").eq(userId);
				    junction.add(c6);
					
				}
			    
		   
			    dynamicQuery.add(junction);
			    andjunction.add(equalStatus);
			    dynamicQuery.add(andjunction);
			    AccountList = AccountLocalServiceUtil.dynamicQuery(dynamicQuery);
		  }
		  return AccountList;
		 }

		 public static int getTotalAccountCountByStatus(AccountRecordSearchTerms displayTerms, int status, long userId,  int start, int end) throws SystemException {
			  return getAccountData(displayTerms.getKeywords(), status, userId).size();
			 }

		 public static List < Account > getAccountByStatus(AccountRecordSearchTerms displayTerms, int status, long userId, int start, int end) throws SystemException {
		  List < Account > AccountList = getAccountData(displayTerms.getKeywords(), status, userId);
		  return ListUtil.subList(AccountList, start, end);
		 }
}
