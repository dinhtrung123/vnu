package dtt.vn.user.service.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.ArrayList;
import java.util.List;

import dtt.vn.user.service.model.DataImport;
import dtt.vn.user.service.model.impl.DataImportImpl;
import dtt.vn.user.service.service.persistence.DataImportFinder;

public class DataImportFinderImpl extends DataImportFinderBaseImpl implements DataImportFinder {
	//private static Log log = LogFactoryUtil.getLog(ThongTinDangKyFinderImpl.class);
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
	private static String searchForImport = DataImportFinderImpl.class.getName() + ".searchForImport";
	private static String countForImport  = DataImportFinderImpl.class.getName() + ".countForImport";

	@SuppressWarnings("unchecked")
	public List<DataImport> searchForImport(int hasImport,String screenName,String lastName, String email, String role, String tungay, String denngay, int start, int end){
		Session session = null;
		try {
			String strQuery = _customSQL.get(getClass(), searchForImport).trim();
			List<Object> params = new ArrayList<Object>();
			if (hasImport != 2) {
				strQuery = strQuery.replace("[$HASIMPORT$]", "AND tf.has_import = ?");
				params.add(hasImport);
			} else {
				strQuery = strQuery.replace("[$HASIMPORT$]", "AND (tf.has_import = -1 OR tf.has_import = 0 OR tf.has_import = 1)");
			}
			
			if (Validator.isNotNull(screenName)) {
				strQuery = strQuery.replace("[$SCREENNAME$]", "AND ( LOWER(tf.screen_name) like LOWER(?))");
				params.add("%" + screenName + "%");
			} else {
				strQuery = strQuery.replace("[$SCREENNAME$]", "");
			}
			
			if (Validator.isNotNull(lastName)) {
				strQuery = strQuery.replace("[$LASTNAME$]", "AND ( LOWER(tf.last_name) like LOWER(?))");
				params.add("%" + lastName + "%");
			} else {
				strQuery = strQuery.replace("[$LASTNAME$]", "");
			}
			
			if (Validator.isNotNull(email)) {
				strQuery = strQuery.replace("[$EMAIL$]", "AND ( LOWER(tf.email_address) like LOWER(?))");
				params.add("%" + email + "%");
			} else {
				strQuery = strQuery.replace("[$EMAIL$]", "");
			}
			
			if (Validator.isNotNull(role)) {
				strQuery = strQuery.replace("[$ROLE$]", "AND ( LOWER(tf.role_name) like LOWER(?))");
				params.add("%" + role + "%");
			} else {
				strQuery = strQuery.replace("[$ROLE$]", "");
			}
			
			if (Validator.isNotNull(tungay)) {
				strQuery = strQuery.replace("[$TUNGAY$]", " AND tf.insert_date > ?");
				params.add(tungay);
			} else {
				strQuery = strQuery.replace("[$TUNGAY$]", "");
			}
			if (Validator.isNotNull(denngay)) {
				strQuery = strQuery.replace("[$DENNGAY$]", " AND tf.insert_date < ?");
				params.add(denngay);
			} else {
				strQuery = strQuery.replace("[$DENNGAY$]", "");
			}
			
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			query.addEntity("DataImport", DataImportImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}
			return (List<DataImport>) QueryUtil.list(query, getDialect(), start, end);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}
	}
	public int countForImport(int hasImport,String screenName,String lastName, String email, String role, String tungay, String denngay) {
		String strQuery = _customSQL.get(getClass(), countForImport).trim();
		List<Object> params = new ArrayList<Object>();
		
		if (hasImport != 2) {
			strQuery = strQuery.replace("[$HASIMPORT$]", "AND tf.has_import = ?");
			params.add(hasImport);
		} else {
			strQuery = strQuery.replace("[$HASIMPORT$]", "AND (tf.has_import = -1 OR tf.has_import = 0 OR tf.has_import = 1)");
		}
		
		if (Validator.isNotNull(screenName)) {
			strQuery = strQuery.replace("[$SCREENNAME$]", "AND ( LOWER(tf.screen_name) like LOWER(?))");
			params.add("%" + screenName + "%");
		} else {
			strQuery = strQuery.replace("[$SCREENNAME$]", "");
		}
		
		if (Validator.isNotNull(lastName)) {
			strQuery = strQuery.replace("[$LASTNAME$]", "AND ( LOWER(tf.last_name) like LOWER(?))");
			params.add("%" + lastName + "%");
		} else {
			strQuery = strQuery.replace("[$LASTNAME$]", "");
		}
		
		if (Validator.isNotNull(email)) {
			strQuery = strQuery.replace("[$EMAIL$]", "AND ( LOWER(tf.email_address) like LOWER(?))");
			params.add("%" + email + "%");
		} else {
			strQuery = strQuery.replace("[$EMAIL$]", "");
		}
		
		if (Validator.isNotNull(role)) {
			strQuery = strQuery.replace("[$ROLE$]", "AND ( LOWER(tf.role_name) like LOWER(?))");
			params.add("%" + role + "%");
		} else {
			strQuery = strQuery.replace("[$ROLE$]", "");
		}
		
		if (Validator.isNotNull(tungay)) {
			strQuery = strQuery.replace("[$TUNGAY$]", "AND tf.insert_date > ?");
			params.add(tungay);
		} else {
			strQuery = strQuery.replace("[$TUNGAY$]", "");
		}
		if (Validator.isNotNull(denngay)) {
			strQuery = strQuery.replace("[$DENNGAY$]", "AND tf.insert_date < ?");
			params.add(denngay);
		} else {
			strQuery = strQuery.replace("[$DENNGAY$]", "");
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
}
