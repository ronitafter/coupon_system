package coupons.facades;

import coupons.dao.CompaniesDao;
import coupons.dao.CouponsDao;
import coupons.dao.CustomersDao;
import coupons.exceptions.CouponSystemException;

public abstract class ClientFacade {
	protected CompaniesDao companiesDao;
	protected CustomersDao customersDao;
	protected CouponsDao couponsDao;

	public ClientFacade(CompaniesDao companiesDao, CustomersDao customersDao, CouponsDao couponsDao) {
		this.companiesDao = companiesDao;
		this.customersDao = customersDao;
		this.couponsDao = couponsDao;
	}

	/*
	 * return true if the email and password exists in the database and the user can
	 * log in email - the user's email password - the user's password
	 * 
	 */

//	@Override
	public abstract boolean login(String email, String passwaord) throws CouponSystemException;
}
