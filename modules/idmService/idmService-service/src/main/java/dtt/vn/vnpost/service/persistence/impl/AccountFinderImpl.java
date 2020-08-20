package dtt.vn.vnpost.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.impl.AccountImpl;
import dtt.vn.vnpost.service.persistence.AccountFinder;

public class AccountFinderImpl extends AccountFinderBaseImpl implements AccountFinder {
	private static Log log = LogFactoryUtil.getLog(AccountFinderImpl.class);
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;

	private static String SEARCH_ITEM = AccountFinderImpl.class.getName() + ".searchByStatus";
	private static String COUNT_ITEM = AccountFinderImpl.class.getName() + ".countByStatus";

	private static String SEARCH_DANHSACH = AccountFinderImpl.class.getName() + ".searchForDanhSach";
	private static String COUNT_DANHSACH = AccountFinderImpl.class.getName() + ".countForDanhSach";
	private static String SEARCH_ACCOUNT = AccountFinderImpl.class.getName() + ".searchAccount";
	private static String COUNT_ACCOUNT = AccountFinderImpl.class.getName() + ".countAccount";
	private static String COUNT_XACMINH = AccountFinderImpl.class.getName() + ".countForXacMinh";
	private static String SEARCH_XACMINH = AccountFinderImpl.class.getName() + ".searchForXacMinh";
	private static String COUNT_PHEDUYET = AccountFinderImpl.class.getName() + ".countForPheDuyet";
	private static String SEARCH_PHEDUYET = AccountFinderImpl.class.getName() + ".searchForPheDuyet";
	
	
	public List<Account> searchAccountForAPI (String keyword,int tinhtrang,String email, String userName, String fullName, String telNo, int start, int end){
		Session session = null;
		try {
			String strQuery = _customSQL.get(getClass(), SEARCH_ACCOUNT);
			List<Object> params = new ArrayList<Object>();
			
			if (Validator.isNotNull(keyword)) {
				strQuery = strQuery.replace("[$KEYWORD$]", "AND ( LOWER(tf.fullName) like LOWER(?))");
				params.add("%" + keyword + "%");
			} else {
				strQuery = strQuery.replace("[$KEYWORD$]", "");
			}
			
			if (tinhtrang > 0) {
				strQuery = strQuery.replace("[$TINHTRANG$]", " AND tf.accountStatus = ?");
				params.add(tinhtrang);
			} else {
				strQuery = strQuery.replace("[$TINHTRANG$]", "");
			}
			
			
			if (Validator.isNotNull(email)) {
				strQuery = strQuery.replace("[$EMAIL$]", "AND ( LOWER(tf.email) like LOWER(?))");
				params.add("%" + email + "%");
			} else {
				strQuery = strQuery.replace("[$EMAIL$]", "");
			}
			if (Validator.isNotNull(userName)) {
				strQuery = strQuery.replace("[$USERNAME$]", "AND ( LOWER(tf.accountName) like LOWER(?))");
				params.add("%" + userName + "%");
			} else {
				strQuery = strQuery.replace("[$USERNAME$]", "");
			}
			if (Validator.isNotNull(fullName)) {
				strQuery = strQuery.replace("[$FULLNAME$]", "AND ( LOWER(tf.fullName) like LOWER(?))");
				params.add("%" + fullName + "%");
			} else {
				strQuery = strQuery.replace("[$FULLNAME$]", "");
			}
			if (Validator.isNotNull(telNo)) {
				strQuery = strQuery.replace("[$TELNO$]", "AND ( LOWER(tf.telNo) like LOWER(?))");
				params.add("%" + telNo + "%");
			} else {
				strQuery = strQuery.replace("[$TELNO$]", "");
			}
			
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			query.addEntity("Account", AccountImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}
			return (List<Account>) QueryUtil.list(query, getDialect(), start, end);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}
		return null;
		
	}
	public int countAccountForAPI (String keyword,int tinhtrang,String email, String userName, String fullName, String telNo){
		String strQuery = _customSQL.get(getClass(), COUNT_ACCOUNT);
		List<Object> params = new ArrayList<Object>();
		
		if (Validator.isNotNull(keyword)) {
			strQuery = strQuery.replace("[$KEYWORD$]", "AND ( LOWER(tf.fullName) like LOWER(?))");
			params.add("%" + keyword + "%");
		} else {
			strQuery = strQuery.replace("[$KEYWORD$]", "");
		}
		
		if (tinhtrang > 0) {
			strQuery = strQuery.replace("[$TINHTRANG$]", " AND tf.accountStatus = ?");
			params.add(tinhtrang);
		} else {
			strQuery = strQuery.replace("[$TINHTRANG$]", "");
		}
		
		
		if (Validator.isNotNull(email)) {
			strQuery = strQuery.replace("[$EMAIL$]", "AND ( LOWER(tf.email) like LOWER(?))");
			params.add("%" + email + "%");
		} else {
			strQuery = strQuery.replace("[$EMAIL$]", "");
		}
		if (Validator.isNotNull(userName)) {
			strQuery = strQuery.replace("[$USERNAME$]", "AND ( LOWER(tf.accountName) like LOWER(?))");
			params.add("%" + userName + "%");
		} else {
			strQuery = strQuery.replace("[$USERNAME$]", "");
		}
		if (Validator.isNotNull(fullName)) {
			strQuery = strQuery.replace("[$FULLNAME$]", "AND ( LOWER(tf.fullName) like LOWER(?))");
			params.add("%" + fullName + "%");
		} else {
			strQuery = strQuery.replace("[$FULLNAME$]", "");
		}
		if (Validator.isNotNull(telNo)) {
			strQuery = strQuery.replace("[$TELNO$]", "AND ( LOWER(tf.telNo) like LOWER(?))");
			params.add("%" + telNo + "%");
		} else {
			strQuery = strQuery.replace("[$TELNO$]", "");
		}
		
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}

