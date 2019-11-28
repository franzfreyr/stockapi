package controller;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Shelf;
import services.ShelfServices;

@Path("shelfs")
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
}
