package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.CommonsPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.utils.DescriptionConstants;

public class ProductInfoTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetUp() {
		accountsPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		commPage=new CommonsPage(driver);
		productInfoPage=new ProductInfoPage(driver);
	}
	
	@DataProvider
	public Object[][] getProductData(){
		return new Object[][] {
			{"Macbook", "MacBook Pro", 4},
			{"iMac", "iMac", 4},
			{"Samsung","Samsung SyncMaster 941BW", 1},
			{"Apple","Apple Cinema 30\"", 6},
			
		};
	}
	
	@Test(dataProvider="getProductData")
	public void productImagesCountTest(String productName, String mainProductName, int imgCount) {
		
		searchResultsPage=commPage.doSearch(productName);
		//String resultsPageHeader=searchResultsPage.getResultsPageHeader();
		productInfoPage=searchResultsPage.selectProductName(mainProductName);
		Assert.assertEquals(productInfoPage.getProductImagesCount(),imgCount);
	}
	
	@Test
	public void productDescriptionTest() {
		searchResultsPage=commPage.doSearch("Macbook");
		productInfoPage=searchResultsPage.selectProductName("MacBook Air");
		String productDesc=productInfoPage.getProductDescription();
		System.out.println(productDesc);
		
		softAssert.assertTrue(productDesc!=null);
		softAssert.assertFalse(productDesc.isEmpty());
		softAssert.assertTrue(productDesc.contains("MacBook Air"));
		softAssert.assertTrue(productDesc.contains(DescriptionConstants.MACBOOK_AIR_DESCRIPTION));
		
		softAssert.assertAll();
		
	}
	
	@Test
	public void productDataTest() {
		searchResultsPage=commPage.doSearch("Macbook");
		productInfoPage=searchResultsPage.selectProductName("MacBook Air");
		Map<String, String> actProductInfoPage=productInfoPage.getProdctInfo();
		
		actProductInfoPage.forEach((k,v)->System.out.println(k+": "+v));//Brand:Apple
		softAssert.assertEquals(actProductInfoPage.get("Brand"), "Apple");
		softAssert.assertEquals(actProductInfoPage.get("Availability"), "In Stock");
		softAssert.assertEquals(actProductInfoPage.get("Reward Points"), "700");
		softAssert.assertEquals(actProductInfoPage.get("name"), "MacBook Air");
		
		softAssert.assertAll();
	}

}
