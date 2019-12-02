package services;

import java.util.Collection;
import javax.inject.Inject;
import model.Entity;
import repositories.EntityRepository;
public abstract class AbstractServices<T extends EntityRepository<E>, E extends Entity> {

	@Inject
	protected T repository;

	public Collection<E> getAll() {

		return repository.getAllEntities();
	}

	public int create(E Entity) {

		return repository.createEntity(Entity);
		

	}

	public E getId(int id) {

		return repository.getEntity(id);
	}

	public void remove(int id) {
		repository.removeEntity(id);
	}

	public E put(int id, E Entity) {

		return repository.editEntity(Entity);
	}

}
