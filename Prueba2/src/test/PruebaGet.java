package test;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



@Path("/Prueba")
public class PruebaGet {
	
	
	@GET
	@Path("/get.json")
	//@Produces({"application/json", MediaType.APPLICATION_JSON})//"application/json"
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getString(){
		
		JSONObject jo = new JSONObject();
		try {
			jo.put("nombre", "NOseee");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONArray ja = new JSONArray();
		ja.put(jo);
		//return ja.toString();
		return Response.status(200).entity(ja.toString()).build();
		//return "[ { \"nombre\" : \" Prueba\" }, { \"nombre\" : \"Prueba2\" } ]";
	}
	
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON() {
 
		String result = "Track saved : " ;
		return Response.status(201).entity(result).build();
 
	}

}
