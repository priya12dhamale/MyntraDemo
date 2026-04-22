package com.myntra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myntra.base.Keyword;
import com.myntra.utils.WaitFor;
import static com.myntra.base.Keyword.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.StaleElementReferenceException;

public class ProductListingPage {

	@FindBy(xpath = "//div[@class=\"breadcrumbs-base\"]")
	WebElement breadCrumb;

	@FindBy(xpath = "//span[@class='breadcrumbs-crumb']")
	List<WebElement> breadcrumbs;

	@FindBy(xpath = "//span[text()=\"Categories\"]")
	WebElement categoryHeading;

	@FindBy(xpath = "//span[text()=\"Brand\"]")
	WebElement brandHeading;

	@FindBy(xpath = "//span[text()='CLEAR ALL']")
	WebElement clearAllButton;

	@FindBy(xpath = "//ul[@class=\"categories-list\"]/li")
	WebElement categoryOption;

	@FindBy(xpath = "//ul[@class=\"brand-list\"]/li[1]")

	WebElement brandOptions;

//	@FindBy(xpath = "//li[contains(@class,'brand-listItem')]")
//	List<WebElement> brandOptions;

	@FindBy(xpath = "//li[@class=\"colour-listItem\"]")
	WebElement colorOptions;

//	@FindBy(xpath = "//li[@class='colour-listItem']")
//	List<WebElement> colorOptions;

	@FindBy(xpath = "//span[text()=\"Price\"]")
	WebElement priceHeading;

	@FindBy(xpath = "//span[text()=\"Color\"]")
	WebElement colorHeading;

	@FindBy(xpath = "//span[text()=\"Discount\"]")
	WebElement discountHeading;

	@FindBy(xpath = "//div[contains(text(),'Discount')]")
	WebElement discountSearch;
	@FindBy(xpath = "//ul[@class=\"discount-list\"]/li")
	List<WebElement> discountOptions;

//	@FindBy(xpath = "//li[@class=\"discount-listItem\"]")
//	WebElement discountOptions;

	@FindBy(xpath = "(//span[@class=\"myntraweb-sprite filter-search-iconSearch sprites-search\"])[1]")
	WebElement categorySearch;

//	@FindBy(xpath = "//div[text()='BRAND']/following::span[contains(@class,'search')][1]")
//	@FindBy(xpath="(//span[@class=\"myntraweb-sprite filter-search-iconSearch sprites-search\"])[2]")
	@FindBy(xpath = "//span[text()='Brand']/following::span[contains(@class,'search')][1]") //
	WebElement brandSearch;

	// @FindBy(xpath = "(//span[@class=\"myntraweb-sprite filter-search-iconSearch
	// sprites-search\"])[2]")
	@FindBy(xpath = "//span[text()='Color']/following::span[contains(@class,'search')][1]")
	WebElement colourSearch;

	@FindBy(xpath = "//div[text()=\"Sort by : \"]")
	WebElement sortByDropdown;

	@FindBy(xpath = "//label[text()='Price: Low to High']")
	WebElement lowToHighOption;

	@FindBy(xpath = "//label[text()='Price: High to Low']")
	WebElement highToLowOption;

	// Find all product price elements on the Product Listing Page
	@FindBy(xpath = "//span[@class='product-discountedPrice']")
	List<WebElement> productPrices;

	// Product items list

	@FindBy(xpath = "//li[contains(@class,'product-base')]")
	private List<WebElement> productList;

	@FindBy(xpath = "//div[@class='product-productMetaInfo']/h3")
	List<WebElement> productNames;

	@FindBy(xpath = "//span[@class='filter-value']")
	List<WebElement> appliedFilters;

	@FindBy(xpath = "//a[contains(@class,'pagination-next')]")
	WebElement nextPageButton;

	@FindBy(xpath = "//li[contains(@class,'product-base')]")
	List<WebElement> products;

//    @FindBy(xpath = "//h3[@class='product-brand']")
//    List<WebElement> productTitles;
//    @FindBy(xpath = "//h4[@class='product-product']")
//    List<WebElement> productNames;

