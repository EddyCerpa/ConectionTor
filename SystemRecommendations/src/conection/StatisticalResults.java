package conection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import tfg.EstimationHotel;



//http://localhost:8080/SystemRecommendations/Results?city=Madrid&hotel=Palace&termino=sucio
//http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&q=hotel%20Palace%20sucio
@Path("/Results")
public class StatisticalResults {
	
	@GET
	@Produces("application/json")
	public String results(@QueryParam("city")String city, 
						@QueryParam ("hotel") String nameHotel, 
						@QueryParam("termino") String term) {
		String string = "";
		
		try {
			//System.out.println("Bayes: " + EstimationHotel.getBayes(city, nameHotel, term)/*eh.searchBayes("Hotel Madrid", "Palace")*/);
			string =  new Gson().toJson(EstimationHotel.getBayes(city, nameHotel, term));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;
		
	}

}
