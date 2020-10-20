package com.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest2 {
	WebDriver driver;

	@BeforeMethod
	public void startChrome() {
		System.setProperty("webdriver.chrome.driver", 
			"/home/ubuntu/chromedriver");
		//ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}

	@Test
	public void MyFirstTestNGTestCase() throws InterruptedException {
		String title = driver.getTitle();
		System.out.print("Current page title is : " + title);

		/*WebElement user = driver.findElement(By.name("userName"));
		user.sendKeys("test");
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys("test");
		WebElement signin = driver.findElement(By.name("login"));
		signin.click();*/

		Thread.sleep(1000);

		System.out.print("\n'SUCCESSFUL EXECUTION!!!");
	}



	@AfterMethod
	public void cleaupProc() {
		System.out.print("\nBrowser close");
		driver.close();
	}
  /*@BeforeMethod
  public void launch() {
	  
	    System.setProperty("webdriver.chrome.driver", "/home/ubuntu/chromedriver");
	    ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("useAutomationExtension", false);
	    driver = new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.get("https://facebook.com");

	  }
  
  @Test
  public void verifytitle() {
	  
        String a = driver.getTitle();
        System.out.println(a);
        //Assert.assertEquals(a, "Facebook");
	//System.out.println("Test Successful.");    
  }
  
  @AfterMethod
  public void close() {
	  
	  driver.close();
  }*/

}
