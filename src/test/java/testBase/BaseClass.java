package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;//log4j
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
     public WebDriver driver;
      public Logger logger;
      public Properties p;

	
	
	@BeforeClass
	@Parameters({"os","browser"})// we are  getting this value from testng/master.xml
	public void setup(String os, String br) throws IOException
	{
		//loading properties file
		
		
		String hostUrl = "http://localhost:4444/wd/hub";
		FileReader file = new FileReader(".//src/test/resources/config.properties"); 
		p= new Properties();
		p.load(file);
		
		
		
		//loading Log4j2 xml file 
		
		logger  = LogManager.getLogger(this.getClass());//return logger type of object
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
			  DesiredCapabilities capabilities = new DesiredCapabilities();
			  
			  //decide OS
			  if(os.equalsIgnoreCase("windows"))
			  {
				  capabilities.setPlatform(Platform.WINDOWS);
			  }
			  else if(os.equalsIgnoreCase("mac"))
			  {
				  capabilities.setPlatform(Platform.MAC);
			  }
			  else
			  {
				  System.out.println("No matching OS....");
				  return;
			  }
			  
			  
			  
			  //decide browser
			  
			  switch(br.toLowerCase())
			  {
			  case "chrome" : capabilities.setBrowserName("chrome");break;
			  case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			  case "firefox":capabilities.setBrowserName("firefox");break;
			  default:System.out.println("No matching browser....");return;
			  
			  }
			  
			 driver = new RemoteWebDriver(new URL(hostUrl), capabilities);
			  
			  
			}
		else if(p.getProperty("ececution_env").equalsIgnoreCase("local"))
		{

			// Condition check for cross browsing and parallel browsing --locally
			switch(br.toLowerCase())
			{
			case "chrome": driver = new ChromeDriver();break;
			case"edge":driver = new EdgeDriver();break;
			default:System.out.println("No matching browser....");
			return;
			}
			
		}
		
		
		
		
		
		//****//
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://dsportalapp.herokuapp.com/register");
		//driver.get("https://dsportalapp.herokuapp.com/login");
		driver.get(p.getProperty("appURL")); //Reading URL from config.properties
		driver.manage().window().maximize();
		
	   	
	}
	
	//@AfterClass
	/*
	 * public void tearDown() { driver.close(); }
	 */
	public String randomeString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	public String randomeAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphabetic(3);
		String num =RandomStringUtils.randomNumeric(4);
		return (str+"@"+num);
		
	}

}
