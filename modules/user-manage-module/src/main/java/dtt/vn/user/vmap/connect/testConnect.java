package dtt.vn.user.vmap.connect;



import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class testConnect {
	private static final CloseableHttpClient httpClient = HttpClients.createDefault();
	
	public static String Connect(String lat, String lon, String text){
		try {
			String url = "https://maps.vnpost.vn/api/search?focus.point.lat="+lat+"&focus.point.lon="+lon+"&text="+text;
		
			HttpGet request = new HttpGet(url);
			request.setHeader("apikey", "7cb80a390b89d5fefae75fc58b01d01dd04a15bb62b3b141");
			try (CloseableHttpResponse response = httpClient.execute(request)) {

	            // Get HttpResponse Status
	            System.out.println(response.getStatusLine().toString());

	            HttpEntity entity = response.getEntity();
	            Header headers = entity.getContentType();
	            System.out.println(headers);

	            if (entity != null) {
	                // return it as a String
	                String result = EntityUtils.toString(entity);
	                System.out.println(result);
	            }

	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
		
	}
	
}
