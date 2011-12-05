package com.sample.ejb3.session.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sample.ejb3.Constants;
import com.sample.ejb3.sfsb.simple.Cart;

public class StatefulClient {

	private static InitialContext ctx;

	public static void main(String[] args) throws Exception {

		ctx = new InitialContext();
		manageCart();
		// callSimpleThroughWorker();

	}

	private static void manageCart() {

		String[] items = { "Book", "Pen", "Paper" };
		try {
			Cart myCart = (Cart) ctx.lookup(Constants.BUSINESS_REMOTE_CART);

			myCart.addToCart(items[0]);
			System.out.println("Contents of cart:" + myCart.showCart());
			myCart.addToCart(items[1]);
			System.out.println("Contents of cart:" + myCart.showCart());
			myCart.removeFromCart(items[0]);
			System.out.println("Contents of cart:" + myCart.showCart());
			myCart.removeFromCart("XYZ");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
