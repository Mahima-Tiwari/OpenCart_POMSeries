package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic -100: Design login page for open cart application")
@Story("US -101:  Design login page features")
public class LoginPageTest extends BaseTest{
	
	@Description("Verify login page title")
	@Severity(SeverityLevel.NORMAL)
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actualTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Verify login page title")
	@Severity(SeverityLevel.MINOR)	
	@Test(priority=2)
	public void loginPageUrlTest() {
		String actualUrl=loginPage.getLoginPageURL();
		Assert.assertTrue(actualUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Description("Verify forgot password link exists on the login page")
	@Severity(SeverityLevel.CRITICAL)	
	@Test(priority=3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkexist());
	}
	
	@Description("Verify forgot register link exists on the login page")
	@Severity(SeverityLevel.CRITICAL)	
	@Test(priority=4)
	public void RegisterLinkExistTest() {
		Assert.assertTrue(loginPage.isRegisterLinkexist());
	}

	@Description("Verify user is able to login with correct credentials")
	@Severity(SeverityLevel.BLOCKER)	
	@Test(priority=5)
	public void loginTest() {
		AccountsPage accPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		String accPagetitle=accPage.getAccPageTitle();
		Assert.assertEquals(accPagetitle, Constants.ACCOUNTS_PAGE_TITLE);
		Assert.assertTrue(accPage.isLogOutLintExixts());
		
	}
}
