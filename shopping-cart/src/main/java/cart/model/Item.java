package cart.model;

import java.io.Serializable;
/**
 * Item model
 * 
 * @author Arun Pradhan
 *
 */
public class Item implements Serializable{

	
	private static final long serialVersionUID = -3584839686765253545L;
	
	private long id;
	
	private String name;
	
	private double price;

	public Item() {
		super();
	}

	
	public Item(long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}	
}
