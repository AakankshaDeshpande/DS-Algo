package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement linkRegister;
	@FindBy(xpath ="//a[contains(text(),'Sign in')]")
	WebElement linkSignin;

	public void ClickRegister()
	{
		linkRegister.click();///click on register link not button
	}
	
	public void ClickSignin()
	{
		linkSignin.click();//for login link
	}
	
}
