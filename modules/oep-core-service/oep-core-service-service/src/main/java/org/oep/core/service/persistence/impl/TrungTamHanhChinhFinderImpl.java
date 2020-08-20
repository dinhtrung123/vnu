package org.oep.core.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.oep.core.model.TrungTamHanhChinh;
import org.oep.core.model.impl.TrungTamHanhChinhImpl;
import org.oep.core.service.persistence.TrungTamHanhChinhFinder;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

public class TrungTamHanhChinhFinderImpl extends TrungTamHanhChinhFinderBaseImpl implements TrungTamHanhChinhFinder{
	
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
	
	private static String SEARCH_TTHC = TrungTamHanhChinhFinderImpl.class.getName() + ".searchTTHC";
	private static String COUNT_TTHC = TrungTamHanhChinhFinderImpl.class.getName() + ".countTTHC";
	
	public List<TrungTamHanhChinh> searchTTHC(String ten_ma,long coQuanQuanLyId, int trangThai, int start, int end){
		String strQuery = _customSQL.get(getClass(), SEARCH_TTHC);
		List<Object> params = new ArrayList<Object>();
		
		if(Validator.isNotNull(ten_ma)){
			strQuery = strQuery.replace("[$TEN_MA$]", "AND (UPPER(tthanhchinh.ten) like UPPER(?) or LOWER(tthanhchinh.ma) like LOWER(?))");
			params.add("%"+ten_ma+"%");
			params.add("%"+ten_ma+"%");
		}else{
			strQuery = strQuery.replace("[$TEN_MA$]", "");
		}
		
		if (coQuanQuanLyId > 0) {
			strQuery = strQuery.replace("[$COQUAN_QUANLY$]", "and tthanhchinh.donvi_id=?");
			params.add(coQuanQuanLyId);
		} else {
			strQuery = strQuery.replace("[$COQUAN_QUANLY$]", "");
		}
		
		if (trangThai > 0) {
			strQuery = strQuery.replace("[$TRANG_THAI$]", "and tthanhchinh.trangthai=?");
			params.add(trangThai);
		} else {
			strQuery = strQuery.replace("[$TRANG_THAI$]", "");
		}
		
		Session session = null;
		try{
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			query.addEntity("TrungTamHanhChinh", TrungTamHanhChinhImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for(Object obj : params){
				queryPos.add(obj);
			}
			
			return (List<TrungTamHanhChinh>)QueryUtil.list(query, getDialect(), start, end);
		}finally{
			if(session!=null){
				closeSession(session);
			}
		}
		
		
	}
	
	public int countTTHC(String ten_ma,long coQuanQuanLyId, int trangThai){
		
		String strQuery = _customSQL.get(getClass(), COUNT_TTHC);
		List<Object> params = new ArrayList<Object>();
		
		if(Validator.isNotNull(ten_ma)){
			strQuery = strQuery.replace("[$TEN_MA$]", "AND (UPPER(tthanhchinh.ten) like UPPER(?) or LOWER(tthanhchinh.ma) like LOWER(?))");
			params.add("%"+ten_ma+"%");
			params.add("%"+ten_ma+"%");
		}else{
			strQuery = strQuery.replace("[$TEN_MA$]", "");
		}
		
		if(coQuanQuanLyId > 0){
			strQuery = strQuery.replace("[$COQUAN_QUANLY$]", "and tthanhchinh.donvi_id=?");
			params.add(coQuanQuanLyId);
		}else{
			strQuery = strQuery.replace("[$COQUAN_QUANLY$]", "");
		}
		
		if(trangThai > 0){
			strQuery = strQuery.replace("[$TRANG_THAI$]", "and tthanhchinh.trangthai=?");
			params.add(trangThai);
		}else{
			strQuery = strQuery.replace("[$TRANG_THAI$]", "");
		}
		
		
		Session session = null;
		try{
			session = openSession();
			SQLQuery query = session.createSQLQuery(strQuery);
			QueryPos queryPos = QueryPos.getInstance(query);
			for(Object obj : params){
				queryPos.add(obj);
			}
			
			return Integer.valueOf(String.valueOf(query.uniqueResult()));
		}finally{
			if(session!=null){
				closeSession(session);
			}
		}
		
	}
}
