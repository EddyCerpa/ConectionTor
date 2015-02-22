package tfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class TestGetJSON {
//http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&q=hoteles
	
	
	
	public static JSONObject getJSON (String url) throws Exception {
		
		URL urlComplete = new URL(url);
		 URLConnection connection = urlComplete.openConnection();
		//String query = URLEncoder.encode(query, "UTF-8");
		// Get the JSON response
			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			reader.close();

			String response = builder.toString();
			JSONObject json = new JSONObject(response);
			return json;
	
	}
	
	public static String getJSONObjet(String query, String search) throws JSONException{
		JSONObject jsonObjectN = new JSONObject(query);
		return jsonObjectN.getString(search);
	}
}