			return Integer.valueOf(String.valueOf(query.uniqueResult()));
		} finally {
			if (session != null) {
				closeSession(session);
			}

		}
		
	}
	
	public List<Account> searchForDanhSach(String keyword,int hinhthucdangky,String sogiayto,String tungay,String denngay,String sodienthoai,String tentaikhoan,int loaidoituong,String canboxacminh,int tinhtrang,
			int start, int end) {
		Session session = null;
		try {
			String strQuery = _customSQL.get(getClass(), SEARCH_DANHSACH);
			List<Object> params = new ArrayList<Object>();
			if (Validator.isNotNull(keyword)) {
				strQuery = strQuery.replace("[$KEYWORD$]", "AND ( LOWER(tf.fullName) like LOWER(?))");
				params.add("%" + keyword + "%");
			} else {
				strQuery = strQuery.replace("[$KEYWORD$]", "");
			}

			if (hinhthucdangky > -1) {
				strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", " AND tf.hinhthucdangky = ?");
				params.add(hinhthucdangky);
			} else {
				strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", "");
			}
			if (Validator.isNotNull(sogiayto)) {
				strQuery = strQuery.replace("[$SOGIAYTO$]", " AND tf.personalId = ?");
				params.add(sogiayto);
			} else {
				strQuery = strQuery.replace("[$SOGIAYTO$]", "");
			}
			if (Validator.isNotNull(tungay)) {
				strQuery = strQuery.replace("[$TUNGAY$]", " AND tf.createDate > ?");
				params.add(tungay);
			} else {
				strQuery = strQuery.replace("[$TUNGAY$]", "");
			}
			if (Validator.isNotNull(denngay)) {
				strQuery = strQuery.replace("[$DENNGAY$]", " AND tf.createDate < ?");
				params.add(denngay);
			} else {
				strQuery = strQuery.replace("[$DENNGAY$]", "");
			}
			if (Validator.isNotNull(sodienthoai)) {
				strQuery = strQuery.replace("[$SODIENTHOAI$]", " AND tf.telNo = ?");
				params.add(sodienthoai);
			} else {
				strQuery = strQuery.replace("[$SODIENTHOAI$]", "");
			}
			if (Validator.isNotNull(tentaikhoan)) {
				strQuery = strQuery.replace("[$TENTAIKHOAN$]", " AND tf.accountName = ?");
				params.add(tentaikhoan);
			} else {
				strQuery = strQuery.replace("[$TENTAIKHOAN$]", "");
			}
			if (loaidoituong > -1) {
				strQuery = strQuery.replace("[$LOAIDOITUONG$]", " AND tf.accountType = ?");
				params.add(loaidoituong);
			} else {
				strQuery = strQuery.replace("[$LOAIDOITUONG$]", "");
			}
			if (tinhtrang > 0) {
				strQuery = strQuery.replace("[$TINHTRANG$]", " AND tf.accountStatus = ?");
				params.add(tinhtrang);
			} else {
				strQuery = strQuery.replace("[$TINHTRANG$]", "");
			}
			if (Validator.isNotNull(canboxacminh)) {
				strQuery = strQuery.replace("[$CANBOXACMINH$]", " AND tf.canboxacminh = ?");
				params.add(tentaikhoan);
			} else {
				strQuery = strQuery.replace("[$CANBOXACMINH$]", "");
			}
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			query.addEntity("Account", AccountImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}
			return (List<Account>) QueryUtil.list(query, getDialect(), start, end);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}
		return null;
	}
	public int countForDanhSach(String keyword,int hinhthucdangky,String sogiayto,String tungay,String denngay,String sodienthoai,String tentaikhoan,int loaidoituong,String canboxacminh,int tinhtrang) {
		String strQuery = _customSQL.get(getClass(), COUNT_DANHSACH);
		List<Object> params = new ArrayList<Object>();
		if (Validator.isNotNull(keyword)) {
			strQuery = strQuery.replace("[$KEYWORD$]", "AND ( LOWER(tf.fullName) like LOWER(?))");
			params.add("%" + keyword + "%");
		} else {
			strQuery = strQuery.replace("[$KEYWORD$]", "");
		}

		if (hinhthucdangky > -1) {
			strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", " AND tf.hinhthucdangky = ?");
			params.add(hinhthucdangky);
		} else {
			strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", "");
		}
		if (Validator.isNotNull(sogiayto)) {
			strQuery = strQuery.replace("[$SOGIAYTO$]", " AND tf.personalId = ?");
			params.add(sogiayto);
		} else {
			strQuery = strQuery.replace("[$SOGIAYTO$]", "");
		}
		if (Validator.isNotNull(tungay)) {
			strQuery = strQuery.replace("[$TUNGAY$]", " AND tf.createDate > ?");
			params.add(tungay);
		} else {
			strQuery = strQuery.replace("[$TUNGAY$]", "");
		}
		if (Validator.isNotNull(denngay)) {
			strQuery = strQuery.replace("[$DENNGAY$]", " AND tf.createDate < ?");
			params.add(denngay);
		} else {
			strQuery = strQuery.replace("[$DENNGAY$]", "");
		}
		if (Validator.isNotNull(sodienthoai)) {
			strQuery = strQuery.replace("[$SODIENTHOAI$]", " AND tf.telNo = ?");
			params.add(sodienthoai);
		} else {
			strQuery = strQuery.replace("[$SODIENTHOAI$]", "");
		}
		if (Validator.isNotNull(tentaikhoan)) {
			strQuery = strQuery.replace("[$TENTAIKHOAN$]", " AND tf.accountName = ?");
			params.add(tentaikhoan);
		} else {
			strQuery = strQuery.replace("[$TENTAIKHOAN$]", "");
		}
		if (loaidoituong > -1) {
			strQuery = strQuery.replace("[$LOAIDOITUONG$]", " AND tf.accountType = ?");
			params.add(loaidoituong);
		} else {
			strQuery = strQuery.replace("[$LOAIDOITUONG$]", "");
		}
		if (tinhtrang > 0) {
			strQuery = strQuery.replace("[$TINHTRANG$]", " AND tf.accountStatus = ?");
			params.add(tinhtrang);
		} else {
			strQuery = strQuery.replace("[$TINHTRANG$]", "");
		}
		if (Validator.isNotNull(canboxacminh)) {
			strQuery = strQuery.replace("[$CANBOXACMINH$]", " AND tf.canboxacminh = ?");
			params.add(tentaikhoan);
		} else {
			strQuery = strQuery.replace("[$CANBOXACMINH$]", "");
		}
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}

			return Integer.valueOf(String.valueOf(query.uniqueResult()));
		} finally {
			if (session != null) {
				closeSession(session);
			}

		}
	}
	public List<Account> getAccountByStatus(int accountstatus, int type, String keyword, int status, long userId,
			int start, int end) {
		Session session = null;
		try {
			String strQuery = _customSQL.get(getClass(), SEARCH_ITEM);
			List<Object> params = new ArrayList<Object>();
			if (Validator.isNotNull(keyword)) {
				strQuery = strQuery.replace("[$KEYWORD$]", "AND ( LOWER(tf.fullname) like LOWER(?))");
				params.add("%" + keyword + "%");
			} else {
				strQuery = strQuery.replace("[$KEYWORD$]", "");
			}

			if (status > -1) {
				strQuery = strQuery.replace("[$STATUS$]", " AND tf.processStatus = ?");
				params.add(status);
			} else {
				strQuery = strQuery.replace("[$STATUS$]", "");
			}
			if (type > -1) {
				strQuery = strQuery.replace("[$TYPE$]", " AND tf.accountType = ?");
				params.add(type);
			} else {
				strQuery = strQuery.replace("[$TYPE$]", "");
			}
			if (accountstatus > 0) {
				strQuery = strQuery.replace("[$ACCSTARTUS$]", " AND tf.accountStatus = ?");
				params.add(accountstatus);
			} else {
				strQuery = strQuery.replace("[$ACCSTARTUS$]", "");
			}
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			query.addEntity("Account", AccountImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}
			return (List<Account>) QueryUtil.list(query, getDialect(), start, end);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}
		return null;
	}

	public int getTotalAccountCountByStatus(int accountstatus, int type, String keyword, int status, long userId,
			int start, int end) {
		String strQuery = _customSQL.get(getClass(), COUNT_ITEM);
		List<Object> params = new ArrayList<Object>();
		if (Validator.isNotNull(keyword)) {
			strQuery = strQuery.replace("[$KEYWORD$]", "AND ( LOWER(tf.fullName) like LOWER(?))");
			params.add("%" + keyword + "%");
		} else {
			strQuery = strQuery.replace("[$KEYWORD$]", "");
		}

		if (status > -1) {
			strQuery = strQuery.replace("[$STATUS$]", " AND tf.processStatus = ?");
			params.add(status);
		} else {
			strQuery = strQuery.replace("[$STATUS$]", "");
		}
		if (type > -1) {
			strQuery = strQuery.replace("[$TYPE$]", " AND tf.accountType = ?");
			params.add(type);
		} else {
			strQuery = strQuery.replace("[$TYPE$]", "");
		}
		if (accountstatus > 0) {
			strQuery = strQuery.replace("[$ACCSTARTUS$]", " AND tf.accountStatus = ?");
			params.add(accountstatus);
		} else {
			strQuery = strQuery.replace("[$ACCSTARTUS$]", "");
		}
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}

			return Integer.valueOf(String.valueOf(query.uniqueResult()));
		} finally {
			if (session != null) {
				closeSession(session);
			}

		}
	}
	
	public int countForXacMinh (String keyword, int tinhtrang, String email,
			String sogiayto, String tungay,String denngay, String sodienthoai,
			String tentaikhoan, int loaidoituong, int hinhthucdangky){
		
		String strQuery = _customSQL.get(getClass(), COUNT_XACMINH);
		List<Object> params = new ArrayList<Object>();
		if (Validator.isNotNull(keyword)) {
			strQuery = strQuery.replace("[$KEYWORD$]", " AND ( LOWER(tf.fullName) like LOWER(?))");
			params.add("%" + keyword + "%");
		} else {
			strQuery = strQuery.replace("[$KEYWORD$]", "");
		}

		if (hinhthucdangky > -1) {
			strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", " AND tf.hinhthucdangky = ?");
			params.add(hinhthucdangky);
		} else {
			strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", "");
		}
		if (Validator.isNotNull(sogiayto)) {
			strQuery = strQuery.replace("[$SOGIAYTO$]", " AND tf.personalId = ?");
			params.add(sogiayto);
		} else {
			strQuery = strQuery.replace("[$SOGIAYTO$]", "");
		}
		if (Validator.isNotNull(tungay)) {
			strQuery = strQuery.replace("[$TUNGAY$]", " AND tf.createDate > ?");
			params.add(tungay);
		} else {
			strQuery = strQuery.replace("[$TUNGAY$]", "");
		}
		if (Validator.isNotNull(denngay)) {
			strQuery = strQuery.replace("[$DENNGAY$]", " AND tf.createDate < ?");
			params.add(denngay);
		} else {
			strQuery = strQuery.replace("[$DENNGAY$]", "");
		}
		if (Validator.isNotNull(sodienthoai)) {
			strQuery = strQuery.replace("[$SODIENTHOAI$]", " AND tf.telNo = ?");
			params.add(sodienthoai);
		} else {
			strQuery = strQuery.replace("[$SODIENTHOAI$]", "");
		}
		if (Validator.isNotNull(tentaikhoan)) {
			strQuery = strQuery.replace("[$TENTAIKHOAN$]", " AND ( LOWER(tf.accountName) like LOWER(?))");
			params.add("%"+tentaikhoan+"%");
		} else {
			strQuery = strQuery.replace("[$TENTAIKHOAN$]", "");
		}
		
		if (loaidoituong > -1) {
			strQuery = strQuery.replace("[$LOAIDOITUONG$]", " AND tf.accountType = ?");
			params.add(loaidoituong);
		} else {
			strQuery = strQuery.replace("[$LOAIDOITUONG$]", "");
		}
		if (tinhtrang > 0) {
			strQuery = strQuery.replace("[$TINHTRANG$]", " AND tf.accountStatus = ?");
			params.add(tinhtrang);
		} else {
			strQuery = strQuery.replace("[$TINHTRANG$]", "AND (tf.accountStatus = 2 OR tf.accountStatus = 3)");
		}
		if (Validator.isNotNull(email)) {
			strQuery = strQuery.replace("[$EMAIL$]", " AND ( LOWER(tf.email) like LOWER(?))");
			params.add("%" + email + "%");
		} else {
			strQuery = strQuery.replace("[$EMAIL$]", "");
		}
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}

			return Integer.valueOf(String.valueOf(query.uniqueResult()));
		} finally {
			if (session != null) {
				closeSession(session);
			}

		}
	}
	public List<Account> searchForXacMinh (String keyword, int tinhtrang, String email,
			String sogiayto, String tungay,String denngay, String sodienthoai,
			String tentaikhoan, int loaidoituong, int hinhthucdangky, int start, int end){
		
		Session session = null;
		try {
			String strQuery = _customSQL.get(getClass(), SEARCH_XACMINH);
			List<Object> params = new ArrayList<Object>();
			if (Validator.isNotNull(keyword)) {
				strQuery = strQuery.replace("[$KEYWORD$]", " AND ( LOWER(tf.fullName) like LOWER(?))");
				params.add("%" + keyword + "%");
			} else {
				strQuery = strQuery.replace("[$KEYWORD$]", "");
			}

			if (hinhthucdangky > -1) {
				strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", " AND tf.hinhthucdangky = ?");
				params.add(hinhthucdangky);
			} else {
				strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", "");
			}
			if (Validator.isNotNull(sogiayto)) {
				strQuery = strQuery.replace("[$SOGIAYTO$]", " AND tf.personalId = ?");
				params.add(sogiayto);
			} else {
				strQuery = strQuery.replace("[$SOGIAYTO$]", "");
			}
			if (Validator.isNotNull(tungay)) {
				strQuery = strQuery.replace("[$TUNGAY$]", " AND tf.createDate > ?");
				params.add(tungay);
			} else {
				strQuery = strQuery.replace("[$TUNGAY$]", "");
			}
			if (Validator.isNotNull(denngay)) {
				strQuery = strQuery.replace("[$DENNGAY$]", " AND tf.createDate < ?");
				params.add(denngay);
			} else {
				strQuery = strQuery.replace("[$DENNGAY$]", "");
			}
			if (Validator.isNotNull(sodienthoai)) {
				strQuery = strQuery.replace("[$SODIENTHOAI$]", " AND tf.telNo = ?");
				params.add(sodienthoai);
			} else {
				strQuery = strQuery.replace("[$SODIENTHOAI$]", "");
			}
			if (Validator.isNotNull(tentaikhoan)) {
				strQuery = strQuery.replace("[$TENTAIKHOAN$]", " AND ( LOWER(tf.accountName) like LOWER(?))");
				params.add("%"+tentaikhoan+"%");
			} else {
				strQuery = strQuery.replace("[$TENTAIKHOAN$]", "");
			}
			
			if (loaidoituong > -1) {
				strQuery = strQuery.replace("[$LOAIDOITUONG$]", " AND tf.accountType = ?");
				params.add(loaidoituong);
			} else {
				strQuery = strQuery.replace("[$LOAIDOITUONG$]", "");
			}
			if (tinhtrang > 0) {
				strQuery = strQuery.replace("[$TINHTRANG$]", " AND tf.accountStatus = ?");
				params.add(tinhtrang);
			} else {
				strQuery = strQuery.replace("[$TINHTRANG$]", " AND (tf.accountStatus = 2 OR tf.accountStatus = 3)");
			}
			if (Validator.isNotNull(email)) {
				strQuery = strQuery.replace("[$EMAIL$]", "AND ( LOWER(tf.email) like LOWER(?))");
				params.add("%" + email + "%");
			} else {
				strQuery = strQuery.replace("[$EMAIL$]", "");
			}
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			query.addEntity("Account", AccountImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}
			return (List<Account>) QueryUtil.list(query, getDialect(), start, end);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public int countForPheDuyet (String keyword, int tinhtrang, String email,
			String sogiayto, String tungay,String denngay, String sodienthoai,
			String tentaikhoan, int loaidoituong, int hinhthucdangky){
		
		String strQuery = _customSQL.get(getClass(), COUNT_PHEDUYET);
		List<Object> params = new ArrayList<Object>();
		if (Validator.isNotNull(keyword)) {
			strQuery = strQuery.replace("[$KEYWORD$]", " AND ( LOWER(tf.fullName) like LOWER(?))");
			params.add("%" + keyword + "%");
		} else {
			strQuery = strQuery.replace("[$KEYWORD$]", "");
		}

		if (hinhthucdangky > -1) {
			strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", " AND tf.hinhthucdangky = ?");
			params.add(hinhthucdangky);
		} else {
			strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", "");
		}
		if (Validator.isNotNull(sogiayto)) {
			strQuery = strQuery.replace("[$SOGIAYTO$]", " AND tf.personalId = ?");
			params.add(sogiayto);
		} else {
			strQuery = strQuery.replace("[$SOGIAYTO$]", "");
		}
		if (Validator.isNotNull(tungay)) {
			strQuery = strQuery.replace("[$TUNGAY$]", " AND tf.createDate > ?");
			params.add(tungay);
		} else {
			strQuery = strQuery.replace("[$TUNGAY$]", "");
		}
		if (Validator.isNotNull(denngay)) {
			strQuery = strQuery.replace("[$DENNGAY$]", " AND tf.createDate < ?");
			params.add(denngay);
		} else {
			strQuery = strQuery.replace("[$DENNGAY$]", "");
		}
		if (Validator.isNotNull(sodienthoai)) {
			strQuery = strQuery.replace("[$SODIENTHOAI$]", " AND tf.telNo = ?");
			params.add(sodienthoai);
		} else {
			strQuery = strQuery.replace("[$SODIENTHOAI$]", "");
		}
		if (Validator.isNotNull(tentaikhoan)) {
			strQuery = strQuery.replace("[$TENTAIKHOAN$]", " AND ( LOWER(tf.accountName) like LOWER(?))");
			params.add("%"+tentaikhoan+"%");
		} else {
			strQuery = strQuery.replace("[$TENTAIKHOAN$]", "");
		}
		
		if (loaidoituong > -1) {
			strQuery = strQuery.replace("[$LOAIDOITUONG$]", " AND tf.accountType = ?");
			params.add(loaidoituong);
		} else {
			strQuery = strQuery.replace("[$LOAIDOITUONG$]", "");
		}
		if (tinhtrang > 0) {
			strQuery = strQuery.replace("[$TINHTRANG$]", " AND tf.accountStatus = ?");
			params.add(tinhtrang);
		} else {
			strQuery = strQuery.replace("[$TINHTRANG$]", "AND (tf.accountStatus = 4 OR tf.accountStatus = 9 OR tf.accountStatus = 7)");
		}
		if (Validator.isNotNull(email)) {
			strQuery = strQuery.replace("[$EMAIL$]", "AND ( LOWER(tf.email) like LOWER(?))");
			params.add("%" + email + "%");
		} else {
			strQuery = strQuery.replace("[$EMAIL$]", "");
		}
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}

			return Integer.valueOf(String.valueOf(query.uniqueResult()));
		} finally {
			if (session != null) {
				closeSession(session);
			}

		}
	}
	
	public List<Account> searchForPheDuyet (String keyword, int tinhtrang, String email,
			String sogiayto, String tungay,String denngay, String sodienthoai,
			String tentaikhoan, int loaidoituong, int hinhthucdangky, int start, int end){
		
		Session session = null;
		try {
			String strQuery = _customSQL.get(getClass(), SEARCH_PHEDUYET);
			List<Object> params = new ArrayList<Object>();
			if (Validator.isNotNull(keyword)) {
				strQuery = strQuery.replace("[$KEYWORD$]", " AND ( LOWER(tf.fullName) like LOWER(?))");
				params.add("%" + keyword + "%");
			} else {
				strQuery = strQuery.replace("[$KEYWORD$]", "");
			}

			if (hinhthucdangky > -1) {
				strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", " AND tf.hinhthucdangky = ?");
				params.add(hinhthucdangky);
			} else {
				strQuery = strQuery.replace("[$HINHTHUCDANGKY$]", "");
			}
			if (Validator.isNotNull(sogiayto)) {
				strQuery = strQuery.replace("[$SOGIAYTO$]", " AND tf.personalId = ?");
				params.add(sogiayto);
			} else {
				strQuery = strQuery.replace("[$SOGIAYTO$]", "");
			}
			if (Validator.isNotNull(tungay)) {
				strQuery = strQuery.replace("[$TUNGAY$]", " AND tf.createDate > ?");
				params.add(tungay);
			} else {
				strQuery = strQuery.replace("[$TUNGAY$]", "");
			}
			if (Validator.isNotNull(denngay)) {
				strQuery = strQuery.replace("[$DENNGAY$]", " AND tf.createDate < ?");
				params.add(denngay);
			} else {
				strQuery = strQuery.replace("[$DENNGAY$]", "");
			}
			if (Validator.isNotNull(sodienthoai)) {
				strQuery = strQuery.replace("[$SODIENTHOAI$]", " AND tf.telNo = ?");
				params.add(sodienthoai);
			} else {
				strQuery = strQuery.replace("[$SODIENTHOAI$]", "");
			}
			if (Validator.isNotNull(tentaikhoan)) {
				strQuery = strQuery.replace("[$TENTAIKHOAN$]", " AND ( LOWER(tf.accountName) like LOWER(?))");
				params.add("%"+tentaikhoan+"%");
			} else {
				strQuery = strQuery.replace("[$TENTAIKHOAN$]", "");
			}
			
			if (loaidoituong > -1) {
				strQuery = strQuery.replace("[$LOAIDOITUONG$]", " AND tf.accountType = ?");
				params.add(loaidoituong);
			} else {
				strQuery = strQuery.replace("[$LOAIDOITUONG$]", "");
			}
			if (tinhtrang > 0) {
				strQuery = strQuery.replace("[$TINHTRANG$]", " AND tf.accountStatus = ?");
				params.add(tinhtrang);
			} else {
				strQuery = strQuery.replace("[$TINHTRANG$]", " AND tf.accountStatus = 4 OR tf.accountStatus = 9 OR tf.accountStatus = 7");
			}
			if (Validator.isNotNull(email)) {
				strQuery = strQuery.replace("[$EMAIL$]", "AND ( LOWER(tf.email) like LOWER(?))");
				params.add("%" + email + "%");
			} else {
				strQuery = strQuery.replace("[$EMAIL$]", "");
			}
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			query.addEntity("Account", AccountImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}
			return (List<Account>) QueryUtil.list(query, getDialect(), start, end);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
}
