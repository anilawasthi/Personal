package com.jp.shopping.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.jp.shopping.entities.Item;
import com.jp.shopping.entities.Order;
import com.jp.shopping.excptions.ShoppingExceptions;
import com.jp.shopping.interfaces.DaoShopping;
import com.jp.shopping.utilities.ConnectionFactoryTomcat;

public class DaoShoppingImpl implements DaoShopping {
	private DataSource dataSource;

	public DaoShoppingImpl() throws ShoppingExceptions {

		try {
			ConnectionFactoryTomcat factory = ConnectionFactoryTomcat.getConnectionFactory();
			dataSource = factory.getDataSource();
		} catch (Exception e) {
			throw new ShoppingExceptions("Problem in producing connection.", e);
		}
	}

	@Override
	public ArrayList<Item> getItemList() throws ShoppingExceptions {
		ArrayList<Item> itemList = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			stmt = connect.createStatement();
			rs = stmt.executeQuery("Select ITEMID,NAME,CATEGORY,PRICE from ITEMMASTER");
			while (rs.next()) {
				int itemId = rs.getInt("ITEMID");
				String itemName = rs.getString("NAME");
				String itemCategory = rs.getString("CATEGORY");
				Number itemPrice = rs.getInt("PRICE");
				itemList.add(new Item(itemId, itemName, itemCategory, itemPrice));
			}
		} catch (SQLException e) {
			throw new ShoppingExceptions("Problem in fetching.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				throw new ShoppingExceptions("Problem in closing resources.", e);
			}
		}
		return itemList;
	}

	@Override
	public Item getItemDetails(int itemId) throws ShoppingExceptions {
		String qry = "Select ITEMID,NAME,CATEGORY,PRICE from ITEMMASTER where ITEMID = ?";
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			stmt = connect.prepareStatement(qry);
			stmt.setInt(1, itemId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String itemName = rs.getString("NAME");
				String itemCategory = rs.getString("CATEGORY");
				Number itemPrice = rs.getInt("PRICE");
				return new Item(itemId, itemName, itemCategory, itemPrice);
			} else {
				// Id is wrong.
				return null;
			}
		} catch (SQLException e) {
			throw new ShoppingExceptions("Problem in fetching.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new ShoppingExceptions("Problem in closing resources.", e);
			}
		}

	}

	@Override
	public boolean addToCart(Order shop) throws ShoppingExceptions {
		String qry = "INSERT INTO ORDERMASTER (CUSTID,ORDERID,ITEMNO) VALUES (seqitemOId.nextval, ?, ?)";
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			stmt = connect.prepareStatement(qry);
			stmt.setInt(1, shop.getOrderId());
			stmt.setInt(1, shop.getCustomerId());
			stmt.setInt(2, shop.getItemOId());

			int recInserted = stmt.executeUpdate();
			return recInserted == 1 ? true : false;

		} catch (SQLException e) {
			throw new ShoppingExceptions("Problem in fetching.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new ShoppingExceptions("Problem in closing resources.", e);
			}
		}
	}
}