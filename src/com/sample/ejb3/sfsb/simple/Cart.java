package com.sample.ejb3.sfsb.simple;

import com.sample.ejb3.session.exception.ResourceNotFoundAppException;

public interface Cart {

	public void addToCart(String item);

	public void removeFromCart(String item) throws ResourceNotFoundAppException;

	public String showCart();

}
