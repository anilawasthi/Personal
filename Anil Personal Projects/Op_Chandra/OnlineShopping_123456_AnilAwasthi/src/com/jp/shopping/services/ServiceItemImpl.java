package com.jp.shopping.services;

import java.util.ArrayList;

import com.jp.shopping.Daos.DaoShoppingImpl;
import com.jp.shopping.entities.Item;
import com.jp.shopping.entities.Order;
import com.jp.shopping.excptions.ShoppingExceptions;
import com.jp.shopping.interfaces.DaoShopping;

public class ServiceItemImpl implements ServiceItem {
	
	private DaoShopping daoItm, daoOrd;
	
	public ServiceItemImpl() throws ShoppingExceptions {
		daoItm = new DaoShoppingImpl();
	}

	@Override
	public ArrayList<Item> getItemList() throws ShoppingExceptions {
		return daoItm.getItemList();
	}

	@Override
	public Item getItemDetails(int itemId) throws ShoppingExceptions {
		return daoItm.getItemDetails(itemId);
	}

	@Override
	public boolean addToCart(Order shop) throws ShoppingExceptions {
		return daoOrd.addToCart(shop);
	}

}
