package controller;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Entity;
import repositories.EntityRepository;
import services.AbstractServices;

public abstract class AbstractController  <T extends AbstractServices <R,E>, R extends EntityRepository<E>, E extends Entity > {
	
	@Inject
	protected T service;
	
	@GET
	@Path("healtcheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "Controller works";
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<E> listAll() {
		return service.getAll();

	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public long create (E Entity) {
		
		return service.create(Entity);
	}
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	
	public E getOne(@PathParam("id") int id) {
		
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
	public E update(@PathParam("id") int id, E Entity) {
		
		return service.put(id, Entity);
		
		 
	}

	
	

}
