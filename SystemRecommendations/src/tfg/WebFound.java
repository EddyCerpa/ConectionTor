package tfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebFound {
	

	private ArrayList<URLAnalysis> arrayListUrl;
	public static String line_separator = System.getProperty("line.separator");
	
	public WebFound() {
		arrayListUrl = new ArrayList<URLAnalysis>();
	}

	public WebFound(int numberUrl) {
		// TODO Auto-generated constructor stub
		arrayListUrl = new ArrayList<URLAnalysis>(numberUrl);
	}

	/**
	 * 
	 * @param json
	 * @param webs max 8 min 1
	 * @throws JSONException
	 * @throws IOException
	 */
	public void addUrlList(JSONObject json, int webs) throws JSONException, IOException {
		
		JSONArray jsonArray = new JSONArray(TestGetJSON.getJSONObjet(json.getString("responseData"), "results"));
		
		for(int i=0 ; i< webs ; i++){ 
			String url = jsonArray.getJSONObject(i).getString("url");
			System.out.println("url: " + url);
			URLAnalysis as = new URLAnalysis(url);
			arrayListUrl.add(as);
		}
	} 
	
	public void scanWebs(int numberUrl) throws IOException{
		
		for (int i = 0; i < arrayListUrl.size() && i < numberUrl; i++) {
			StringBuilder html = getHtml(arrayListUrl.get(i).getUrl());
			URLAnalysis url_ = arrayListUrl.get(i);
			System.out.println("scanning web " + (i+1));
			scanPositiveRegularExpression(html, url_);
			scanNegativeRegularExpression(html, url_);
			scanPositiveWord(html, url_);
			scanNegativeWord(html, url_);
		}
	}
	
	private StringBuilder getHtml(String url_) {
		 StringBuilder sb = new StringBuilder();
		try {
		    	BufferedReader bufferedReader;
				URL url = new URL(url_);
				URLConnection urlConection = url.openConnection();
				urlConection.connect();
				bufferedReader = new BufferedReader(new InputStreamReader(urlConection.getInputStream()));
		
				String line;
		  
				while ((line = bufferedReader.readLine()) != null) 
		        sb.append(line);
				bufferedReader.close();
		} catch (IOException e) {e.printStackTrace();}
		return sb;
			//return new StringBuilder("hotel palace tiene buen servicio jaja mala opci�n jaj no me acuerdo Hotel palace tiene wifi gratis no se por q es y ademas con limpieza continua es un buen hotel con todo lo que necesitas ademas vuelvo a decir todo lo que necesitas y tiene parking en el hotel ");
	}
	
	private void scanPositiveWord(StringBuilder html, URLAnalysis url_) {
		Pattern p = Pattern.compile(RegularExpression.toStringPositiveWords());
		 Matcher m = p.matcher(html);
		 while (m.find()&& !m.group().equalsIgnoreCase("null")) {
		     url_.addPositiveWord(m.group());   
		 }
	}
	
	private void scanNegativeWord(StringBuilder html, URLAnalysis url_) {
		Pattern p = Pattern.compile(RegularExpression.toStringNegativeWords());
		 Matcher m = p.matcher(html);
		 while (m.find()&& !m.group().equalsIgnoreCase("null")) {
		     url_.addNegativeWord(m.group());   
		    
		 }
	}

	private void scanNegativeRegularExpression(StringBuilder html, URLAnalysis url_) {
		 Pattern p = Pattern.compile(RegularExpression.toStringNegativeREgularExpression());
		 Matcher m = p.matcher(html);
		 while (m.find() && !m.group().equalsIgnoreCase("null")) {
		     url_.addNegativeExpresion(m.group());   
		 }
	}

	private void scanPositiveRegularExpression (StringBuilder html, URLAnalysis url_){
		Pattern p = Pattern.compile(RegularExpression.toStringPositiveRegularExpression());
		Matcher m = p.matcher(html);
		while (m.find()&& !m.group().equalsIgnoreCase("null")) {
		     url_.addPostiveExpresion(m.group());   
		}
	}
	
	@Override
	public String toString() {
		String string = "";
		for (URLAnalysis urlAnalisys : arrayListUrl) {
			string += urlAnalisys.toString() + line_separator;
		}
		return string;
	}
	
	public String toString (int number){
		String string = "";
		for (int i = 0; i < number; i++)
			string +=arrayListUrl.get(i).toString() + line_separator;
		return string;
	}

}
