package facts;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class SearchTest implements StringConstants
{
	WebDriver driver;
	
	@Before
	public void openFactsPage() //throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", chromeExecutable);
		driver = new ChromeDriver();
		driver.get(thisServlet);
		Assert.assertEquals("Software Engineering", driver.getTitle());
	}
	
	//this method automates the base case (D1,E1)
	//searches "automation" with the "text" option selected
	@Test
	public void searchBase() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.id("searchText"));
		WebElement type = driver.findElement(By.id("text"));
		type.click();
		Thread.sleep(1000);
		searchBox.sendKeys("automation");
		Thread.sleep(1000);
		searchBox.submit();
		Thread.sleep(1000);
	}
	
	//automates test (D1,E2)
	//searches "automation" with the "author" option selected
	@Test
	public void searchD1E2() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.id("searchText"));
		WebElement type = driver.findElement(By.id("author"));
		type.click();
		Thread.sleep(1000);
		searchBox.sendKeys("automation");
		Thread.sleep(1000);
		searchBox.submit();
		Thread.sleep(1000);
	}
	
	//automates test (D1,E3)
	//searches "automation" with the "type" option selected
	@Test
	public void searchD1E3() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.id("searchText"));
		WebElement type = driver.findElement(By.id("type"));
		type.click();
		Thread.sleep(1000);
		searchBox.sendKeys("automation");
		Thread.sleep(1000);
		searchBox.submit();
		Thread.sleep(1000);
	}
	
	//automates test (D1,E4)
	//searches "automation" with the "all" option selected
	@Test
	public void searchD1E4() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.id("searchText"));
		WebElement type = driver.findElement(By.id("all"));
		type.click();
		Thread.sleep(1000);
		searchBox.sendKeys("automation");
		Thread.sleep(1000);
		searchBox.submit();
		Thread.sleep(1000);
	}
	
	//automates the test (D2,E1)
	//searches "Glass" with the "text" option selected
	@Test
	public void searchD2E1() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.id("searchText"));
		WebElement type = driver.findElement(By.id("text"));
		type.click();
		Thread.sleep(1000);
		searchBox.sendKeys("Glass");
		Thread.sleep(1000);
		searchBox.submit();
		Thread.sleep(1000);
	}
	
	//automates the test (D3,E1)
	//searches "Fact" with the "text" option selected
	@Test
	public void searchD3E1() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.id("searchText"));
		WebElement type = driver.findElement(By.id("text"));
		type.click();
		Thread.sleep(1000);
		searchBox.sendKeys("Fact");
		Thread.sleep(1000);
		searchBox.submit();
		Thread.sleep(1000);
	}
	
	//automates the test (D4,E1)
	//searches "Fallacy" with the "text" option selected
	@Test
	public void searchD4E1() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.id("searchText"));
		WebElement type = driver.findElement(By.id("text"));
		type.click();
		Thread.sleep(1000);
		searchBox.sendKeys("Fallacy");
		Thread.sleep(1000);
		searchBox.submit();
		Thread.sleep(1000);
	}
	
	//automates the test (D5,E1)
	//searches "" with the "text" option selected
	//received error when I tried to send a null character
	@Test
	public void searchD5E1() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.id("searchText"));
		WebElement type = driver.findElement(By.id("text"));
		type.click();
		Thread.sleep(1000);
		searchBox.sendKeys("");
		Thread.sleep(1000);
		searchBox.submit();
		Thread.sleep(1000);
	}
	
	@After
	public void closePage()
	{
		driver.quit();
	}
}
