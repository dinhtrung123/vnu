package org.oep.core.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.oep.core.model.LogSMS;
import org.oep.core.model.impl.LogSMSImpl;
import org.oep.core.service.persistence.LogSMSFinder;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

public class LogSMSFinderImpl extends LogSMSFinderBaseImpl implements LogSMSFinder {
	private static Log log = LogFactoryUtil.getLog(LogSMSFinderImpl.class);
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
	private static final String SEARCH_BY_PHONE = LogSMSFinderImpl.class.getName() + ".SearchByPhone";
	private static final String countByPhone = LogSMSFinderImpl.class.getName() + ".CountByPhone";

	public List<LogSMS> searchByPhone(String keyword, String tungay, String denngay, int start, int end) {
		Session session = openSession();
		try {
			String strQuery = _customSQL.get(getClass(), SEARCH_BY_PHONE);
			List<Object> params = new ArrayList<Object>();
			if (Validator.isNotNull(keyword)) {
				strQuery = strQuery.replace("[$KEYWORD$]", "AND ( LOWER(logsms.phone) like LOWER(?))");
				params.add("%" + keyword + "%");

			} else {
				strQuery = strQuery.replace("[$KEYWORD$]", "");
			}
			if (Validator.isNotNull(tungay)) {
				strQuery = strQuery.replace("[$TUNGAY$]", "AND (logsms.sent_date_time > ?)");
				params.add(tungay);
			} else {
				strQuery = strQuery.replace("[$TUNGAY$]", "");
			}
			if (Validator.isNotNull(denngay)) {
				strQuery = strQuery.replace("[$DENNGAY$]", "AND (logsms.sent_date_time < ?)");
				params.add(denngay);
			} else {
				strQuery = strQuery.replace("[$DENNGAY$]", "");
			}
			SQLQuery query = session.createSQLQuery(strQuery);
			query.addEntity("LogSMS", LogSMSImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}
			return (List<LogSMS>) QueryUtil.list(query, getDialect(), start, end);
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

	public int countByPhone(String keyword, String tungay, String denngay) {
		Session session = openSession();
		String strQuery = _customSQL.get(getClass(), countByPhone).trim();
		List<Object> params = new ArrayList<Object>();
		if (Validator.isNotNull(keyword)) {
			strQuery = strQuery.replace("[$KEYWORD$]", "AND ( LOWER(logsms.phone) like LOWER(?))");
			params.add("%" + keyword + "%");

		} else {
			strQuery = strQuery.replace("[$KEYWORD$]", "");
		}
		if (Validator.isNotNull(tungay)) {
			strQuery = strQuery.replace("[$TUNGAY$]", "AND (logsms.sent_date_time > ?)");
			params.add(tungay);
		} else {
			strQuery = strQuery.replace("[$TUNGAY$]", "");
		}
		if (Validator.isNotNull(denngay)) {
			strQuery = strQuery.replace("[$DENNGAY$]", "AND (logsms.sent_date_time < ?)");
			params.add(denngay);
		} else {
			strQuery = strQuery.replace("[$DENNGAY$]", "");
		}
		try {
			//session = openSession();
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
