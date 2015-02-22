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

import prueba2.GestionWord;

public class Web {
	

	private ArrayList<URLAnalisys> url;
	//private static String POSITVE_REGULAR_EXPRESION = "[Hh]otel palace ((si )?)(permite|dispone( de)?|tiene( buen)?|con) (wifi|parking|fumadores|mascotas|servicio|servicio de habitacion)";
	//private static String NEGATIVE_REGULAR_EXPRESION = "[Hh]otel palace ((no )?)(permite|dispone( de)?|tiene( mal)?|sin) (wifi|parking|fumadores|mascotas|servicio de habitacion)";
	public static String line_separator = System.getProperty("line.separator");
	
	public Web() {
		// TODO Auto-generated constructor stub
		url = new ArrayList<URLAnalisys>();
	}
	
	public void addUrlList(JSONObject json) throws JSONException, IOException {
		
		JSONArray jsonArray = new JSONArray(TestGetJSON.getJSONObjet(json.getString("responseData"), "results"));
		
		int count = jsonArray.length(); // get totalCount of all jsonObjects
		System.out.println(count);
		for(int i=0 ; i< jsonArray.length() ; i++){   // iterate through jsonArray 
			String vicinity = jsonArray.getJSONObject(i).getString("url");
			System.out.println("url: " + vicinity);
			URLAnalisys as = new URLAnalisys(vicinity);
			url.add(as);
			//getHtml(vicinity);
			procesamiento(getHtml(vicinity), as);
			System.out.println("-----");
		
		}
	} 
	
	private StringBuilder getHtml(String url_) {
		 StringBuilder sb = new StringBuilder();
		try {
		    //Creamos el objeto con el que vamos a leer
		    BufferedReader in;
			
				 URL url = new URL(url_);
				    URLConnection uc = url.openConnection();
				    uc.connect();
				
					in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				
		    String inputLine;
		   
		    while ((inputLine = in.readLine()) != null) {
		       // contenido += inputLine + "\n";
		        sb.append(inputLine);
		    }
		    in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    return sb;
			//return sb.append("hotel palace tiene buen servicio jaja mala opción jaj no me acuerdo Hotel palace tiene wifi gratis no se por q es y ademas con limpieza continua es un buen hotel con todo lo que necesitas ademas vuelvo a decir todo lo que necesitas y tiene parking en el hotel ");
	}
	
	
	
	private void procesamiento (StringBuilder html, URLAnalisys url_) throws IOException{
		
		//String html = getHtml(url_.getUrl());
		// 
		
		
		
		StringBuilder cad = new StringBuilder(html);
		//cad = cad.append( "wifi gratis servicio de cocina limpieza");
		System.out.println("ERs ++ ");
		positiveRE(cad, url_);
		System.out.println("ERs -- ");
		negativeRE(cad, url_);
		System.out.println("kw ++ ");
		positiveWord(cad, url_);
		System.out.println("kw -- ");
		negativeWord(cad, url_);
		// continuamos con las negativas etc
	
	}
	
	private void positiveWord(StringBuilder html, URLAnalisys url_) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(GestionWord.toStringPositiveWords());
		 Matcher m = p.matcher(html);// aqui va el html
		 while (m.find()) {
		     url_.addPositiveWord(m.group(0));   
		 }
	}
	
	private void negativeWord(StringBuilder html, URLAnalisys url_) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(GestionWord.toStringNegativeWords());
		 Matcher m = p.matcher(html);// aqui va el html
		 while (m.find()) {
		     url_.addNegativeWord(m.group(0));   
		    
		 }
	}

	private void negativeRE(StringBuilder html, URLAnalisys url_) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(GestionWord.toStringNegativeWords());
		 Matcher m = p.matcher(html);// aqui va el html
		 while (m.find()) {
		     url_.addNegativeExpresion(m.group(0));   
		 }
	}

	private void positiveRE (StringBuilder html, URLAnalisys url_){
			Pattern p = Pattern.compile(GestionWord.toStringREPositiva());
		 Matcher m = p.matcher(html);// aqui va el html
		 while (m.find()) {
		     url_.addPostiveExpresion(m.group(0));   
		 }
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = "";
		for (URLAnalisys urlAnalisys : url) {
			string += urlAnalisys.toString() + line_separator;
		}
		return string;
	}
	

}
