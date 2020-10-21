package com.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhpAppTest {
	WebDriver driver;

	@BeforeMethod
	public void startChrome() {
		System.setProperty("webdriver.chrome.driver", 
			"/home/ubuntu/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://3.137.175.129:8081/");
	}
	
	@Test
	public void MyFirstTestNGTestCase() throws InterruptedException {
		String title = driver.getTitle();
		System.out.println("Current page title is : " + title);

		WebElement linkByText = driver.findElement(By.linkText("About Us")); 
		linkByText.click();
		
		String aboutUsText = "This is about page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

		WebElement paragragh = driver.findElement(By.id("PID-ab2-pg"));

		if(paragragh.getText().equals(aboutUsText)) {
			System.out.println("\n'Text Verified Successfully!!!");
		}

		Thread.sleep(1000);

		System.out.println("\n'SUCCESSFUL EXECUTION!!!");
	}

	

	@AfterMethod
	public void cleaupProc() {
		System.out.print("\nBrowser close");
		driver.close();
	}
}
