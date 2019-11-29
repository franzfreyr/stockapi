package services;

import java.util.Collection;
import model.Shelf;
import repositories.ShelfRepository;

public class ShelfServices {

	ShelfRepository repo = ShelfRepository.getInstance();

	
	
	public Collection<Shelf> getAll() {

		return repo.getAllEntities();
	}
	public int create(Shelf shelf) {

		return repo.createEntity(shelf);
	}

	public Shelf getId(int id) {

		return repo.getEntity(id);
	}

	public void remove(int id) {

		repo.removeEntity(id);
	}

	public Shelf put(int id, Shelf shelf) {

		return repo.editEntity(shelf);
	}
}
