package repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import model.Shelf;

public class ShelfRepository extends EntityRepository <Shelf> {

	private static final ShelfRepository INSTANCE = new ShelfRepository();
	
	private ShelfRepository() {
	}
	
	public static ShelfRepository getInstance() {
		return INSTANCE;
	}
	
	
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

