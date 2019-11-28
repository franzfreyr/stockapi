package model;

public class Shelf extends Entity {
	private static final long serialVersionUID = 1L;
	private long capacity;
	private double price;
	private long numberOfProds = 0;

	public Shelf() {
	};

	public long getNumberOfProds() {
		return numberOfProds;
	}

	public void setNumberOfProds(long numberOfProds) {
		this.numberOfProds = numberOfProds;
	}

	public Shelf(long capacity, double price) {
		super();
		this.capacity = capacity;

		this.price = price;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public void increaseNbrOfProds() {
		numberOfProds++;
	}

	public void decreaseNbrOfProds() {
		numberOfProds--;
	}

	@Override
	public String toString() {
		return "Shelf [capacity=" + capacity + ", shelfId=" + getId() + ", price=" + price + ", numberOfProds="
				+ numberOfProds + "]";
	}

}