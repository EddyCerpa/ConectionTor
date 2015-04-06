package tfg;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Hotel {
	private double latitude;
	private double longitude;
	private String name;
	private String vicinity;
	public static String line_separator = System.getProperty("line.separator");
	
	public  Hotel(double latitude_, double longitude_, String nombre_, String vicinity_) {
		latitude = latitude_;
		longitude = longitude_;
		name = nombre_;
		vicinity = vicinity_;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public String getVicinity() {
		return vicinity;
	}
	
	
	public JsonElement getJson(){
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", name);
		jsonObject.addProperty("latitude", latitude);
		jsonObject.addProperty("longitude", longitude);
		jsonObject.addProperty("vicinity", vicinity);
		return jsonObject;
	}
	
	@Override
	public String toString() {
		return "name: " + name + line_separator 
				+"vicinity: " + vicinity + line_separator
				+"latitude:" + latitude + line_separator
				+ "longitude:" + longitude + line_separator;
	}
}
