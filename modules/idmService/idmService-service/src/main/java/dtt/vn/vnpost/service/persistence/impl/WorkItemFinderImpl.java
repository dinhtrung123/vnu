package dtt.vn.vnpost.service.persistence.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.model.impl.WorkItemImpl;
import dtt.vn.vnpost.service.persistence.WorkItemFinder;



public class WorkItemFinderImpl extends WorkItemFinderBaseImpl implements WorkItemFinder {
	public WorkItem getWorkItemByAccountId(long accountId) throws SystemException {
Session session = null;
		
		try {			
			session = openSession();
			if(Validator.isNotNull(accountId)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT * FROM idm_workitem");
				sql.append(" WHERE workItemId = (SELECT max(workItemId) FROM idm_workitem WHERE accountid = ? )");				
		
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.setCacheable(false);						
				
				q.addEntity("WorkItem", WorkItemImpl.class);
	           
				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add(accountId);
				
				List<WorkItem> lstWorkItem =  (List<WorkItem>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);	
				if(lstWorkItem != null && lstWorkItem.size() > 0){
					return lstWorkItem.get(0);
				}
			}
			
			return null;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public WorkItem getWorkItemByAccountIdLastComplete(long accountId) throws SystemException {
Session session = null;
		
		try {			
			session = openSession();
			if(Validator.isNotNull(accountId)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT * FROM idm_workitem");
				sql.append(" WHERE workItemId = (SELECT max(workItemId) FROM idm_workitem WHERE accountid = ? and userId > 0 )");				
		
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.setCacheable(false);						
				
				q.addEntity("WorkItem", WorkItemImpl.class);
	           
				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add(accountId);
				
				List<WorkItem> lstWorkItem =  (List<WorkItem>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);	
				if(lstWorkItem != null && lstWorkItem.size() > 0){
					return lstWorkItem.get(0);
				}
			}
			
			return null;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	}

