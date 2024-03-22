package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage{
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//(By.id("id_username"));
   // WebElement passwordField = driver.findElement(By.id("id_password1"));
   // WebElement confirmPasswordField = driver.findElement(By.id("id_password2"));
	
	
	@FindBy(id="id_username")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="id_password1")
	WebElement pwd;
	
	@FindBy(id="id_password2")
	WebElement confpwd;

	@FindBy(xpath="//input[@value = 'Register']")
	WebElement btnRegister;
	
	@FindBy(xpath = "//div[@class = 'alert alert-primary']")
	WebElement erMsg;
	
	

	
	
	
	public void  setUserName(String uname)
	{
		username.sendKeys(uname);
		
	}
	public void  setPwdName(String password)
	{
		pwd.sendKeys(password);
		
	}
	public void  setConfPwdName(String confpassword)
	{
		confpwd.sendKeys(confpassword);
		
	}
	
	public void clickRegister()
	{
		btnRegister.click();/// click register button
	} 
	
	
	public String errorMsg()
	{
		
		
		
		  try {
			 return( erMsg.getText());
		    	
		        
		    } catch (Exception e) {
		        return(e.getMessage());
		    }
		
		
	}
	
	public String currentUrl()
	{
		 String currUrl = driver.getCurrentUrl();
		 
		 return currUrl ;
		        
		  
	} 
		
		
	
	
	
	public String popupMsg()
	{
		String messageStr ="";
		
		try {
	        // Check for validation popup
	        // Assuming validation popup is displayed
	    	
	    	WebElement activeElement = driver.switchTo().activeElement();
	  	    messageStr = activeElement.getAttribute("validationMessage");
	  	   
	  	    return(messageStr);
	    }
		catch (Exception e)
		{
	        return(e.getMessage());
	        
	    }
     	}
	
}
