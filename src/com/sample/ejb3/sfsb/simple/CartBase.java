package com.sample.ejb3.sfsb.simple;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import com.sample.ejb3.aspects.LogTimeInterceptor;
import com.sample.ejb3.session.exception.ResourceNotFoundAppException;

@Stateful
@Remote(CartBusinessRemote.class)
@Local(CartBusinessLocal.class)
@Interceptors(LogTimeInterceptor.class)
public class CartBase implements CartBusinessRemote, CartBusinessLocal {

	private String contents;

	@Override
	public void addToCart(String item) {
		if (contents == null)
			this.contents = new String(item);
		else
			this.contents += item;
	}

	@Override
	public void removeFromCart(String item) throws ResourceNotFoundAppException {
		int index = -1;
		if ((index = contents.indexOf(item)) != -1) {
			contents = contents.substring(0, index)
					+ contents.substring(index + item.length());
		} else
			throw new ResourceNotFoundAppException("Item not found in cart.");

	}

	@Override
	public String showCart() {
		return new String(contents);
	}

}
