package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegistrationPage;
import testBase.BaseClass;

public class TC_001_RegistrationTest extends BaseClass {
	
	
	@Test
	
	public void verify_registartion()
	{
		
		logger.info("***** starting TC_001_RegistrationTest ***** ");
		//logger.debug("*****Application log started ***** ");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.ClickRegister();
		logger.info("Clicked on registration link");
		
		
		logger.info("registering User");
		RegistrationPage regpage = new RegistrationPage(driver);
		String randomPwd = randomeAlphaNumeric();
		System.out.println(randomPwd);
		regpage.setUserName(randomeString().toUpperCase());
		regpage.setPwdName(randomPwd);
		regpage.setConfPwdName(randomPwd);
		
		regpage.clickRegister();
		logger.info("Clicked on registration button");
		
		String Url   = regpage.currentUrl();
		
		logger.info("Validating expected message...");
		
		if(Url.equals("https://dsportalapp.herokuapp.com/home"))
		{
			logger.info("Inside if  ** Url matched***");
		  Assert.assertTrue(true);
		}
		else
		{
			logger.info("Inside ELSE  ** Url not matched***");
			//logger.debug("*****Debug log ***** ");
			Assert.fail();
		}
	}
	catch(Exception e)
		{
			logger.error("Test Fail" );
			Assert.fail();
		}
		//logger.debug("*****Application log ended ***** ");
		logger.info("***** Finished  TC_001_RegistrationTest ***** ");
	}
	
	
}
