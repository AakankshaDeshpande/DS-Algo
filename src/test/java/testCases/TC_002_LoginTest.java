package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MyLoginVerificationPage;
import pageObject.RegistrationPage;
import pageObject.SignInPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test
   public void verify_login()
   {
		
		

		
		logger.info("****** Starting Login Page****** ");
		logger.debug("**** Debug login page******");
		
		
		try {
		
			//Home page
			HomePage hp = new HomePage(driver);
			hp.ClickSignin();//sign in link
			logger.info("Clicked on login link");
			Reporter.log("Create SignIn object");
			
			//Login page
			logger.info("Login User");
			SignInPage login = new SignInPage(driver);
			login.sendUserName(p.getProperty("username"));// get from config 
			login.sendPwdName(p.getProperty("password"));// get);
			login.clickLogin();
			logger.info("********* User clicked on Login button *************");
			Reporter.log("User clicked on Login button");
			// Login Verification page
			MyLoginVerificationPage verifylogin = new MyLoginVerificationPage(driver);
			boolean targetpage = verifylogin.isLoginPageExists();
			if(targetpage == true)
			{
				logger.info("Login test pass");
				Reporter.log("Login test pass");
				Assert.assertTrue(true);
			}
			else
			{
			  logger.error("******* Login test fail*******");
			  Reporter.log("Login test fail");
			  Assert.fail();
			}
			
			
			
   }catch(Exception e)
		{
	        Assert.fail();
		}
		logger.info("****** Finished Login Page****** ");
   }
		
}
