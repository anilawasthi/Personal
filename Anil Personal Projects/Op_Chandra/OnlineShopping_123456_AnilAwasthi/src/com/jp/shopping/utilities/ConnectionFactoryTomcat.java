package com.jp.shopping.utilities;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.jp.shopping.excptions.ShoppingExceptions;

public class ConnectionFactoryTomcat {
	public static ConnectionFactoryTomcat factory;
	private DataSource ds = null;

	private ConnectionFactoryTomcat() throws ShoppingExceptions {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException e) {
			throw new ShoppingExceptions("Problem in connecting to JNDI.", e);
		}
	}

	public static ConnectionFactoryTomcat getConnectionFactory() throws ShoppingExceptions {
		if (factory == null) {
			factory = new ConnectionFactoryTomcat();
		}
		return factory;
	}

	public DataSource getDataSource() {
		return ds;
	}

}

