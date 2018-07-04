package myTests;


import facts.StringConstants;


//import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//HW6 Refactor overview
//implement(abstraction extension) of StringConstants class to keep all path variables in one file
//for simple edits
public class FactSearchModeTest implements StringConstants{


	// search bar constant
	@Test
	public void Test1(){
		// set the driver
		System.setProperty("webdriver.chrome.driver", chromeExecutable);
		WebDriver driver=new ChromeDriver();	
		// pass the url name to the driver
		driver.get(thisServlet);
		driver.findElement(By.xpath(".//*[@id='searchText']")).sendKeys("automation");;
		
		WebElement radioBtn = driver.findElement(By.id("author"));
		 
		radioBtn.click();

	}
	
	// search bar constant
//	@org.junit.Test
//	public void Test2(){
//		// set the driver
//		System.setProperty("webdriver.chrome.driver", chromeExecutable);
//		WebDriver driver=new ChromeDriver();	
//		// pass the url name to the driver
//		driver.get(thisServlet);
//		driver.findElement(By.xpath(".//*[@id='searchText']")).sendKeys("automation2");;
//			
//	}	
//	
	// radio button constant
	
	
	
}
