package repositories;

import java.util.Collection;
import java.util.Iterator;

import javax.enterprise.context.ApplicationScoped;

import model.Shelf;

@ApplicationScoped
public class ShelfRepository extends EntityRepository <Shelf> {

	
	
	public int getAvailableShelf() {
		Collection<Shelf> t = getAllEntities(); // list of shelves (Shelf)
		Iterator<Shelf> i = t.iterator(); 	// i[a] - i[a++]
		while(i.hasNext()) {
			Shelf s = i.next();
			if (s instanceof Shelf) 
				if (s.getCapacity() > s.getNumberOfProds())
					return s.getId();
		}
		return 0;
	}
	
}

