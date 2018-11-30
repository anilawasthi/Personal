package com.jp.hr.utilities;

import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

/*
 * 1.	Self referential static private field.
 * 2.	Constructor Private
 * 3. 	Public static method to create restricted number of instances.
 */
public class ConnectionFactory {
	private static ConnectionFactory factory;
	private OracleDataSource dataSource;

	public ConnectionFactory() throws ClassNotFoundException, SQLException {
		dataSource = new OracleDataSource();
		dataSource.setDriverType("thin");
		dataSource.setPortNumber(1521);
		dataSource.setUser("hr");
		dataSource.setPassword("hr");
		dataSource.setServerName("localhost");
		dataSource.setServiceName("orcl");
	}

	public static ConnectionFactory getConnectionFactory() throws ClassNotFoundException, SQLException {
		if (factory == null) {
			factory = new ConnectionFactory();
		}
		return factory;
	}

	public OracleDataSource getDataSource()
	{
		return dataSource;
	}
}