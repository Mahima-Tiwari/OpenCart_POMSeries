package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//private By locators :OR
	private By emailId=By.id("input-email");
	private By password=By.id("input-password");
	private By loginBtn=By.xpath("//input[@value='Login']");
	private By forgotPwdLink=By.linkText("Forgotten Password");
	private By registrationLink=By.linkText("Register");
	private By accLogoutMessage=By.cssSelector("div#content h1");
	private By mahima=By.cssSelector("div#mahima h1");
	
	
	//2. public page class constru
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(this.driver);
	}
	
	@Step("getting login page title..")
	public String getLoginPageTitle() {
		String title=eleUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
		System.out.println(title);
		return title;
	}
	
	@Step("getting login page url..")
	public String getLoginPageURL() {
		String url=eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
		System.out.println(url);
		return url;
	}
	
	@Step("checking forgot password link exists or not..")
	public boolean isForgotPwdLinkexist() {
		return eleUtil.waitforElementVisible(forgotPwdLink, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT).isDisplayed();
	}
	
	@Step("checking register link exists or not..")
	public boolean isRegisterLinkexist() {
		return eleUtil.waitforElementVisible(registrationLink, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT).isDisplayed();
	}
	
	@Step("login with username {0} and password {1}")
	public AccountsPage doLogin(String userName, String pwd) {
		eleUtil.waitforElementVisible(emailId, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT)
									.sendKeys(userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
		
	}
	
	public ForgotPasswordPage navigatetoforgotPwdPage() {
		
		eleUtil.waitforElementVisible(forgotPwdLink, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT).click();
		return new ForgotPasswordPage(driver);
	}
	
	@Step("Getting success message after we logout")
	public String getLogoutMessage() {
		String logoutMsg=eleUtil.waitforElementVisible(accLogoutMessage,Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT).getText();
		System.out.println("Logout successful message===="+logoutMsg);
		return logoutMsg;
	}
	
	
	@Step("Navigating to registration page")
	public RegisterPage navigateToRegisterPage() {
		eleUtil.doClick(registrationLink);
		
		return new RegisterPage(driver);
	}
	
	
	
	
	
	
	

}
