package coupons.utils;

import coupons.dao.CompaniesDao;
import coupons.dao.CompaniesDbDao;
import coupons.dao.CouponsDao;
import coupons.dao.CouponsDbDao;
import coupons.dao.CustomersDao;
import coupons.dao.CustomersDbDao;
import coupons.enums.ClientType;
import coupons.exceptions.CouponSystemException;
import coupons.facades.AdministratorFacade;
import coupons.facades.ClientFacade;
import coupons.facades.CompanyFacade;
import coupons.facades.CustomerFacade;

public class LoginManager {

	private CompaniesDao companiesDao = new CompaniesDbDao();
	private CustomersDao customersDao = new CustomersDbDao();
	private CouponsDao couponsDao = new CouponsDbDao();

	private static LoginManager Instance = null;

	private LoginManager() {
	}

	public static LoginManager getInstance() {
		if (Instance == null) {
			Instance = new LoginManager();
		}

		return Instance;
	}

	public ClientFacade login(String email, String passwaord, ClientType clientType) throws CouponSystemException {
		if (clientType != null) {
			ClientFacade clientFacade = null;
			switch (clientType) {
			case ADMINISTRATOR:
				AdministratorFacade af = new AdministratorFacade(companiesDao, customersDao, couponsDao);
				if (af.login(email, passwaord)) {
					clientFacade = af;
				}
				break;
			case COMPANY:
				CompanyFacade cf = new CompanyFacade(companiesDao, customersDao, couponsDao);
				if (cf.login(email, passwaord)) {
					clientFacade = cf;
				}
				break;
			case CUSTOMER:
				CustomerFacade ccf = new CustomerFacade(companiesDao, customersDao, couponsDao);
				if (ccf.login(email, passwaord)) {
					clientFacade = ccf;
				}
				break;
			}
			return clientFacade;

		} else {
			throw new CouponSystemException("login failed - client type nort specified");
		}
	}
}
