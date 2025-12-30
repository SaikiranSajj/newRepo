package Saikiran_test.MainTest;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import RAHUL_EXAMPLE.Product_Page;
import RAHUL_EXAMPLE.cartP;
import Saikiran_test.testcomponent.Base_Test;

public class errorvalidationTest  extends Base_Test{

	@Test(groups={"errorvalidation"})
	public void login_validation()
	{
		landingPage.logindetails("sssaikiransajja29@gmail.com","Saikiran@1");
		String message=landingPage.incorrect_Login_Validation();
		Assert.assertEquals("Incorrect email or password.",message);
		
	}
	@Test
	public void product_validation()  {
		String prodName="ZARA COAT 3";
		 
		
		Product_Page product_page=landingPage.logindetails("saikiransajja29@gmail.com","Saikiran@1");

		List<WebElement> products = product_page.getProductList();
		
		WebElement AddedProduct = product_page.selectProduct(products, prodName);
		product_page.selectedItemClick(AddedProduct);
		product_page.addToCart();
		cartP cartObject1=product_page.goToCartPage();
		
		Boolean match=cartObject1.listOfCartElement("ZARA COAT 33");
		Assert.assertFalse(match);
	
	}	
}











//<div role="alert" class="ng-tns-c4-45 toast-message ng-star-inserted" aria-label="Incorrect email or password." style> Incorrect email or password. </div>