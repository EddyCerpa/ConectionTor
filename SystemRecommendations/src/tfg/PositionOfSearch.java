package tfg;

public class PositionOfSearch {
	private double latitude;
	private double longitude;
	private int radius;
	
	public PositionOfSearch(double latitude_, double longitude_ , int radius_) {
		latitude = latitude_;
		longitude = longitude_;
		radius = radius_;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public int getRadius() {
		return radius;
	}
}
