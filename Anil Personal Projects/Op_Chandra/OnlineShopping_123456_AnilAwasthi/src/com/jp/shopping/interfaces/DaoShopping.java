package com.jp.shopping.interfaces;

import java.util.ArrayList;

import com.jp.shopping.entities.Item;
import com.jp.shopping.entities.Order;
import com.jp.shopping.excptions.ShoppingExceptions;

public interface DaoShopping {

	public ArrayList<Item> getItemList() throws ShoppingExceptions;

	public Item getItemDetails(int itemId) throws ShoppingExceptions;

	public boolean addToCart(Order shop) throws ShoppingExceptions;

}
