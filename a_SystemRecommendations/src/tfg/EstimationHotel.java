package tfg;

import java.io.IOException;
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

	public static void main(String arg[]){
		try {
			System.out.println("hola");
			/*System.out.println("ab,c,d".split("|")[2]);
			String a = "(rojo claro|amarillo|verde azul|morado|marrón)";
			String colores = a.substring(1, a.length()-1);
			String[] arrayColores = colores.split("\\|");
			 
			// En este momento tenemos un array en el que cada elemento es un color.
			for (int i = 0; i < arrayColores.length; i++) {
				System.out.println(arrayColores[i]);
			}*/
			System.out.println(getScore("Madrid", "Palace", "Precio"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * P(A) = Hotel + city+nameHotel
	 * P(B) = Hotel + city + term
	 * conditional probability =(P(A) && P(B))/P(B)
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
		//return pAandpB;
	}
	
	
	public static double getScore(String city, String nameHotel, String term) throws Exception{
		//termin = a,b,c
				String[] terms = term.split(",");
				double precio = 0;
				double limpieza = 0;
				for (String simple : terms) {
					switch (simple) {
					case "Precio":
						precio = getScorePrice(city,nameHotel);
						break;
					case "Limpieza":
						limpieza = getScoreCleanness(city,nameHotel);
						break;
					default:
						break;
					}
				}
			return 0;	
	}
	
	private static double getScoreCleanness(String city, String nameHotel) {
		// TODO Auto-generated method stub
		return 0;
	}


	private static double getScorePrice(String city, String nameHotel) throws Exception {
		// TODO Auto-generated method stub
		double positive = 0;
		double negative = 0;
		
		
		
		String cad = HotelFeature.TARIFA.getPositiveRegularExpression();
		String cad2 = cad.substring(1, cad.length()-1);
		String pricePositive [] = cad2.split("\\|");
		positive = getValues(city, nameHotel, pricePositive);
				
		String priceNegative [] = HotelFeature.TARIFA.getNegativeREgularExpression().split("\\|");;
		negative = getValues(city, nameHotel, priceNegative);
		
		
		if (positive > negative){
			double pResult = 0;
			if (positive < 0)
				pResult = positive * 5;
			else 
				System.out.println("Posive price > 1");
			return pResult;
		}
	
		else{
			double nResult = 0;
			if (negative < 0)
				nResult = negative * 5;
			else 
				System.out.println("Posive negative > 1");
			return nResult;
			
		}
			
	}
	
	



	
	
	private static double getValues(String city, String nameHotel,
			String[] pricePositive) throws MalformedURLException, Exception {
		double result=0;
	
		for (int i = 0; i < 2; i++) {
			result += getBayes( city, nameHotel, pricePositive[i]);
		}
		return result;
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
