package com.f9g4.web.forms;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.f9g4.businessobjects.services.BoardSet;

public class Cart{
	
	private BigDecimal totalPrice = new BigDecimal(0.0); 
	private Map<Integer, CartItem> cartItemsMap = new HashMap<Integer, CartItem>();
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	
	public void addToCart(CartItem item){	
//		synchronized(cartItemsMap){
			cartItemsMap.put(item.getBoardId(), item);
			totalPrice = totalPrice.add(item.getBoardprice());
//		}
	}
	
	public CartItem removeFromCart(Integer itemid){
		CartItem item = cartItemsMap.remove(itemid);
		if(item != null)
		totalPrice = totalPrice.add(item.getBoardprice().negate()); //reduce the price -C
		return item;
	}
	
	public void clearCart(){
//		synchronized(cartItemsMap){
			cartItemsMap.clear();
			totalPrice = new BigDecimal(0.0);
//		}
	}
	
	public void resetFlags() {
		Set<Integer> keyset=cartItemsMap.keySet(); //get the key set
		Iterator<Integer> iterator=keyset.iterator(); //get iterator
		while (iterator.hasNext()) 
		{  
			Integer i = (Integer)iterator.next();  
            CartItem s = cartItemsMap.get(i);
            s.setHasAltered(false);
		}
	}
	
	public BigDecimal recountTotal(){
		Set<Integer> keyset=cartItemsMap.keySet(); //get the key set
		Iterator<Integer> iterator=keyset.iterator(); //get iterator
		totalPrice=new BigDecimal(0.0).setScale(2);
		while (iterator.hasNext()) 
		{  
			Integer i = (Integer)iterator.next();  
            CartItem s = cartItemsMap.get(i);
            totalPrice = totalPrice.add(s.getBoardprice());
		}
		return totalPrice;
	}
	
	public Integer getNumberOfItems(){
		return cartItemsMap.size();
	}
	
	public Map<Integer,CartItem> getCart()
	{
		return this.cartItemsMap;
	}
}
