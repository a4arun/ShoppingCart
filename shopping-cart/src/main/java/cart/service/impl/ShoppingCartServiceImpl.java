package cart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import cart.model.Item;
import cart.service.ShoppingCartItem;
import cart.service.ShoppingCartService;

/**
 * 
 * @author Arun Pradhan
 *
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

	List<ShoppingCartItem> items;
	int numebrOfItems;
	double price;

	private static final Logger LOGGER = Logger.getLogger(ShoppingCartServiceImpl.class.getName());

	
	public ShoppingCartServiceImpl() {
		items = new ArrayList<ShoppingCartItem>();
		numebrOfItems = 0;
		price = 0;
	}

	/**
	 * This will return list of items are added into cart.
	 * 
	 * @return
	 */
	public List<ShoppingCartItem> getItems() {

		return items;
	}

	/**
	 * This will return total price of the items.
	 * 
	 * @return
	 */
	public double getPrice() {

		return price;
	}

	/**
	 * This will add the selected item into the shopping cart
	 * 
	 * @param itemSelected
	 */
	public void addItem(Item itemSelected) {

		LOGGER.log(Level.FINE, "Adding items into cart");

		boolean isNewItemAdded = true;
		for (ShoppingCartItem shoppingCartItem : items) {
			if (shoppingCartItem.getItem().getId() == itemSelected.getId()) {
				shoppingCartItem.increaseItems();
				isNewItemAdded = false;
			}
		}

		if (isNewItemAdded) {
			ShoppingCartItem shoppingCartItem = new ShoppingCartItem(itemSelected);
			items.add(shoppingCartItem);
		}
	}

	/**
	 * This will update the shopping cart.
	 * 
	 * @param itemSelected
	 * @param quantity
	 */
	public void updateItem(Item itemSelected, int quantity) {

		LOGGER.log(Level.FINE, "Updating items into cart");
		if (quantity >= 0) {
			ShoppingCartItem shoppingCartItem = null;
			for (ShoppingCartItem sCartItem : items) {
				if (sCartItem.getItem().getId() == itemSelected.getId()) {
					if (quantity != 0) {
						sCartItem.setQuantity(quantity);
					} else {
						shoppingCartItem = sCartItem;
					}

				}
			}

			if (shoppingCartItem != null) {
				items.remove(shoppingCartItem);
			}
		}

	}

	/**
	 * This will return number of item which add added into cart.
	 * 
	 * @return
	 */
	public int getItemCount() {

		for (ShoppingCartItem shoppingCartItem : items) {
			numebrOfItems += shoppingCartItem.getQuantity();
		}
		LOGGER.log(Level.FINE, "Number of items added into cart are: " + numebrOfItems);
		return numebrOfItems;
	}

	/**
	 * This will calculate total price of the items, that are added into cart.
	 * 
	 * @return
	 */
	public double calculateTotalPrice() {

		double price = 0;
		for (ShoppingCartItem shoppingCartItem : items) {
			Item item = (Item) shoppingCartItem.getItem();
			double quantity = shoppingCartItem.getQuantity();
			if (item.getDiscountCount() != 1) {
				quantity = quantity - (quantity / item.getDiscountCount());
			}
			price += quantity * item.getPrice();
		}
		LOGGER.log(Level.FINE, "Total price of items that are added into cart is: " + price);
		return price;
	}

	/**
	 * This will clear the cart.
	 */
	public void clearCart() {

		items.clear();
		numebrOfItems = 0;
		price = 0;
		LOGGER.log(Level.FINE, "Cart is cleared ");
	}
}
