package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	public void doSendKeys(By locator, String value) {
		
		getElement(locator).sendKeys(value);
	}
	
	public WebElement getElement(By locator) 
	{
	return driver.findElement(locator);
		
	}
	
	public String doGetElementText(By locator) {
		return driver.findElement(locator).getText();
	}
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public String doGetAttributeValue(By locator, String attributeName) {
		return getElement(locator).getAttribute(attributeName);
	}
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
		
	}
	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	
	public By getBy(String locatorType, String locatorValue) {
//		By locator=By.id(locatorValue);
//		return locator;
		By locator=null;
		
		switch (locatorType.toLowerCase()) {
		case "id":
			locator=By.id(locatorValue);
			break;

		case "name":
			locator=By.name(locatorValue);
			break;
		case "classname":
			locator=By.className(locatorValue);
			break;
		case "xpath":
			locator=By.xpath(locatorValue);
			break;
		case "cssselector":
			locator=By.cssSelector(locatorValue);
			break;
		case "linkText":
			locator=By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator=By.partialLinkText(locatorValue);
			break;
		case "tagname":
			locator=By.tagName(locatorValue);
			break;
		default:
			System.out.println("please pass correct locator"+locatorValue);
			break;
		}
		return locator;
	}
	
	public void clickOnElementFromSection(By locator, String value) {
		
		List<WebElement> footerList=driver.findElements(locator);
		System.out.println(footerList.size());
				
		for(WebElement e: footerList) {
			String text=e.getText();
			System.out.println("=============="+text+"================");
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public void getAllElementsText(By locator) {
		
		List<WebElement> elementList= driver.findElements(locator);
		
		for (WebElement e : elementList) {
			String text=e.getText();
			System.out.println(text);
		}
	}
	
	public  int getElementsListCount(By locator) {
		return driver.findElements(locator).size();
	}
	
	public  List<String> getElementsTextList(By locator) {
		List<String> eleTextList=new ArrayList<String>();
		
		List<WebElement> elementList= driver.findElements(locator);
		
		for (WebElement e : elementList) {
			String text=e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}
	
	//===================================Dropdown Util=======================================
	public void doSelectDropDownByIndex(By locator, int index) {
		Select select =new Select(getElement(locator));
		select.selectByIndex(index);
		
	}
	public  void doSelectDropDownByValue(By locator, String value) {
		Select select =new Select(getElement(locator));
		select.selectByVisibleText(value);
		
	}
	public  void doSelectDropDownByVisibleText(By locator, String text) {
		Select select =new Select(getElement(locator));
		select.selectByVisibleText(text);;
		
	}


public  int printSelectDropDownValuesCount(By locator) {
	return getElements(locator).size(); 
}

public  void selectValueFromSelectDropDown(By locator, String values) {
	
	Select select=new Select(getElement(locator));
	List <WebElement> dropDownOptions=select.getOptions();
	System.out.println(dropDownOptions.size());
	
	for (WebElement e: dropDownOptions) {
		String text=e.getText();
		if(text.contains(values)) {
			e.click();
			break;
		}
	}
	
}

public  List<String> getSelectDropDownValuesList(By locator) {
	List <String> valuesList= new ArrayList<String>();
	Select select=new Select(getElement(locator));
	List <WebElement> dropDownOptions=select.getOptions();
	System.out.println(dropDownOptions.size());
	
	for (WebElement e: dropDownOptions) {
		String text=e.getText();
		valuesList.add(text);
		}
	return valuesList;
	
	
}

public void printSelectDropDownValues(By locator) {
	Select select=new Select(getElement(locator));
	List <WebElement> dropDownOptions=select.getOptions();
	System.out.println(dropDownOptions.size());
	
	for (WebElement e: dropDownOptions) {
		String text=e.getText();
		System.out.println(text);
				}
	
}
public void  selectValueFromDropDown(By locator, String Value) {
	
List<WebElement> ListOptions= driver.findElements(locator);
	System.out.println(ListOptions.size());
	
	for(int i=0; i<ListOptions.size();i++) {
		String text=ListOptions.get(i).getText();
		System.out.println(text);
		
		if(text.contains(Value)) {
			ListOptions.get(i).click();
			break;
		}
	
}


}

//Window Handle**********************************************************
public void doHandleWindow(By locator) {
	driver.findElement(locator).click();
	Set<String> handles=driver.getWindowHandles();
	Iterator<String> it=handles.iterator();
	String parentWindowId=it.next();
	String childWindowId=it.next();
	driver.switchTo().window(childWindowId);
	System.out.println("window title is: "+driver.getTitle());
	driver.close();
	driver.switchTo().window(parentWindowId);
	System.out.println("parent window title is: "+driver.getTitle());
	
}


//***=================================Wait Utils===============================================================
public WebElement waitforElementPresent(By locator, int timeOut) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}

public WebElement waitforElementVisible(By locator, int timeOut) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
public List<WebElement> waitforElementsVisible(By locator, int timeOut) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
}


public String waitForTitleContains(String titleFraction, int timeOut) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	if(wait.until(ExpectedConditions.titleContains(titleFraction))) {
		return driver.getTitle();
	}
	return null;
}

public String waitForTitleIs(String titleValue, int timeOut) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	if(wait.until(ExpectedConditions.titleIs(titleValue))) {
		return driver.getTitle();
	}
	return null;
}

public String waitForUrlContains(String urlFraction, int timeOut) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
		return driver.getCurrentUrl();
	}
	return null;
}

public String waitForUrlIs(String urlValue, int timeOut) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	if(wait.until(ExpectedConditions.urlToBe(urlValue))) {
		return driver.getCurrentUrl();
	}
	return null;
}

}
