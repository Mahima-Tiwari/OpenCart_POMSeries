package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	public static final String LOGIN_PAGE_TITLE="Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION="route=account/login";
	
	public static final String ACCOUNTS_PAGE_TITLE="My Account";
	public static final String ACCOUNTS_PAGE_HEADER="naveenopencart";
	public static final List<String> ACCOUNTS_PAGE_SECTIONS_HEADER_LIST=Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	public static final String ACCOUNTS_PAGE_URL_FRACTION = "route=account/account";
	
	public static final String FORGOTPWD_PAGE_TITLE="Forgot Your Password?";
	public static final String FORGOTPWD_PAGE_HEADER="Forgot Your Password?";
	public static final String FORGOTPWD_PAGE_EMAIL_TITLE="Your E-Mail Address";
	
	public static final int DEFAULT_ELEMENT_WAIT_TIME_OUT=10;
	public static final int DEFAULT_TIME_OUT=5;
	
	public static final String USER_LOGOUT_MESSAGE="Account Logout";
	public static final String FORGOTPWD_PAGE_SUCCESS_MSG = "An email with a confirmation link has been sent your email address.";
	public static final String REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";

	

}
