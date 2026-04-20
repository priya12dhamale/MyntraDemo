package com.myntra.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myntra.base.Keyword;
import com.myntra.utils.WaitFor;

public class SearchResultPage {
	
	RemoteWebDriver driver = Keyword.driver;

	@FindBy(xpath = "(//li[contains(@class,'product-base')])[1]")
	WebElement firstProduct;
	
	@FindBy(xpath="//ul[@class=\"results-base\"]/li")
	List<WebElement>productCards;
	
	@FindBy(xpath = "//h3[@class='product-brand']")
	List<WebElement> productBrands;

	@FindBy(xpath = "//h4[@class='product-product']")
	List<WebElement> productTitles;
	
	@FindBy(xpath="//p[text()=\" We couldn't find any matches! \"]")
	WebElement noResultsMessage;
	
	
	/* for making dynamic click on any product by passing index as parameter
	 * public void clickOnProduct(int index) {
	 * 
	 * String xpath = "(//li[contains(@class,'product-base')])[" + index + "]";
	 * 
	 * WebElement product = driver.findElement(By.xpath(xpath));
	 * 
	 * product.click(); }
	 */

	{
		PageFactory.initElements(Keyword.driver, this);
	}

	public void clickOnFirstProduct1() {
		WaitFor.elementToBeVisible(firstProduct);//
		WaitFor.elementToBeClickable(firstProduct);//
		firstProduct.click();
	//	Keyword.WaitForSeconds(4000);
	}
	
	public void clickOnFirstProduct() {

	    WaitFor.elementToBeVisible(firstProduct);
	    WaitFor.elementToBeClickable(firstProduct);

	    try {
	        firstProduct.click();
	    } catch (StaleElementReferenceException e) {

	        WaitFor.elementToBeVisible(firstProduct);
	        firstProduct.click();
	    }
	}
	
	public void clickProductByIndex(int index) {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 //   WaitFor.elementToBeVisible(productCards);
//	    WaitFor.elementToBeClickable(firstProduct);

	    By productLocator = By.xpath(
	        "(//li[contains(@class,'product-base')])[" + index + "]"
	    );

	    WebElement product = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(productLocator)
    );

  //  JavascriptExecutor js = (JavascriptExecutor) driver;
	 driver.executeScript("arguments[0].scrollIntoView(true);", product);
	 

    wait.until(ExpectedConditions.elementToBeClickable(product)).click();
	}
	
	
          public void clickProduct(int index) {
        	  
        	  WaitFor.visibilityOfAllElements(productCards);
        	  
        	  Keyword.clickOn(productCards.get(index));
          }
          
//          public String getProductNameByIndex(int index) {
//        	    return productBrands.get(index).getText();
//        	}
////          
//          public String getProductFullNameByIndex(int index) {
//
//        	    String brand = productBrands.get(index -1).getText();
//        	    String title = productTitles.get(index -1).getText();
//
//        	    return brand + " " + title;
//        	}
          public String getProductBrandByIndex(int index) {
        	    return productBrands.get(index - 1).getText();
        	}
          
          public boolean noResultsMessageIsDisplayed() {
			  WaitFor.elementToBeVisible(noResultsMessage);
			  return noResultsMessage.isDisplayed();
		  }
}
