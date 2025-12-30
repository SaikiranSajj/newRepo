package Abtract;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RAHUL_EXAMPLE.OrderP;
import RAHUL_EXAMPLE.cartP;

public class Abstactcomponent {
  WebDriver driver;
 
	public Abstactcomponent(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	@FindBy(css = "[routerlink*='cart']")
	WebElement dashboardClick;
	
	@FindBy(css = "[routerlink*='/dashboard/myorders']")
	WebElement CartClick;
	
	
	
	
	
   public void waitForElementToAppear(By listOfElements) {
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listOfElements));
   }
   public void visibilityOfElementToAppear(By suretyCheck) {
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	   wait.until(ExpectedConditions.visibilityOfElementLocated(suretyCheck));
   }
   public void visibilityOfElementToAppear(WebElement errorText) {
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	   wait.until(ExpectedConditions.visibilityOf(errorText));
   }
   
   
    public cartP goToCartPage() {
    	dashboardClick.click();
    	cartP cartObject1= new cartP(driver);
    	return cartObject1;
    }
    public OrderP goToOrderPage() {
    	CartClick.click();
    	OrderP Orderpage= new OrderP(driver);
    	return Orderpage;
    }
    
   public void invisibilityOf(WebElement inVisible) {
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	   wait.until(ExpectedConditions.invisibilityOf(inVisible));
   }
   
}
