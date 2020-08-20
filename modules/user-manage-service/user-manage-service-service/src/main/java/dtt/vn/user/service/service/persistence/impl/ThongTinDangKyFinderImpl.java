package dtt.vn.user.service.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.ArrayList;
import java.util.List;

import dtt.vn.user.service.model.ThongTinDangKy;
import dtt.vn.user.service.model.impl.ThongTinDangKyImpl;
import dtt.vn.user.service.service.persistence.ThongTinDangKyFinder;


public class ThongTinDangKyFinderImpl extends ThongTinDangKyFinderBaseImpl implements ThongTinDangKyFinder{
	private static Log log = LogFactoryUtil.getLog(ThongTinDangKyFinderImpl.class);
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
	private static String searchByEmailOrUsername = ThongTinDangKyFinderImpl.class.getName() + ".searchByEmailOrUsername";
	private static String countByEmailOrUsername = ThongTinDangKyFinderImpl.class.getName() + ".countByEmailOrUsername";
	@SuppressWarnings("unchecked")
	public List<ThongTinDangKy> searchByEmailOrUsername (String keyword,String tungay,String denngay, int start,int end){
		Session session = null;
		try {
			String strQuery = _customSQL.get(getClass(), searchByEmailOrUsername).trim();
			List<Object> params = new ArrayList<Object>();
			if (Validator.isNotNull(keyword)) {
				strQuery = strQuery.replace("[$KEYWORD$]", "AND ( LOWER(tf.email_address) like LOWER(?) OR LOWER(tf.username) like LOWER(?))");
				params.add("%" + keyword + "%");
				params.add("%" + keyword + "%");
			} else {
				strQuery = strQuery.replace("[$KEYWORD$]", "");
			}
			if (Validator.isNotNull(tungay)) {
				strQuery = strQuery.replace("[$TUNGAY$]", "AND (tf.ngaytao > ?)");
				params.add(tungay);
			} else {
				strQuery = strQuery.replace("[$TUNGAY$]", "");
			}
			if (Validator.isNotNull(denngay)) {
				strQuery = strQuery.replace("[$DENNGAY$]", "AND (tf.ngaytao < ?)");
				params.add(denngay);
			} else {
				strQuery = strQuery.replace("[$DENNGAY$]", "");
			}
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			query.addEntity("ThongTinDangKy", ThongTinDangKyImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}
			return (List<ThongTinDangKy>) QueryUtil.list(query, getDialect(), start, end);
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
	public int countByEmailOrUsername(String keyword,String tungay,String denngay) {
		String strQuery = _customSQL.get(getClass(), countByEmailOrUsername).trim();
		List<Object> params = new ArrayList<Object>();
		if (Validator.isNotNull(keyword)) {
			strQuery = strQuery.replace("[$KEYWORD$]", "AND ( LOWER(tf.email_address) like LOWER(?) OR LOWER(tf.username) like LOWER(?))");
			params.add("%" + keyword + "%");
			params.add("%" + keyword + "%");
		} else {
			strQuery = strQuery.replace("[$KEYWORD$]", "");
		}

		if (Validator.isNotNull(tungay)) {
			strQuery = strQuery.replace("[$TUNGAY$]", "AND (tf.ngaytao > ?)");
			params.add(tungay);
		} else {
			strQuery = strQuery.replace("[$TUNGAY$]", "");
		}
		if (Validator.isNotNull(denngay)) {
			strQuery = strQuery.replace("[$DENNGAY$]", "AND (tf.ngaytao < ?)");
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
