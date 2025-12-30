package RAHUL_EXAMPLE;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abtract.Abstactcomponent;

public class landingPag  extends Abstactcomponent {
     WebDriver driver;
	public  landingPag(WebDriver driver) {
		super(driver);
		this.driver= driver;
		
		PageFactory.initElements(driver,this);
		}
	
	


	@FindBy(id="userEmail")
	WebElement userMail;
	
	@FindBy(id="userPassword")
	WebElement  passward;
	
	@FindBy(id="login")
	WebElement logbutton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	
	public Product_Page logindetails(String mail,String pass) {	
		userMail.sendKeys(mail);
		passward.sendKeys(pass);
		logbutton.click();
		Product_Page product_page = new Product_Page(driver);
		return product_page; 
	}
	
  public void goTo()
  {
	  driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	  }
		
  public String  incorrect_Login_Validation() {
	  visibilityOfElementToAppear(errormessage);
	  String errorMessage=errormessage.getText();
	  return  errorMessage;
  }
	}
	
	
	

