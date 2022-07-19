package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
	
	private WebDriver driver;
	
	private By header=By.cssSelector("div#content h1");
	private By emailHeader=By.cssSelector("form.form-horizontal legend");
	private By email=By.cssSelector("input#input-email");
	private By continueBtn=By.xpath("//input[@value='Continue']");
	private By successMsg=By.cssSelector("div.alert-success");
	
	
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getforgotPwdPageTitle() {
		return driver.getTitle();
	}
	
	public String getforgotPwdPageHeader() {
		return driver.findElement(header).getText();
	}
	
	public String getemailSecHeader() {
		return driver.findElement(emailHeader).getText();
	}
	
	public void doClickonContinueBtn(String userName) {
		driver.findElement(email).sendKeys(userName);
		driver.findElement(continueBtn).click();
	}
	
	public String getpwdSuccessMsg() {
		return driver.findElement(successMsg).getText();
	}

}
