package repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.enterprise.context.ApplicationScoped;
import model.Product;

@ApplicationScoped
public class ProductRepository extends EntityRepository <Product> {
	
	
	public ArrayList<Product> getProductsInShlefID(int shelfId){
		Collection<Product> t = getAllEntities(); // list of shelves (Shelf)
		Iterator<Product> i = t.iterator(); 	// i[a] - i[a++]
		ArrayList<Product> prods = new ArrayList<Product>();
		while(i.hasNext()) {
			Product p = i.next();
			if (p.getListOfShelves().contains(shelfId))
				prods.add(p);
		}
		return prods;
	}
}
