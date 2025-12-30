package RAHUL_EXAMPLE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Abtract.Abstactcomponent;

public class cartP extends Abstactcomponent {
	WebDriver driver;

	public cartP(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".infoWrap h3")
	List<WebElement>prodSelected;
	@FindBy(css=".totalRow [type='button']")
	WebElement cartClick;

	public Boolean listOfCartElement(String prodName) {
		Boolean match = prodSelected.stream().anyMatch(product -> product.getText().equalsIgnoreCase(prodName));
	    return match;
}
  public checkOutpage cartButton(){
	  cartClick.click();
	  checkOutpage checkoutobj = new checkOutpage(driver);
	  return checkoutobj;
	  }
}



	