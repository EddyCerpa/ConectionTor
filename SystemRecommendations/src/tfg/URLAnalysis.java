package tfg;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class URLAnalysis {
	
	private String url;
	private ContainerKeyWord positiveRegularExpresion;
	private ContainerKeyWord negativeRegularExpresion;
	private ContainerKeyWord negativeWord;
	private ContainerKeyWord positiveWord;
	public static String line_separator = System.getProperty("line.separator");
	
	
	public URLAnalysis(String url_) {
		// TODO Auto-generated constructor stub
		url = url_;
		positiveRegularExpresion = new ContainerKeyWord();
		negativeRegularExpresion = new ContainerKeyWord();
		negativeWord = new ContainerKeyWord();
		positiveWord = new ContainerKeyWord();
	}
	
	public void addPostiveExpresion(String string){
		positiveRegularExpresion.addRegularExpression(string);
	}
	
	
	public void addNegativeExpresion(String string){
		negativeRegularExpresion.addRegularExpression(string);
	}
	
	public String getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return url+ line_separator
				+ "Positive RE"+line_separator+positiveRegularExpresion.toString()+ line_separator
				+ "Negative RE"+ line_separator+negativeRegularExpresion.toString()+ line_separator
				+ "Negative Word"+ line_separator+negativeWord.toString()+ line_separator
				+ "Positive Word"+ line_separator+positiveWord.toString()+ line_separator;
		
	}

	public void addPositiveWord(String string) {
		positiveWord.addRegularExpression(string);
	}
	
	public void addNegativeWord(String string) {
		negativeWord.addRegularExpression(string);
	}


	
	public JsonElement getJson() {
		JsonObject infoWeb = new JsonObject();
		infoWeb.addProperty("url", url);
		infoWeb.addProperty("positiveRegularExpresion", positiveRegularExpresion.getQuantityElement());
		infoWeb.addProperty("negativeRegularExpresion", negativeRegularExpresion.getQuantityElement());
		infoWeb.addProperty("negativeWord", negativeWord.getQuantityElement());
		infoWeb.addProperty("positiveWord", positiveWord.getQuantityElement());
		/*
		 	JsonArray arrayJson = new JsonArray();
		 
	        // create a dataset
	        JsonObject dataset = new JsonObject();
	        // add the property album_id to the dataset
	        dataset.addProperty("album_id", 1);
	        // add the property album_year to the dataset
	        dataset.addProperty("album_year", 1996);
	        arrayJson.add(dataset);*/
		
		infoWeb.add("PositiveWordList",positiveWord.buildJsonArray());
		infoWeb.add("NegativeWordList",negativeWord.buildJsonArray());
		infoWeb.add("positiveRegularExpresionList",positiveRegularExpresion.buildJsonArray());
		infoWeb.add("negativeRegularExpresionList",negativeRegularExpresion.buildJsonArray());
		return infoWeb;
	}


	
}
