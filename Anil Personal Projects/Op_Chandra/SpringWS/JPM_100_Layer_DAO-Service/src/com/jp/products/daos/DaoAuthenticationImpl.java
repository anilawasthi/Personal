package com.jp.products.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jp.products.entities.User;
import com.jp.products.exceptions.ProductsException;
import com.jp.products.exceptions.UserException;
import com.jp.products.utilities.ConnectionFactory;

public class DaoAuthenticationImpl implements DaoAuthentication {

	private ConnectionFactory factory;

	public DaoAuthenticationImpl() throws ProductsException {
		try {
			factory = new ConnectionFactory();
		} catch (Exception e) {
			throw new ProductsException("Problem in producing connection.", e);
		}
	}

	public ArrayList<User> getUserDetails() throws UserException{
		ArrayList<User> UserDetails = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connect = factory.getConnection();
			stmt = connect.createStatement();
			rs = stmt.executeQuery("Select count(*) from USER_MASTER where USER_NAME=? and PASSWORD=?");
			while (rs.next()){
				int uId = rs.getInt("USER_ID");
				String uNm = rs.getString("USER_NAME");
				String pswd = rs.getString("PASSWORD");
				String urol = rs.getString("USER_ROLE");
				UserDetails.add(new User(uId, uNm, pswd, urol));
			}
			
		} catch (SQLException e) {
			throw new UserException("Problems in fetching User details.", e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (stmt != null){
					stmt.close();
				}
			} catch (SQLException e) {
				throw new UserException("Problem in closing resources.", e);
			}
			}
		return UserDetails;
		}
	}

