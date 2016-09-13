package cart.service;

import java.util.List;

import cart.model.Item;

public interface ShoppingCartService {

	/**
	 * This will return list of items are added into cart.
	 * 
	 * @return
	 */
	List<ShoppingCartItem> getItems();

	/**
	 * This will return total price of the items.
	 * 
	 * @return
	 */
	double getPrice();

	/**
	 * This will add the selected item into the shopping cart
	 * 
	 * @param itemSelected
	 */
	void addItem(Item itemSelected);

	/**
	 * This will update the shopping cart.
	 * 
	 * @param itemSelected
	 * @param quantity
	 */
	void updateItem(Item itemSelected, int quantity);

	/**
	 * This will return number of item which add added into cart.
	 * 
	 * @return
	 */
	int getItemCount();

	/**
	 * This will calculate total price of the items, that are added into cart.
	 * 
	 * @return
	 */
	double calculateTotalPrice();

	/**
	 * This will clear the cart.
	 */
	void clearCart();
}
