package services;

import java.util.Collection;

import model.Product;
import repositories.ProductRepository;

public class ProductServices {

	ProductRepository repo = ProductRepository.getInstance();
	
	
	
	public Collection<Product> getAll() {
		
		return repo.getAllEntities();
	}

	
	public int create(Product prod) {
		
		return repo.createEntity(prod);
		
	}
	
	
	public Product getId(int id) {
		
		return repo.getEntity(id);
	}

	
	public void remove(int id) {
		repo.removeEntity(id);
	}

	
	public Product put(int id, Product product) {
		
		return repo.editEntity(product);
	}

}
