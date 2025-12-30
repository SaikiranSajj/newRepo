package Saikiran_test.MainTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RAHUL_EXAMPLE.Conformation_page;
import RAHUL_EXAMPLE.OrderP;
import RAHUL_EXAMPLE.Product_Page;
import RAHUL_EXAMPLE.cartP;
import RAHUL_EXAMPLE.checkOutpage;
import RAHUL_EXAMPLE.landingPag;
import Saikiran_test.testcomponent.Base_Test;

public class SubmitOrderTest extends Base_Test {
	String prodName="ZARA COAT 3";
	@Test(dataProvider="getData",groups={"Purchase"})
	public void submitOrder(HashMap<String,String>input) throws IOException {
		
		 
		Product_Page product_page=landingPage.logindetails(input.get("username"),input.get("passward"));

		List<WebElement> products = product_page.getProductList();
		
		WebElement AddedProduct = product_page.selectProduct(products,input.get("productName"));
		product_page.selectedItemClick(AddedProduct);//productName
		product_page.addToCart();
		cartP cartObject1=product_page.goToCartPage();
		
		Boolean match=cartObject1.listOfCartElement(input.get("productName"));
		Assert.assertTrue(match);
		checkOutpage checkoutobj=cartObject1.cartButton();
		checkoutobj.selectCountry("India");
		Conformation_page conformation_page=checkoutobj.submitButton();
		String messagegrapped=conformation_page.conformCheck();
		Assert.assertTrue(messagegrapped.equalsIgnoreCase("Thankyou for the order."),"notmatched");
		}
	
	
	@Test(dependsOnMethods={"submitOrder"})
	public void orderpage()
	{
		
		Product_Page product_page=landingPage.logindetails("saikiransajja29@gmail.com","Saikiran@1");
		OrderP Orderpage=product_page.goToOrderPage();
		
		Assert.assertTrue(Orderpage.VerifyOrderDisplay(prodName));
		
		
		
		
	}
	
	
	// recommended --new File(System.getProperty("user.dir") + "/reports/").mkdirs(); for auto making the folder
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data=getJsonData("C:\\Users\\saiki\\OneDrive\\Desktop\\New folder\\maven project\\Ecom\\src\\test\\java\\purchaseOrder_data\\PurchaseOrder.json");
		
		/*
		 * HashMap<String,String>map= new HashMap<String,String>();
		 * map.put("username","saikiransajja29@gmail.com");
		 * map.put("passward","Saikiran@1"); map.put("productName","ZARA COAT 3");
		 * HashMap<String,String>map1= new HashMap<String,String>();
		 * map1.put("username","saikiransajja29@gmail.com");
		 * map1.put("passward","Saikiran@1"); map1.put("productName","ADIDAS ORIGINAL");
		 */
		 return new Object[][] {{data.get(0)},{data.get(1)}};
		}
	
	
	
	
}
