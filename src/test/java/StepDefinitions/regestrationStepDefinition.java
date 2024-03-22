package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class regestrationStepDefinition {
	
//	
//	
//	
//
//	
//	    private WebDriver driver;
//
//	    @Given("I am on the registration page")
//	    public void iAmOnTheRegistrationPage() {
//	        
//	        driver = new ChromeDriver();
//	        driver.get("https://dsportalapp.herokuapp.com/register");
//	    }
//
////	    @When("I fill in the registration form with valid data")
////	    public void iFillInTheRegistrationFormWithValidData() {
////	    	driver.findElement(By.id("id_username")).sendKeys("SDET1234");
////	  	  driver.findElement(By.id("id_password1")).sendKeys("numpy@1234");
////	  	driver.findElement(By.id("id_password2")).sendKeys("numpy@1234");
////	  	driver.findElement(By.xpath("//input[@value = 'Register']")).click();
////	    }
//
//	    @When("I fill in the registration form with invalid data {string}, {string}, and {string}")
//	    public void iFillInTheRegistrationFormWithInvalidData(String username, String password, String confirmPassword) {
//	    	
//	    	driver.findElement(By.id("id_username")).sendKeys(username);
//		  	  driver.findElement(By.id("id_password1")).sendKeys(password);
//		  	driver.findElement(By.id("id_password2")).sendKeys(confirmPassword);
//	    	driver.findElement(By.xpath("//input[@value = 'Register']")).click();
//	    }
//
//	    @Then("I should see an error/sucess message")
//	    public void iShouldSeeASuccessMessage() {
//	    	WebElement errorMessageElement = null;
//	        String errorMessage = "";
//	        Alert alert = null;
//	        String alertMessage = "";
//
//	        try {
//	        	driver.findElement(By.xpath("//input[@value = 'Register']")).click();
//	        } catch (Exception e) {
//	        	System.out.println("No message");
//	        }
//
//	        try {
//	        	//Validation popup capture code
//	      	  WebElement activeElement = driver.switchTo().activeElement();
//	      	  String messageStr = activeElement.getAttribute("validationMessage");
//	      	  System.out.println("Actual message appeared on screen: " + messageStr);
//	        } catch (Exception e) {
//	        	System.out.println("No alert");
//	        }
//
//	        // Assert that either the error message or the popup validation alert is not empty
//	        Assert.assertTrue(!errorMessage.isEmpty() || !alertMessage.isEmpty());
//	    }
	
	
	
	private WebDriver driver;
	
	@Given("I am on the registration page")
	public void i_am_on_the_registration_page() {
		 driver = new ChromeDriver();
	     driver.get("https://dsportalapp.herokuapp.com/register");
	}
	@When("^I fill in the registration form with invalid data (.*), (.*), and (.*)$")
    public void iFillInTheRegistrationFormWithInvalidData(String username, String password, String confirmpwd) {
		WebElement usernameField = driver.findElement(By.id("id_username"));
        WebElement passwordField = driver.findElement(By.id("id_password1"));
        WebElement confirmPasswordField = driver.findElement(By.id("id_password2"));
        
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmpwd);
        
        // Assuming there's a submit button, you would click it here
        // For now, let's just print the values to check if they are being filled correctly
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Confirm Password: " + confirmpwd);
        driver.findElement(By.xpath("//input[@value = 'Register']")).click();
    } 
	
	@Then("I should see an error-success message")
	public void i_should_see_an_error_success_message() {
		String errorMessage = "";
	    String currentUrl = "";
	    String messageStr ="";
	    Alert alert = null;

	    try {
	    	
	    	
	        // Check for error message
	        // Assuming error message is displayed on the page
	    	errorMessage = "";
	        errorMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-primary']")).getText();
	    } catch (Exception e) {
	        System.out.println("No error message found.");
	        errorMessage = "";
	    }

	    try {
	        // Check for validation popup
	        // Assuming validation popup is displayed
	    	messageStr ="";
	    	WebElement activeElement = driver.switchTo().activeElement();
	  	   messageStr = activeElement.getAttribute("validationMessage");
	  	  System.out.println("Actual message appeared on screen: " + messageStr);
	    } catch (Exception e) {
	        System.out.println("No validation popup found.");
	        messageStr ="";
	    }

	    // Validate current URL
	    currentUrl = driver.getCurrentUrl();

	    // Perform assertions or logging
	    if (!errorMessage.isEmpty()) {
	        System.out.println("Error Message: " + errorMessage);
	    }
	    else if (!messageStr.isEmpty()) {
	        	System.out.println("Error Message: " + messageStr);
	    } else {
	        System.out.println("No error message or validation popup found.");
	    }
	    
	    System.out.println("Current URL: " + currentUrl);
	}
	}

	
	