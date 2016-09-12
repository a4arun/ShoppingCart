package cart.service;

import cart.model.Item;
/**
 * This will select the Items and its quantity.
 * @author Arun Pradhan
 *
 */
public class ShoppingCartItem {

	private Item item;
	private int quantity;
	
	public ShoppingCartItem(Item item) {
		super();
		this.item = item;
		this.quantity = 1;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Add items into Cart.
	 */
	public void increaseItems() {		
		quantity ++;
	}
	
	/**
	 * Remove Items from the Cart.
	 */
	public void decreaseItems() {
		quantity --;
	}
	
	/**
	 * Calculate the items and its total prices.
	 * @return
	 */
	public double getTotalItemsPrice() {
		return this.getQuantity() * item.getPrice();
	}
}
