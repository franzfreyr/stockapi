package controller;

import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Shelf;
import services.ShelfServices;

@Path("shelves")
public class ShelfController {
	
ShelfServices service = new ShelfServices();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Shelf> listAll() {
		return service.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int create(Shelf shelf) {

		return service.create(shelf);
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	
	public Shelf getOne(@PathParam("id") int id) {
		
		return service.getId(id);
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		service.remove(id);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf update(@PathParam("id") int id, Shelf shelf) {
		
		return service.put(id, shelf);
		
		 
	}
}
