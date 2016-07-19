package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LoginPage {
	
	WebDriver w;
	
	public LoginPage (WebDriver iw)
	{
		this.w=iw;
	}

	@FindBy(xpath =".//*[@id='user_email']")WebElement username;
	@FindBy(xpath =".//*[@id='user_password']")WebElement password;
	@FindBy(xpath ="//*[@id='new_user']/input[4]")WebElement LogInButton;
	@FindBy(xpath=".//*[@id='navbar']/div/div/div/ul/li[3]/a/img")WebElement  Image;
	@FindBy(xpath =".//*[@id='navbar']/div/div/div/ul/li[3]/ul/li[4]/a")WebElement logOut;
	

	//By signout = By.xpath(".//*[@id='navbar']/div/div/div/ul/li[3]/ul/li[4]/a");
	
	
	public void LogInApp(String user, String pass) throws Exception
	{
		username.sendKeys(user); 
		password.sendKeys(pass);
		LogInButton.click();
		Thread.sleep(2000);
		
	}
	
	public void ImageLink()
	{
		Image.click();
	}
	public void logOutLink() throws Exception
	{
		//WebDriverWait wait = new WebDriverWait(w,20);
	    //WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signout));
	    //LoginPage l = new LoginPage(w);
		//String text = logOut.getText();
		 logOut.click();
		 Thread.sleep(2000);
	   //Assert.assertEquals(text, "log out", "SIGN OUT LINK IS NOT VERIFIED PROPERLY");
	
	
	}



	
}
