package RAHUL_EXAMPLE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abtract.Abstactcomponent;

public class Product_Page extends Abstactcomponent {
	WebDriver driver;

	public Product_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productadded = By.cssSelector(".card-body button:last-of-type");
	By listOfElements = By.className("mb-3");
	By prodToBeSelected = By.cssSelector("b");
	By suretyCheck = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(listOfElements);
		return products;
	}

	public WebElement selectProduct(List<WebElement> products, String prodName) {
		
		return products.stream().filter(product -> {
	        try {
	            String name = product.findElement(prodToBeSelected).getText().trim();
	            return name.equalsIgnoreCase(prodName);
	        } catch (Exception e) {
	            return false;   // do NOT break stream
	        }
	    }).findFirst()
	      .orElseThrow(() -> new RuntimeException("Product not found: " + prodName));
	}

	public void selectedItemClick(WebElement prodSelected) {
		prodSelected.findElement(productadded).click();
	}

	public void addToCart() {
		visibilityOfElementToAppear(suretyCheck);
		invisibilityOf(spinner);
		 
		 
	
	}

}
