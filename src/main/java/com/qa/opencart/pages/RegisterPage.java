package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By firstName=By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telephone=By.id("input-telephone");
	private By address1=By.id("input-address-1");
	private By city=By.id("input-city");
	private By postcode=By.id("input-postcode");
	private By country=By.id("input-country");
	private By regional=By.id("input-zone");
	private By password=By.id("input-password");
	private By confirmPassword=By.id("input-confirm");
	
	private By subscribeYes=By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo=By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
	
	private By agreeCheckBox=By.xpath("//div[@class='pull-right']//input[@type='checkbox' and @name='agree']");
	private By continueBtn=By.xpath("//div[@class='pull-right']//input[@type='submit' and @value='Continue']");
	
	private By logOutLink=By.linkText("Logout");
	private By registrationLink=By.linkText("Register");
	
	private By successMsg= By.cssSelector("div#content h1");

	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	public boolean userRegistration(String firstName, String lastName, String email, String telephone,
			String password, String subscribe) //  
	{
		
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmPassword, password);
		
		if(subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYes);
		}
		else {
			eleUtil.doClick(subscribeNo);
		}
		
		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(continueBtn);
		
		String successMesg=eleUtil.waitforElementVisible(successMsg, Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT).getText();
				System.out.println("Registration Successful: "+successMsg);
		
		if(successMesg.contains(Constants.REGISTER_SUCCESS_MESSG)) {
			eleUtil.doClick(logOutLink);
			eleUtil.doClick(registrationLink);
			return true;
		}
		else {
			return false;
		}
		
		
	}
}
