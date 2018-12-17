package com.jp.products.daos;

import java.util.ArrayList;

import com.jp.products.entities.Products;
import com.jp.products.exceptions.ProductsException;

public interface DaoProducts {
	public ArrayList<Products> getproductList() throws ProductsException;

	public Products getProductDetails(int prodId) throws ProductsException;

	public boolean insertNewRecord (Products prod) throws ProductsException;
}
