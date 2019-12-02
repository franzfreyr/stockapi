package controller;

import javax.ws.rs.Path;

import model.Product;
import repositories.ProductRepository;
import services.ProductServices;

@Path("products")
public class ProductController extends AbstractController<ProductServices, ProductRepository, Product> {

	//ProductServices service = new ProductServices();


}
