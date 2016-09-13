package cart.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import cart.model.Item;
import cart.service.impl.ShoppingCartServiceImpl;

/**
 * Unit test for Shopping Cart.
 */
public class ShoppingCartTest {

	ShoppingCartService cart;

	@Before
	public void setUp() {
		cart = new ShoppingCartServiceImpl();		
	}

	@Test
	public void testAddOneItemIntoCart() {

		cart.addItem(new Item(1, "Apple", 0.60, 1));
		assertThat(cart.getItemCount(), is(1));
		assertThat(cart.calculateTotalPrice(), is(0.60));
	}

	@Test
	public void testAddMoreItemIntoCart() {

		cart.addItem(new Item(1, "Apple", 0.60, 1));
		cart.addItem(new Item(2, "Orange", 0.25, 1));
		assertThat(cart.getItemCount(), is(2));
		assertThat(cart.calculateTotalPrice(), is(0.85));
	}

	

	@Test
	public void test2For1Offer() {
		cart.addItem(new Item(1, "Apple", 0.60, 2));
		cart.addItem(new Item(1, "Apple", 0.60, 2));
		assertThat(cart.getItemCount(), is(2));
		assertThat(cart.calculateTotalPrice(), is(0.60));
	}

	@Test
	public void test3For2Offer() {
		cart.addItem(new Item(1, "Orange", 0.25, 3));
		cart.addItem(new Item(2, "Orange", 0.25, 3));
		cart.addItem(new Item(3, "Orange", 0.25, 3));
		assertThat(cart.getItemCount(), is(3));
		assertThat(cart.calculateTotalPrice(), is(0.50));
	}
	@Test
	public void testClearCart() {

		cart.addItem(new Item(1, "Apple", 0.60, 1));
		cart.addItem(new Item(1, "Orange", 0.25, 1));
		cart.clearCart();
		assertThat(cart.getItemCount(), is(0));
		assertThat(cart.calculateTotalPrice(), is(0.0));
	}
}
