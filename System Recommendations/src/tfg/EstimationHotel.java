package tfg;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author Roberto
 *
 */
public class EstimationHotel {
	private long totalResults;
	private long favorableResults;
	private long negativeResults;
	private double estimation;

	public EstimationHotel() {
		this.totalResults = 0;
		this.favorableResults = 0;
		this.negativeResults = 0;
		this.estimation = 0.0;
	}
	
	private String getURL (String query) throws MalformedURLException{
		return "http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&q=" + query.replaceAll("\\s", "%20").trim();
		 
	}
	
	public double searchBayes(String place, String hotel) throws NumberFormatException,
			JSONException, Exception {
			
		double limpio = bayes (place, hotel, "limpios");
		System.out.println("limpio : " + limpio);
		
		double sucio = bayes (place, hotel, "sucio");
		System.out.println("sucio : " + sucio);
		
		
		return this.estimation;
		
	}
	
	// hotel madrid Palacio sucio
	private double bayes (String place, String hotel, String termino) throws MalformedURLException, Exception{
		
		//TestGetJSON testJson = new TestGetJSON();
		
		JSONObject json = TestGetJSON.getJSON(getURL(place + " " + hotel +" "+ termino ));
		 double totalResults = this.getNumberResults(json); // numerador
		System.out.println("a = " + totalResults);
		
		json = TestGetJSON.getJSON(getURL(place + " " + hotel ));
		 double b = this.getNumberResults(json);
		System.out.println("b = " + b);
		
		json = TestGetJSON.getJSON(getURL(place + " " + termino ));
		 double c = this.getNumberResults(json);
		System.out.println("c = " + c);
		return (totalResults/(b*c));
		
		
	}
	
	// round two decimal
	double roundTwoDecimals(double d) { 
	      DecimalFormat twoDForm = new DecimalFormat("#.##"); 
	      return Double.valueOf(twoDForm.format(d));
	}
	
	long getNumberResults(JSONObject json) throws NumberFormatException,
			JSONException {
		return Long.parseLong(json.getJSONObject("responseData")
				.getJSONObject("cursor").getString("estimatedResultCount"));
	}

}
