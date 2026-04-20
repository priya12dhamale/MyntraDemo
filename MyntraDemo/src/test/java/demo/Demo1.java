package demo;

import org.testng.annotations.Test;

public class Demo1 {

	    @Test
	    public void test1() {

	        System.out.println("Framework setup successful");
	    }
	    /*
		 * here we are using dynamic xpath to find the category option and then click on
		 * that option to select the category
		 */
//		public void selectCategory(String categoryName) {
//		    WebElement categoryOption = Keyword.driver.findElement(By.xpath("//div[contains(@class,'categories-container')]//label[contains(.,'" + categoryName + "')]"));
//		    categoryOption.click();
//		}
//		public void clickOnCategory() {
	//
//			Keyword.clickOnElement(categoryOption);
//		}
	    
	//	
//		//
//			 * Find label inside categories-container whose text contains categoryName
//			 */
//			// String xpath =
//			// "//div[contains(@class,'categories-container')]//label[contains(.,'" +
//			// categoryName + "')]";
//			WaitFor.elementToBeVisible(By.xpath("//span[text()='Categories']"));//
//			//By xpath = By.xpath("//span[text()='Categories']/following::li//label[contains(.,'" + categoryName + "')]");
//			
//			List<WebElement> categoryLocator = driver.findElements(By.xpath("//ul[@class=\"categories-list\"]/li/label/input[@value='"+category+"']"));
//			//By categoryLocator = By.xpath("//ul[@class=\"categories-list\"]/li/label/input[@value='"+category+"']");
//			
//			
//			// WebElement categoryOption = driver.findElement(By.xpath(xpath));
	//
//			WaitFor.elementToBeVisible(categoryLocator);
//			//WebElement categoryOption = driver.findElement(categoryLocator);
//			WaitFor.elementToBeClickable(categoryLocator);
//			// WebElement categoryOption = WaitFor.elementToBeVisible(element);
//			// WaitFor.elementToBeClickable(categoryOption);
//			// categoryOption.click();
//			// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
//			// categoryOption);
//			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", categoryLocator);
//			//Keyword.WaitForSeconds(4000);
	//
	//	

//		public void selectCategory(String categoryName) {
//			  WebElement categoryOptin =driver.findElement By.xpath("//div[contains(@class,'categories-container')]//label[contains(.,'"
//		  + categoryName + "')]") ); WaitFor.elementToBeClickable(categoryOption);
//		  categoryOption.click(); 
//		  
//		  }
	//}

	//
//		// public void searchbrand(String BrandName) {*/

}
