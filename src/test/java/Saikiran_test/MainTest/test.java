package Saikiran_test.MainTest;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      WebDriver driver= new ChromeDriver();
      driver.get("https://rahulshettyacademy.com/client/#/auth/login");
      Predicate<WebElement> displayCheck= e -> e.isDisplayed();
      WebElement t= driver.findElement(By.cssSelector("a[routerlink='/auth/register']"));
      if(displayCheck.test(t)) {
    	  System.out.println("it is displayed");
      }else
      {
    	  System.out.println("not yet displayed");
      }
      
      WebElement v=driver.findElement(By.className("forgot-password-link"));
    		  if(displayCheck.test(v)) {
    	    	  System.out.println("it is displayed");
    	      }else
    	      {
    	    	  System.out.println("not yet displayed");
    	      }
 
		Function<WebElement,String>getText= e->e.getText();
		String text=getText.apply(v);
		System.out.println(text);
		System.out.println(v.getText()+" "+"called directly");
		Function<WebElement,Integer>getText1= e1->Integer.parseInt(e1.getText().replace("$","").replace(",",""));
		
		WebElement button= driver.findElement(By.id("login"));
		Consumer<WebElement>obj= e->e.click();
		obj.accept(button);

		
		
	}

}
