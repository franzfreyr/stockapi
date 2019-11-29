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
import model.Product;
import services.ProductServices;

@Path("products")
public class ProductController {

	ProductServices service = new ProductServices();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Product> listAll() {
		return service.getAll();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int create(Product product) {

		return service.create(product);
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	
	public Product getOne(@PathParam("id") int id) {
		
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
	public Product update(@PathParam("id") int id, Product product) {
		
		return service.put(id, product);
		
		 
	}




}
