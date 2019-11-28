package model;

import java.io.Serializable;

public class Entity implements Serializable{

	private static final long serialVersionUID = 1L;
private int id;
	
	public Entity (){
	
				
	}

	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
}