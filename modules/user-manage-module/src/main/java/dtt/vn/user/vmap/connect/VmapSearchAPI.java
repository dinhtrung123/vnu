package dtt.vn.user.vmap.connect;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import dtt.vn.user.vmap.util.VmapObject;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class VmapSearchAPI {
	private static Log log = LogFactoryUtil.getLog(VmapSearchAPI.class);
	private static final CloseableHttpClient httpClient = HttpClients.createDefault();
	
	public static List<VmapObject> Connect(String lat, String lon, String text){
		List<VmapObject> listObject = new ArrayList<VmapObject>();
		try {
			String url = "https://maps.vnpost.vn/api/search?focus.point.lat="+lat+"&focus.point.lon="+lon+"&text="+text+"&layer=venue";
			
			HttpGet request = new HttpGet(url);
			request.setHeader("apikey", "7cb80a390b89d5fefae75fc58b01d01dd04a15bb62b3b141");
			try (CloseableHttpResponse response = httpClient.execute(request)) {
	            int responseCode = response.getStatusLine().getStatusCode();
	            
	            if(responseCode == 200){
	            	HttpEntity entity = response.getEntity();
		            Header headers = entity.getContentType();
		            if (entity != null) {
		                // return it as a String
		                String result = EntityUtils.toString(entity);
		                //System.out.println(result);
		                JSONObject json = JSONFactoryUtil.createJSONObject(result);
		                String MSG_CODE = json.getString("code");
		                
		                if(MSG_CODE.equals("OK")){
		                	JSONObject data = json.getJSONObject("data");
		                	JSONArray features = data.getJSONArray("features");
		                	
		                	for (int i = 0; i < features.length(); i++) {
								JSONObject objFeatures = features.getJSONObject(i);
								JSONObject geometry = objFeatures.getJSONObject("geometry");
								String coordinates = geometry.getJSONArray("coordinates").toJSONString();
								VmapObject vmapObject = new VmapObject();
								vmapObject.setCoordinates(coordinates);
								JSONObject properties = objFeatures.getJSONObject("properties");
								
								vmapObject.setLabel(properties.getString("label",""));
								vmapObject.setRegion(properties.getString("region",""));
								vmapObject.setCounty(properties.getString("county",""));
								vmapObject.setLocality(properties.getString("locality",""));
								vmapObject.setCountry(properties.getString("country",""));
								JSONObject addendum = properties.getJSONObject("addendum");
								JSONObject vnpost = addendum.getJSONObject("vnpost");
								if(vnpost != null){
									vmapObject.setVnpost(vnpost.toJSONString());
									listObject.add(vmapObject);
								}
							}
		                	log.info(listObject.toString());
		                	return listObject;
		                }
		            }

	            }
	            
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
		
	}
	
	
//	public static String Connect(String text,String lat, String lon){
//		try {
//			String url = "https://maps.vnpost.vn/api/search?focus.point.lat="+lat+"&focus.point.lon="+lon+"&text="+text;
//			
//			HttpGet request = new HttpGet(url);
//			request.setHeader("apikey", "7cb80a390b89d5fefae75fc58b01d01dd04a15bb62b3b141");
//			try (CloseableHttpResponse response = httpClient.execute(request)) {
//	            HttpEntity entity = response.getEntity();
//	            Header headers = entity.getContentType();
//	            if (entity != null) {
//	                // return it as a String
//	                String result = EntityUtils.toString(entity);
//	                JSONObject json = JSONFactoryUtil.createJSONObject(result);
//	                String MSG_CODE = json.getString("code");
//	                System.out.println("code"+MSG_CODE);
//	            }
//
//	        }
//			
//			
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//		return null;
//		
//	}

}
