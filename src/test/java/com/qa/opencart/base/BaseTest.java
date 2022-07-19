package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.CommonsPage;
import com.qa.opencart.pages.ForgotPasswordPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultsPage;
import com.qa.opencart.tests.RegisterTest;

/**
 * https://naveenautomationlabs.com/opencart/index.php?route=account/login
	https://www.softaculous.com/demos/OpenCart
	https://demo1.opencart3.com/
	https://demo.opencart.com/index.php?route=account/login
	http://opencart.antropy.co.uk/index.php?route=account/login
 * @author Mahima
 *
 */
public class BaseTest {
	DriverFactory df;
	public WebDriver driver;
	protected Properties prop;
	
	
	protected LoginPage loginPage;
	protected AccountsPage accountsPage;
	protected ForgotPasswordPage forgotPwdPage;
	protected CommonsPage commPage;
	protected SearchResultsPage searchResultsPage ;
	protected ProductInfoPage productInfoPage;
	protected RegisterPage regPage;
	
	protected SoftAssert softAssert;
	
	@BeforeTest
	public void setUp() {
		df=new DriverFactory();
		prop=df.init_prop();
		driver= df.init_driver(prop);
		loginPage=new LoginPage(driver);
		softAssert=new SoftAssert();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
