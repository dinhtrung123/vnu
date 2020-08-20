package dtt.vn.audit.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.ArrayList;
import java.util.List;

import dtt.vn.audit.model.AuditEvent;
import dtt.vn.audit.model.impl.AuditEventImpl;
import dtt.vn.audit.service.persistence.AuditEventFinder;




public class AuditEventFinderImpl extends AuditEventFinderBaseImpl implements AuditEventFinder {
	private static Log log = LogFactoryUtil.getLog(AuditEventFinderImpl.class);
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
	private static String searchcustom = AuditEventFinderImpl.class.getName() + ".searchcustom";
	private static String countcustom = AuditEventFinderImpl.class.getName() + ".countcustom";
	public List<AuditEvent> searchcustom (String keyword,String tungay,String denngay, int start,int end,String fullname){
		Session session = null;
		try {
			String strQuery = _customSQL.get(getClass(), searchcustom).trim();
			List<Object> params = new ArrayList<Object>();
			if (Validator.isNotNull(keyword)) {
				strQuery = strQuery.replace("[$USERNAME$]", " AND ( LOWER(tf.userName) like LOWER(?))");
				params.add("%" + keyword + "%");
			} else {
				strQuery = strQuery.replace("[$USERNAME$]", "");
			}
			if (Validator.isNotNull(fullname)) {
				strQuery = strQuery.replace("[$FULLNAME$]", " AND ( LOWER(tf.message) like LOWER(?))");
				params.add("%" + fullname + "%");
			} else {
				strQuery = strQuery.replace("[$FULLNAME$]", "");
			}
			if (Validator.isNotNull(tungay)) {
				strQuery = strQuery.replace("[$TUNGAY$]", " AND (tf.createDate > ?)");
				params.add(tungay);
			} else {
				strQuery = strQuery.replace("[$TUNGAY$]", "");
			}
			if (Validator.isNotNull(denngay)) {
				strQuery = strQuery.replace("[$DENNGAY$]", " AND (tf.createDate < ?)");
				params.add(denngay);
			} else {
				strQuery = strQuery.replace("[$DENNGAY$]", "");
			}
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			query.addEntity("AuditEvent", AuditEventImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}
			return (List<AuditEvent>) QueryUtil.list(query, getDialect(), start, end);
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
	
	
	
	
	public int countcustom(String keyword,String tungay,String denngay,String fullname) {
		String strQuery = _customSQL.get(getClass(), countcustom).trim();
		List<Object> params = new ArrayList<Object>();
		if (Validator.isNotNull(keyword)) {
			strQuery = strQuery.replace("[$USERNAME$]", " AND ( LOWER(tf.userName) like LOWER(?))");
			params.add("%" + keyword + "%");
		} else {
			strQuery = strQuery.replace("[$USERNAME$]", "");
		}
		if (Validator.isNotNull(fullname)) {
			strQuery = strQuery.replace("[$FULLNAME$]", " AND ( LOWER(tf.message) like LOWER(?))");
			params.add("%" + fullname + "%");
		} else {
			strQuery = strQuery.replace("[$FULLNAME$]", "");
		}
		if (Validator.isNotNull(tungay)) {
			strQuery = strQuery.replace("[$TUNGAY$]", " AND (tf.createDate > ?)");
			params.add(tungay);
		} else {
			strQuery = strQuery.replace("[$TUNGAY$]", "");
		}
		if (Validator.isNotNull(denngay)) {
			strQuery = strQuery.replace("[$DENNGAY$]", " AND (tf.createDate < ?)");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Object getReportList(final int start, final int end) throws SystemException {
		Object result = null;
		final Session session = openSession();

		try{

			result =
				QueryUtil.list(getSQLQuery(session), getDialect(), start, end);

		}catch (final Exception e){
			throw new SystemException(e);
		}finally {
			closeSession(session);
		}

		return result;
	}
	protected SQLQuery getSQLQuery(final Session session) {

		final StringBundler sql = new StringBundler(9);

		sql.append(" select ");
		sql.append(" 	Audit_AuditEvent.userName, ");
		sql.append(" 	AssetEntry.title, ");
		sql.append(" 	count(Audit_AuditEvent.className) as qtd ");
		sql.append(" from Audit_AuditEvent, AssetEntry ");
		sql.append(" where Audit_AuditEvent.eventType = ? ");
		sql.append(" and Audit_AuditEvent.classPK = AssetEntry.classPK ");
		sql.append(" group by Audit_AuditEvent.userName, AssetEntry.title, Audit_AuditEvent.className");
		sql.append(" order by Audit_AuditEvent.userName asc, qtd desc");

		final SQLQuery query = session.createSQLQuery(sql.toString());

		final QueryPos queryPosition = QueryPos.getInstance(query);
		queryPosition.add("VIEW");

		return query;

	}
}
