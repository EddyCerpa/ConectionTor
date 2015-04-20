package conection;

import java.io.IOException;
import java.net.URLEncoder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.json.JSONException;

import tfg.TestGetJSON;
import tfg.WebFound;


//http://localhost:8080/SystemRecommendations/TermWebs?search=Hotel%20Madrid%20Palace&scan=8

@Path("/TermWebs")
public class TerminsWebsResults {

	@GET
	@Produces("application/json")
	public String terminsWebs(@QueryParam ("search") String query, 
								@QueryParam("scan") int numberUrl){
		
		int pages = numberUrl / 8;
		int restWebs  = numberUrl % 8;
		WebFound webFound = new WebFound(numberUrl);
		int i = 0;
		
		for (; i < pages; i++)
			try {
				//query = URLEncoder.encode(query, "UTF-8");
				String url = TestGetJSON.generateGoogleApiSearch(query, i*8); 
				webFound.addUrlList(TestGetJSON.getJSON(url),8);
				
			} catch (Exception e) {e.printStackTrace();}
		
		// resto
		if (restWebs != 0){
			i++;
	
			try {
				String url = TestGetJSON.generateGoogleApiSearch(query, (i*8));
				webFound.addUrlList(TestGetJSON.getJSON(url),restWebs);
			} catch (JSONException | IOException e2) {
				
				e2.printStackTrace();
			}
		}
		// 
		try {
			webFound.scanWebs(numberUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return webFound.getStringJsonArray();
	}
}
