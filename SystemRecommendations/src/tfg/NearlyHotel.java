package tfg;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/*
 * https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=food&name=harbour&sensor=false&key=AIzaSyBhmi0Tza5mePpDCBv4F4_OJywxEhD67Ic
 https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=40.420138,-3.704801&radius=500&types=lodging&sensor=false&key=AIzaSyBhmi0Tza5mePpDCBv4F4_OJywxEhD67Ic
 */
/**
 * Class that manages hotels near a position
 * @author pc003
 *
 */
public class NearlyHotel {
	private PositionOfSearch positionOfSearch;
	private ArrayList<Hotel> hotels;
	public static String line_separator = System.getProperty("line.separator");

	
	
	/**
	 * Method which represents the closest hotels in a specific position
	 * @param url_ API Google map
	 * @param key_ key to user
	 * @param position scanning position
	 */
	public NearlyHotel(PositionOfSearch position) {
		positionOfSearch = position;
		hotels = new ArrayList<Hotel>();
	}

	
	/**
	 * Method that adds to the list of hotels found
	 * @param json json object which is obtained hotels
	 * @throws Exception 
	 */
	public void SearchHotel() throws Exception {
		String url = TestGetJSON.generateGoogleApiMaps(positionOfSearch);
		JSONObject json = TestGetJSON.getJSON(url);
			
			JSONArray jsonArray = new JSONArray(json.getString("results"));
			System.out.println("\n\njsonArray: " + jsonArray);
			int count = jsonArray.length(); 
			for(int i=0 ; i< count ; i++){   // iterate through jsonArray 
				JSONObject jsonObject = jsonArray.getJSONObject(i);  // get jsonObject @ i position 
				System.out.println("jsonObject " + i + ": " + jsonObject);
				
				String name = jsonArray.getJSONObject(i).getString("name");
				//String vicinity = jsonArray.getJSONObject(i).getString("vicinity");
				String lat = TestGetJSON.getJSONObjet(TestGetJSON.getJSONObjet(jsonArray.getJSONObject(i).getString("geometry"), "location"), "lat");
				String lng = TestGetJSON.getJSONObjet(TestGetJSON.getJSONObjet(jsonArray.getJSONObject(i).getString("geometry"), "location"), "lng");
				Hotel hotel = new Hotel(Double.parseDouble(lat), Double.parseDouble(lng), name );
				hotels.add(hotel);
				//System.out.println("-----");
			
			}
	}
	
	
	
	public void SearchHotel(int number) throws Exception {
		String url = TestGetJSON.generateGoogleApiMaps(positionOfSearch);
		JSONObject json = TestGetJSON.getJSON(url);
			
			JSONArray jsonArray = new JSONArray(json.getString("results"));
			System.out.println("\n\njsonArray: " + jsonArray);

			for(int i=0 ; i< number ; i++){   // iterate through jsonArray 
				JSONObject jsonObject = jsonArray.getJSONObject(i);  // get jsonObject @ i position 
				System.out.println("jsonObject " + i + ": " + jsonObject);
				
				String name = jsonArray.getJSONObject(i).getString("name");
				//String vicinity = jsonArray.getJSONObject(i).getString("vicinity");
				String lat = TestGetJSON.getJSONObjet(TestGetJSON.getJSONObjet(jsonArray.getJSONObject(i).getString("geometry"), "location"), "lat");
				String lng = TestGetJSON.getJSONObjet(TestGetJSON.getJSONObjet(jsonArray.getJSONObject(i).getString("geometry"), "location"), "lng");
				Hotel hotel = new Hotel(Double.parseDouble(lat), Double.parseDouble(lng), name );
				hotels.add(hotel);
				//System.out.println("-----");
			
			}
	}
	
	
	
	
	@Override
	public String toString() {
		String string = "";
		if (hotels.isEmpty())
			return "List hotels empty";
		
		for (Hotel hotel : hotels) {
			
			string += "------"
					+line_separator
					+hotel.toString();
		}
		return string;
	}


}
