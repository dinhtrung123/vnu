package org.oep.danhmuc.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.oep.danhmuc.model.DanhMuc;
import org.oep.danhmuc.model.impl.DanhMucImpl;
import org.oep.danhmuc.service.persistence.DanhMucFinder;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

public class DanhMucFinderImpl extends DanhMucFinderBaseImpl implements DanhMucFinder {
	private static Log log = LogFactoryUtil.getLog(DanhMucFinderImpl.class);
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
	private static String SEARCH_ITEM = DanhMucFinderImpl.class.getName() + ".searchItem";
	private static String COUNT_ITEM = DanhMucFinderImpl.class.getName() + ".countItem";
	private static String GET_ITEM_WITH_MAX_DISPLAY_INDEX = DanhMucFinderImpl.class.getName() + ".getItemWithMaxDisplayIndex";
	private static String GET_ITEM_WITH_MAX_DISPLAY_INDEX_BY_MUC = DanhMucFinderImpl.class.getName() + ".getItemWithMaxDisplayIndexByMuc";
	
	@SuppressWarnings("unchecked")
	public int countItem(long idCha, String keyWord, String groupId, String muc){
		String strQuery = _customSQL.get(getClass(), COUNT_ITEM);
		List<Object> params = new ArrayList<Object>();
		if(Validator.isNotNull(muc)){
			strQuery = strQuery.replace("[$MUC$]", "AND di.muc IN ("+ muc + ")");
		}else{
			strQuery = strQuery.replace("[$MUC$]", "");
		}
		if(idCha == 0){
			strQuery = strQuery.replace("[$ID_CHA$]", "AND (di.cha_id = ? OR di.cha_id IS NULL)");
			params.add(idCha);
		}
		else{
			strQuery = strQuery.replace("[$ID_CHA$]", "AND di.cha_id = ?");
			params.add(idCha);
		}
		if((!groupId.equals("") || ! groupId.isEmpty())){
			strQuery = strQuery.replace("[$NHOM_DANHMUC$]", "AND di.nhom_id IN ("+ groupId + ")");
		}
		else{
			strQuery = strQuery.replace("[$NHOM_DANHMUC$]", "");
		}
		if(!keyWord.equals("") || ! keyWord.isEmpty()){
			strQuery = strQuery.replace("[$MATEN$]", "AND (di.ten like? OR di.ma like?)");
			params.add("%"+keyWord+"%");
			params.add("%"+keyWord+"%");
		}
		else{
			strQuery = strQuery.replace("[$MATEN$]", "");
		}
		
		Session session = null;
		try{
			session= openSession();
			SQLQuery query=session.createSQLQuery(strQuery);
			QueryPos queryPos = QueryPos.getInstance(query);
			for(Object obj : params){
				queryPos.add(obj);
			}
			int count = Integer.valueOf(String.valueOf(query.uniqueResult()));
			return count;
		}
		finally{
			if(session != null){
				closeSession(session);
			}
		}
	}
	@SuppressWarnings("unchecked")
	public List<DanhMuc> searchItem(long idCha,String keyWord, String groupId, String muc, int start, int end){
		Session session = null;
		try{
		String strQuery = _customSQL.get(getClass(), SEARCH_ITEM);
		List<Object> params = new ArrayList<Object>();
		
		if(Validator.isNotNull(muc)){
			strQuery = strQuery.replace("[$MUC$]", "AND di.muc IN ("+ muc + ")");
		}else{
			strQuery = strQuery.replace("[$MUC$]", "");
		}
		
		if(idCha == 0){
			strQuery = strQuery.replace("[$ID_CHA$]", "AND (di.cha_id = ? OR di.cha_id IS NULL)");
			params.add(idCha);
		}
		else{
			strQuery = strQuery.replace("[$ID_CHA$]", "AND di.cha_id = ?");
			params.add(idCha);
		}
		if((!groupId.equals("") || ! groupId.isEmpty())){
			strQuery = strQuery.replace("[$NHOM_DANHMUC$]", "AND di.nhom_id IN ("+ groupId + ")");
		}
		else{
			strQuery = strQuery.replace("[$NHOM_DANHMUC$]", "");
		}
		if(!keyWord.equals("") || ! keyWord.isEmpty()){
			strQuery = strQuery.replace("[$MATEN$]", "AND (di.ten like? OR di.ma like?)");
			params.add("%"+keyWord+"%");
			params.add("%"+keyWord+"%");
		}
		else{
			strQuery = strQuery.replace("[$MATEN$]", "");
		}
//		strQuery = strQuery.replace("$OBJ_IN$", "IN ("+ groupId + ")");
//		String obj = "IN ("+groupId+ ")";
		
			session= openSession();
			SQLQuery query=session.createSQLQuery(strQuery);
			query.addEntity("DanhMuc", DanhMucImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			for(Object obj : params){
				queryPos.add(obj);
			}
			return (List<DanhMuc>) QueryUtil.list(query, getDialect(), start, end);
		}catch (Exception e	){
			log.info(e);
		} finally{
			if(session != null){
				closeSession(session);
			}
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public DanhMuc getDanhMucWithMaxDisplayIndex(long idCha){
		Session session = null;
		try{
			session= openSession();
			String strQuery = _customSQL.get(getClass(), GET_ITEM_WITH_MAX_DISPLAY_INDEX);
			SQLQuery query=session.createSQLQuery(strQuery);
			query.addEntity("Item", DanhMucImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			queryPos.add(idCha);
			List<DanhMuc> listItem = (List<DanhMuc>)QueryUtil.list(query, getDialect(), -1, -1);
			if(listItem.size()>0)
				return listItem.get(0);
			else return null;
		}
		finally{
			if(session != null){
				closeSession(session);
			}
		}
	}
	@SuppressWarnings("unchecked")
	public DanhMuc getItemWithMaxDisplayIndexByMuc(int muc){
		Session session = null;
		try{
			session= openSession();
			String strQuery = _customSQL.get(getClass(), GET_ITEM_WITH_MAX_DISPLAY_INDEX_BY_MUC);
			SQLQuery query=session.createSQLQuery(strQuery);
			query.addEntity("Item", DanhMucImpl.class);
			QueryPos queryPos = QueryPos.getInstance(query);
			queryPos.add(muc);
			List<DanhMuc> listItem = (List<DanhMuc>)QueryUtil.list(query, getDialect(), -1, -1);
			if(listItem.size()>0)
				return listItem.get(0);
			else return null;
		}
		finally{
			if(session != null){
				closeSession(session);
			}
		}
	}

}
