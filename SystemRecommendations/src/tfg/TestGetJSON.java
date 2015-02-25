package tfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class TestGetJSON {
//http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&q=hoteles
	
	public static final String API_GOOGLE_MAPS = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=";
	public static final String API_GOOGLE_SEARCH = "http://ajax.googleapis.com/ajax/services/search/web?start=";
	public static final String Key = "AIzaSyBhmi0Tza5mePpDCBv4F4_OJywxEhD67Ic";
	
	
	public static String generateGoogleApiMaps(PositionOfSearch position){
		return API_GOOGLE_MAPS+ position.getLatitude() +","
				 +position.getLongitude()
				+"&radius="+ position.getRadius()
				+"&types=lodging"
				+"&sensor=false"
				+ "&key=" + Key;
	}
	
	public static String generateGoogleApiSearch (String query, int num) throws MalformedURLException{
		return API_GOOGLE_SEARCH + num+"&rsz=large&v=1.0&q="+query.replaceAll("\\s", "%20").trim(); 
	}
	
	
	public static JSONObject getJSON (String url) throws IOException, JSONException  {
		
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
