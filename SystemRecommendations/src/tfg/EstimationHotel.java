package tfg;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;


public class EstimationHotel {
	/*private long totalResults;
	private long favorableResults;
	private long negativeResults;
	private double estimation;

	public EstimationHotel() {
		this.totalResults = 0;
		this.favorableResults = 0;
		this.negativeResults = 0;
		this.estimation = 0.0;
	}*/
	/*
	private String getURL (String query) throws MalformedURLException{
		return "http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&q=" + query.replaceAll("\\s", "%20").trim();
		 
	}*/
	
	/*
	public double searchBayes(String place, String hotel) throws NumberFormatException,
			JSONException, Exception {
			
		double limpio = bayes (place, hotel, "limpios");
		System.out.println("limpio : " + limpio);
		
		double sucio = bayes (place, hotel, "sucio");
		System.out.println("sucio : " + sucio);
		
		
		return this.estimation;
		
	}*/
	
	// hotel madrid Palacio sucio
	/*private double bayes (String place, String hotel, String termino) throws MalformedURLException, Exception{
		
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
		
		
	}*/
	
	/**
	 * P(A) = Hotel + city+nameHotel
	 * P(B) = Hotel + city + term
	 * conditional probability = (P(A) && P(B))/P(B)
	 * @param city city where the hotel
	 * @param nameHotel Hotel Name
	 * @param termsearch criterion
	 * @return probability of bayes 
	 * @throws Exception 
	 * @throws MalformedURLException 
	 */
	public static double getBayes(String city, String nameHotel, String term) throws MalformedURLException, Exception{
		JSONObject json = TestGetJSON.getJSON(TestGetJSON.generateGoogleApiSearch("hotel "+city + " " + nameHotel +" "+ term,0));
		double pAandpB = getNumberResults(json); // numerador
		System.out.println("ayb " + pAandpB);
		
		json = TestGetJSON.getJSON(TestGetJSON.generateGoogleApiSearch("hotel "+city +" "+ term,0));
		double pB = getNumberResults(json); // numerador
		System.out.println("b "+pB);
		return pAandpB / pB;
	}
	
	
	// round two decimal
	/*private double roundTwoDecimals(double d) { 
	      DecimalFormat twoDForm = new DecimalFormat("#.##"); 
	      return Double.valueOf(twoDForm.format(d));
	}
	*/
	private static long getNumberResults(JSONObject json) throws NumberFormatException,
			JSONException {
		return Long.parseLong(json.getJSONObject("responseData")
				.getJSONObject("cursor").getString("estimatedResultCount"));
	}

}
