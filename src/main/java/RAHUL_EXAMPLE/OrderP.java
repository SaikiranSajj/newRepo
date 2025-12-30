package RAHUL_EXAMPLE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Abtract.Abstactcomponent;

public class OrderP extends Abstactcomponent {
	WebDriver driver;

	public OrderP(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement>cartProducts;

	public Boolean VerifyOrderDisplay(String prodName) {
		Boolean match =cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(prodName));
	    return match;
}
  
}



	