package org.oep.core.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.oep.core.model.ThamSo;
import org.oep.core.model.impl.ThamSoImpl;
import org.oep.core.service.persistence.ThamSoFinder;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

public class ThamSoFinderImpl extends ThamSoFinderBaseImpl implements ThamSoFinder{
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
	private static final String COUNT_BY_L_M =ThamSoFinderImpl.class.getName()+".countByL_M";
	private static final String SEARCH_BY_L_M = ThamSoFinderImpl.class.getName()+".searchByL_M";
	
	public List<ThamSo> searchByL_M(long groupId,Long loaiThamSoId, String ma, int start, int end) {
		List<Object> params = new ArrayList<Object>();
		String strQuery = _customSQL.get(getClass(), SEARCH_BY_L_M);
		params.add(groupId);
		if (Validator.isNotNull(loaiThamSoId) && loaiThamSoId.longValue() >0 ) {
			strQuery = strQuery.replace("[$LOAI_THAMSO_FILTER$]", " AND loai_id = ?");
			params.add(loaiThamSoId);
		} else {
			strQuery = strQuery.replace("[$LOAI_THAMSO_FILTER$]", StringPool.BLANK);
		}
		if (Validator.isNotNull(ma)) {
			strQuery = strQuery.replace("[$MA_FILTER$]", " AND LOWER(ma) LIKE ? ");
			params.add("%" + ma.toLowerCase() + "%");
		} else {
			strQuery = strQuery.replace("[$MA_FILTER$]", StringPool.BLANK);
		}
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			query.addEntity("ThamSo", ThamSoImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for (Object obj : params) {
				queryPos.add(obj);
			}
			return (List<ThamSo>) QueryUtil.list(query, getDialect(), start, end);
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}
	}
	
	public int countByL_M(long groupId,Long loaiThamSoId, String ma) {
		List<Object> params = new ArrayList<Object>();
		String strQuery = _customSQL.get(getClass(), COUNT_BY_L_M);
		params.add(groupId);
		if (Validator.isNotNull(loaiThamSoId) && loaiThamSoId.longValue() >0 ) {
			strQuery = strQuery.replace("[$LOAI_THAMSO_FILTER$]", " AND loai_id = ?");
			params.add(loaiThamSoId);
		} else {
			strQuery = strQuery.replace("[$LOAI_THAMSO_FILTER$]", StringPool.BLANK);
		}
		if (Validator.isNotNull(ma)) {
			strQuery = strQuery.replace("[$MA_FILTER$]", " AND LOWER(ma) LIKE ? ");
			params.add("%" + ma.toLowerCase() + "%");
		} else {
			strQuery = strQuery.replace("[$MA_FILTER$]", StringPool.BLANK);
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

