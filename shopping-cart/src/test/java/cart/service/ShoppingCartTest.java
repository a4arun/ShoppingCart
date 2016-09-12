package cart.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import cart.model.Item;

/**
 * Unit test for Shopping Cart.
 */
public class ShoppingCartTest {

	ShoppingCart cart;
	ShoppingCartItem scCartItem;
	Item apple;
	Item orange;

	@Before
	public void setUp() {
		cart = new ShoppingCart();
		apple = new Item(1, "Apple", 0.20);
		orange = new Item(1, "Orange", 0.20);
		scCartItem = new ShoppingCartItem(apple);
		scCartItem = new ShoppingCartItem(orange);
	}

	@Test
	public void addOneItemIntoCart() {

		cart.addItem(apple);
		assertThat(cart.getItemCount(), is(1));
		assertThat(cart.calculateTotalPrice(), is(0.20));
	}

	@Test
	public void addMoreItemIntoCart() {

		cart.addItem(apple);
		cart.addItem(orange);
		assertThat(cart.getItemCount(), is(2));
		assertThat(cart.calculateTotalPrice(), is(0.4));
	}
	
	@Test
	public void clearCart() {

		cart.addItem(apple);
		cart.addItem(orange);
		cart.clearCart();
		assertThat(cart.getItemCount(), is(0));
		assertThat(cart.calculateTotalPrice(), is(0.0));
	}
}
