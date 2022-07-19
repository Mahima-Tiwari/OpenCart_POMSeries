package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class ForgotPwdPageTest extends BaseTest {
	
	@BeforeClass
	public void forgotPwdPageSetUp() {
		forgotPwdPage=loginPage.navigatetoforgotPwdPage();
	}

	@Test
	public void forgotPwdPagetitleTest() {
		Assert.assertEquals(forgotPwdPage.getforgotPwdPageTitle(), Constants.FORGOTPWD_PAGE_TITLE);
	}
	@Test
	public void forgotPwdPageHeaderTest() {
		Assert.assertEquals(forgotPwdPage.getforgotPwdPageHeader(), Constants.FORGOTPWD_PAGE_HEADER);
	}
	@Test
	public void forgotPwdPageEmailHeaderTest() {
		Assert.assertEquals(forgotPwdPage.getemailSecHeader(), Constants.FORGOTPWD_PAGE_EMAIL_TITLE);
	}
	@Test
	public void forgotPwdTest() {
		forgotPwdPage.doClickonContinueBtn(prop.getProperty("username"));
		String pageTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(pageTitle, Constants.LOGIN_PAGE_TITLE);
		String acctSuccessMsg=forgotPwdPage.getpwdSuccessMsg();
		System.out.println("Actual success msg is: "+acctSuccessMsg);
		Assert.assertEquals(acctSuccessMsg, Constants.FORGOTPWD_PAGE_SUCCESS_MSG);
	}
}