	{
		PageFactory.initElements(Keyword.driver, this);
	}

	public boolean isColourFilterApplied(String colourName) {
		String xpath = "//span[contains(text(),'" + colourName + "')]";
		return Keyword.driver.findElement(By.xpath(xpath)).isDisplayed();
	}

	public boolean isCategorySectionVisible() {
		return categoryHeading.isDisplayed();
	}

	public boolean isBrandSectionVisible() {
		return brandHeading.isDisplayed();
	}

	public boolean isPriceSectionVisible() {
		return priceHeading.isDisplayed();
	}

	public boolean isColorSectionVisible() {
		return colorHeading.isDisplayed();
	}

	public boolean isDiscountSectionVisible() {
		return discountHeading.isDisplayed();
	}

	// Method to get product count
	public int getProductCount() {
		return productList.size();
	}
	// Method to check products displayed

	public boolean isProductDisplayed() {
		return productList.size() > 0;
	}

	public void clearAllFilters() {
		Keyword.clickOn(clearAllButton);
	}

	public boolean isCategoryFilt1erApplied(String category) {
		for (WebElement filter : appliedFilters) {
			if (filter.getText().equalsIgnoreCase(category)) {
				return true;
			}
		}
		return false;
	}

	public boolean isCategoryFilterApplied(String category) {
		try {
			String xpath = "//span[contains(@class,'filter') and contains(text(),'" + category + "')]";
			return driver.findElement(By.xpath(xpath)).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void selectCategory1(String category) {
		WaitFor.elementToBeVisible(categorySearch);
		Keyword.clickOnElement(categorySearch);
		By CategorySearch = By.xpath("//input[@placeholder=\"Search for Categories\"]");
		WaitFor.elementToBeVisible(CategorySearch);
		Keyword.enterText("xpath", "//input[@placeholder=\"Search for Categories\"]", category);
		WaitFor.elementToBeVisible(categoryOption);
		WaitFor.elementToBeClickable(categoryOption);
		// Keyword.WaitForSeconds(4000);
		categoryOption.click();
		Keyword.WaitForSeconds(2000);
		// Keyword.clickOnElement(categoryOption);
	}

//	public void selectBrand1(String BrandName) {
//
//		WaitFor.elementToBeVisible(brandSearch);
//		WaitFor.elementToBeClickable(brandSearch);
//		Keyword.clickOnElement(brandSearch);
//		// brandSearch.click();
//		By BrandSearch = By.xpath("//input[@placeholder=\"Search for Brand\"]");//
//		WaitFor.elementToBeVisible(BrandSearch);
//		Keyword.enterText("xpath", "//input[@placeholder=\"Search for Brand\"]", BrandName);//
//		WaitFor.elementToBeVisible(brandOptions);
//		WaitFor.elementToBeClickable(brandOptions);
//
//		brandOptions.click();
//		// WaitFor.elementToBeClickable(brandOptions);
//		Keyword.WaitForSeconds(2000);
//	}

	
	public void selectBrand1(String BrandName) {

	    WaitFor.elementToBeVisible(brandSearch);
	    WaitFor.elementToBeClickable(brandSearch);
	    Keyword.clickOnElement(brandSearch);

	    By BrandSearch = By.xpath("//input[@placeholder=\"Search for Brand\"]");

	    WaitFor.elementToBeVisible(BrandSearch);

	    Keyword.enterText(
	            "xpath",
	            "//input[@placeholder=\"Search for Brand\"]",
	            BrandName
	    );

	    // IMPORTANT: use findElements instead of wait
	    List<WebElement> brandList =
	            driver.findElements(By.xpath("//ul[@class='brand-list']/li"));

	    if (brandList.size() == 0) {

	      //  System.out.println("Brand not found: " + BrandName);
	        return;   
	    }
	    WaitFor.elementToBeClickable(brandOptions);
	    brandOptions.click();
	    Keyword.WaitForSeconds(2000);
	}
	
	public void selectColour1(String ColourName) {
		// Keyword.scrollToElement(colourSearch);
		WaitFor.elementToBeVisible(colourSearch);
		WaitFor.elementToBeClickable(colourSearch);
		Keyword.clickOnElement(colourSearch);
		By ColourSearch = By.xpath("//input[@placeholder=\"Search for Color\"]");
		WaitFor.elementToBeVisible(ColourSearch);
		Keyword.enterText("xpath", "//input[@placeholder=\"Search for Color\"]", ColourName);
		WaitFor.elementToBeVisible(colorOptions);
		WaitFor.elementToBeClickable(colorOptions);
		colorOptions.click();
		// driver.executeScript("arguments[0].click();", colorOptions);
		Keyword.WaitForSeconds(2000);
		// WaitFor.elementToBeClickable(colorOptions);
	}

	public void selectDiscount(String discountName) {
		for (WebElement option : discountOptions) {
			if (option.getText().equalsIgnoreCase(discountName)) {
				WaitFor.elementToBeClickable(option);
				option.click();

				break;
			}
		}
		Keyword.WaitForSeconds(2000);
	}

	public void selectPriceLowToHigh() {

		WaitFor.elementToBeClickable(sortByDropdown);
		sortByDropdown.click();
		WaitFor.elementToBeClickable(lowToHighOption);
		lowToHighOption.click();
		WaitFor.visibilityOfAllElements(productPrices);

	}

	public void selectPriceHighToLow() {

		WaitFor.elementToBeClickable(sortByDropdown);
		sortByDropdown.click();
		WaitFor.elementToBeClickable(highToLowOption);
		highToLowOption.click();

	}

	public List<Integer> getProductPrices() {

		List<Integer> priceList = new ArrayList<>();

		WaitFor.visibilityOfAllElements(productPrices);

		try {

			WaitFor.visibilityOfAllElements(productPrices);

			for (WebElement price : productPrices) {

				String priceText = price.getText();

				priceText = priceText.replaceAll("[^0-9]", "");

				int priceValue = Integer.parseInt(priceText);

				priceList.add(priceValue);
			}

		} catch (StaleElementReferenceException e) {

			System.out.println("Stale element detected, retrying...");

			// WaitFor.pageToLoad();
			WaitFor.visibilityOfAllElements(productPrices);

			for (WebElement price : productPrices) {

				String priceText = price.getText();

				priceText = priceText.replaceAll("[^0-9]", "");

				int priceValue = Integer.parseInt(priceText);

				priceList.add(priceValue);

			}
		}

		return priceList;
	}





	public String getBreadCrumbText() {
		WaitFor.elementToBeVisible(breadCrumb);
		String text = breadCrumb.getText();
		System.out.println("Breadcrumb text: " + text);
		return text;
	}

	public String getLastBreadcrumbText() {

		return breadcrumbs.get(breadcrumbs.size() - 1).getText();
	}

	public void clickNextPage() {

		WaitFor.elementToBeClickable(nextPageButton);

		nextPageButton.click();

		WaitFor.visibilityOfAllElements(productPrices);

	}

	public void scrollToLastProduct() {

		int lastIndex = products.size() - 1;

		WebElement lastProduct = products.get(lastIndex);

		scrollToElement(lastProduct);

	}

	public boolean isFilterChipDisplayed(String filterName) {

		try {

			List<WebElement> chips = driver.findElements(By.xpath("//div[contains(@class,'filter-summary-filter')]"));

			for (WebElement chip : chips) {

				String chipText = chip.getText().trim();

				System.out.println("Chip text: " + chipText);

				if (chipText.equalsIgnoreCase(filterName)) {

					return true;
				}
			}
			return false;
		} catch (Exception e) {
			
			return false;
		}
	}
}
