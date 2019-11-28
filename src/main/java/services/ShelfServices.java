package services;

import java.util.Collection;
import model.Shelf;
import repositories.ShelfRepository;

public class ShelfServices {

	ShelfRepository repo = ShelfRepository.getInstance();

	public Collection<Shelf> getAll() {
		// TODO Auto-generated method stub
		return repo.getAllEntities();
	}

	public int create(Shelf shelf) {

		return repo.createEntity(shelf);

	}
}
