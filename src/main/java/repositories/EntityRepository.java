package repositories;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import model.Entity;



public abstract class EntityRepository <T extends Entity> {
	
	private Map<Integer,T> t = new LinkedHashMap<Integer,T>();
	private int lastId=0;
	
	public int returnLastID() {
		return lastId;
	}
	
	public int createEntity(T entity) {	
		lastId++;
		entity.setId(lastId);
		t.put(lastId,entity);
		
		return lastId;
	}
	
	public T getEntity(int ID) {
		return t.get(ID);
	}
	
	public Collection<T> getAllEntities(){
		return t.values();
	}
	
	public Collection<Integer> getAllIds(){
		return t.keySet();
	}
	
	public void editEntity(T editEntity) {
		
		t.put(editEntity.getId(),editEntity);
	}
	
	public void removeEntity(int ID) {
		t.remove(ID);
	}
	
}