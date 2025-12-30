package RAHUL_EXAMPLE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Abtract.Abstactcomponent;

public class checkOutpage extends Abstactcomponent {
	WebDriver driver;

	public checkOutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[placeholder='Select Country']")
	WebElement new1;
	@FindBy(css=".ta-results [type='button']:nth-of-type(2)")
	WebElement  selectCountry;
	@FindBy(css=".action__submit")
	WebElement submit;
	
	public void selectCountry(String country) {
		Actions a = new Actions(driver);
		a.sendKeys(new1, "India").build().perform();

		selectCountry.click();
	//	submit.click();
	}
	public Conformation_page submitButton()
	{
		submit.click();
		Conformation_page conformation_page= new Conformation_page(driver);
		return conformation_page;
	}
		
}
	

	

