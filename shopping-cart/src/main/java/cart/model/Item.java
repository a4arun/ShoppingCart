package cart.model;

import java.io.Serializable;

/**
 * Item model
 *
 * @author Arun Pradhan
 */
public class Item implements Serializable {

	private static final long serialVersionUID = -3584839686765253545L;

	private long id;

	private String name;

	private double price;

	int discountCount;

	public Item() {
		super();
	}

	public Item(long id, String name, double price, int discountCount) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.discountCount = discountCount;
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

	public int getDiscountCount() {
		return discountCount;
	}

	public void setDiscountCount(int discountCount) {
		this.discountCount = discountCount;
	}
}
