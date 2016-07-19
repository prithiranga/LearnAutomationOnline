package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage
{
	
	WebDriver w;
	
	public  HomePage(WebDriver idriver)
	{
		this.w = idriver;
		
	}
	
	@FindBy(xpath="//*[@id='navbar']/div/div/div/ul/li[1]/a")WebElement LogIn;
	@FindBy(xpath=".//*[@id='navbar']/div/div/div/ul/li[2]/a")WebElement SignUp;
	@FindBy(xpath="html/body/div[1]/div[1]/div/div/a")WebElement Enroll;
	
	
	public void clickOnLogIn()
	{
		LogIn.click();
	}
	
	public void clickOnSignUp()
	{
		SignUp.click();
	}
	
	public void clickOnEnroll()
	{
		Enroll.click();
	}
	

	public String getTitle()
	{
		return w.getTitle();
		
	}
}




