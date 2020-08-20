package dtt.vn.account.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectWsUtils {
	public static void main(String[] args){

		System.out.println("Hello World");
		String kk = connectServer("http://localhost:8081/333","{\"cmnd\":\"132351436\",\"hoTen\":\"hà thùy linh\"}","application/json");
		System.out.println(kk);
	}
	public static String connectServer(String urlsent, String inputsent,String Content) {
        try {

            URL url = new URL(urlsent);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", Content);

            String input = inputsent;

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            	 return "";

            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            String output2 = "";
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
               
                output2 += output;

            }

            conn.disconnect();
            return output2;

        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return "";
    }
}
