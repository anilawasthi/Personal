package com.jp.products.services;

import com.jp.products.daos.DaoAuthentication;
import com.jp.products.daos.DaoAuthenticationImpl;
import com.jp.products.exceptions.UserException;

public class ServiceUserImpl implements ServiceUser {

	private DaoAuthentication daoAuth;

	public ServiceUserImpl() throws UserException{
		daoAuth = new DaoAuthenticationImpl
	}

}