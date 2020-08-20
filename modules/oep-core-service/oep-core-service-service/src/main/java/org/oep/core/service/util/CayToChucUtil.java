package org.oep.core.service.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class CayToChucUtil {

	private static Log log = LogFactoryUtil.getLog(CayToChucUtil.class);
	public static List<Organization> getTreesOrganization(long companyId,long parentOrganizationId){
		 List<Organization> result = new ArrayList<Organization>();
		 getTreesOrganization(companyId, parentOrganizationId, result);
		 return result;
		
	}
	
	public static List<User> getUserByOrganizationId(long organizationId){
		
		try {
			return UserLocalServiceUtil.getOrganizationUsers(organizationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	
	
	private static List<Organization> getTreesOrganization(long companyId, long parentOrganizationId, List<Organization> listOutPut){
		try {			
			List<Organization> list = OrganizationLocalServiceUtil.getOrganizations(companyId, parentOrganizationId);
			if(list != null && list.size() >0){
				for(Organization org : list){
					listOutPut.add(org);
					getTreesOrganization(companyId, org.getOrganizationId(), listOutPut);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return listOutPut;
	}
	
	public static List<Organization> getHierarchicalOrganization(long companyId, long parentOrganizationId, List<Organization> listOutPut){
		try {
			List<Organization> list = OrganizationLocalServiceUtil.getOrganizations(companyId, parentOrganizationId);
			if(list != null && list.size() >0){
				for(Organization org : list){
					listOutPut.add(org);
					getHierarchicalOrganization(companyId, org.getOrganizationId(), listOutPut);
				}
			}
		} catch (Exception e) {
		}
		return listOutPut;
	}
	
	public static String getCharactorTreeMap(Organization org){
		if(org == null 
				|| org.getParentOrganizationId() == 0 
				|| org.getTreePath() == null){
			return "";
		}
		StringBuffer result = new StringBuffer("");
		try{
			String[] trees = org.getTreePath().split("/");
			if(trees != null && trees.length >1){
				
				for(String str :trees){
					result.append("-");					
				}
			}
			
			
		}catch(Exception e){
			
		}
		return result.toString();
	}
	
	public static long getOrganizationId(User user){
		try{
			long[] orgIds = user.getOrganizationIds();
			if(orgIds != null && orgIds.length >0){
				return orgIds[0];
			}
		}catch(Exception e){}
		return 0;
	}
	
	public static String getOrganizationName(long organizationId ){
		try{
			Organization org = OrganizationLocalServiceUtil.fetchOrganization(organizationId);
			if(org != null){
				return org.getName();
			}
			
		}catch(Exception e){}
		return "";
	}
	
	public static String listOrganizationToString(List<Organization> lst,Organization parrent, int doSauCayThuMuc, String urlImage){
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonObject;
		for (Organization organization : lst) {
				if(organization.getTreePath().split("/").length  <= parrent.getTreePath().split("/").length + doSauCayThuMuc ){
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("id", String.valueOf(organization.getOrganizationId()));
				jsonObject.put("parent", checkParentNode(lst, organization.getParentOrganizationId()));
				jsonObject.put("text", organization.getName());
				if(urlImage != ""){
					jsonObject.put("icon", urlImage);
				}
				jsonArray.put(jsonObject);
			}
		}
		return jsonArray.toString();
	}
	
	public static String checkParentNode(List<Organization> lst , long id){
		String parent = "#";
		for (Organization organization : lst) {
			if(organization.getOrganizationId() == id){
				parent = String.valueOf(organization.getOrganizationId());
			}
		}
		return parent;
	}
	
	public static String getCharactorTreeMapParent(Organization org){
		if(org == null 
				|| org.getParentOrganizationId() == 0 
				|| org.getTreePath() == null){
			return "";
		}
		System.out.println(org.getParentOrganizationId());
		StringBuffer result = new StringBuffer("");
		try{
			String[] trees = org.getTreePath().split("/");
			if(trees != null && trees.length >1){
				result.append(trees[trees.length-1]);
			}
		}catch(Exception e){
			
		}
		return result.toString();
	}
	
}
