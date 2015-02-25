package tfg;

public class Hotel {
	private double latitude;
	private double longitude;
	private String nombre;
	public static String line_separator = System.getProperty("line.separator");
	
	public  Hotel(double latitude_, double longitude_, String nombre_) {
		latitude = latitude_;
		longitude = longitude_;
		nombre = nombre_;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	@Override
	public String toString() {
		return "nombre: " + nombre + line_separator 
				+"latitude:" + latitude + line_separator
				+ "longitude:" + longitude + line_separator;
				
	}
}
