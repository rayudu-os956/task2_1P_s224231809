package sit707_week2;

import java.io.File;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void github_registration_page(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\glvsr\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
		driver.get(url);
		WebElement emailaddress = driver.findElement(By.id("email"));
		System.out.println("Found element: " + emailaddress);
		// Send first name
		emailaddress .sendKeys("gudipallirayudu@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Found element: " + password);
		// Send last name
		password.sendKeys("monkeyluffy@123");

		WebElement username = driver.findElement(By.id("login"));
		System.out.println("Found element: " + username);
		// Send email
		username.sendKeys("rayudu-web-hub");
		WebElement createAccountButton = driver.findElement(By.className("signup-form-fields__button"));
		createAccountButton.click();
		
		 takeScreenshot(driver, "signup_page.png");
		
	}
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\glvsr\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement firstName = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + firstName);
		// Send first name
		firstName .sendKeys("Rayudu");
		
		WebElement lastName = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lastName);
		// Send last name
		lastName.sendKeys("Gudipalli");

		WebElement email = driver.findElement(By.id("email"));
		System.out.println("Found element: " + email);
		// Send email
		email.sendKeys("gudipallirayudu@gmail.com");

		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Found element: " + password);
		// Send password
		password.sendKeys("Password@123");

		WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + confirmPassword);
		// Confirm password
		confirmPassword.sendKeys("Password@123");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 * 
		 */
		// Write code
//		WebElement createAccountButton = driver.findElement(By.className("ActionButton"));
//		System.out.println("Found element: " + createAccountButton);
//		createAccountButton.click();
		WebElement createAccountButton = driver.findElement(By.cssSelector("[data-testid='account-action-btn']"));
		createAccountButton.click();
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		
		  takeScreenshot(driver, "registration_page.png");
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	public static void takeScreenshot(WebDriver driver, String fileName) {
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String filePath = "C:\\Users\\glvsr\\Downloads\\" + fileName; // Save in Downloads folder
	    try {
	        FileUtils.copyFile(screenshot, new File(filePath));
	        System.out.println("Screenshot saved at: " + filePath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
}
