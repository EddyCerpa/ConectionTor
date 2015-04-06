package conection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import tfg.NearlyHotel;
import tfg.PositionOfSearch;


//http://localhost:8080/SystemRecommendations/SearchHotel?radio=500&lat=40.43&lon=-3.70
@Path("/SearchHotel")
public class SearchHotel {

	@GET
	@Produces(MediaType.APPLICATION_JSON)//"application/json"
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces("text/plain")
	public String nearlyHotel(@QueryParam("radio") int radius, 
								@QueryParam("lat") double latitude,
								@QueryParam("lon") double longitude){
		PositionOfSearch position = new PositionOfSearch(latitude, longitude,radius);//40.42 -3.72
		NearlyHotel nH = new NearlyHotel(position);

		try {
			nH.SearchHotel();
			System.out.println(nH.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nH.getGson();
		
		
	}
}
