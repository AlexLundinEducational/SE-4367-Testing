package myTests;


import facts.StringConstants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//HW6 Refactor overview
//implement(abstraction extension) of StringConstants class to keep all path variables in one file
//for simple edits
public class FactSearchModeTest implements StringConstants{
	//
	@org.junit.Test
	public void myFirstTesticle(){
		// set the driver
		System.setProperty("webdriver.chrome.driver", chromeExecutable);
		WebDriver driver=new ChromeDriver();

		// pass the url name to the driver
		driver.get(thisServlet);
		driver.findElement(By.xpath(".//*[@id='searchText']")).sendKeys("Bam, selenium activated");;
		
	}
}
