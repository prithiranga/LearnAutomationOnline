package testcases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import freemarker.log.Logger;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLogInPageWithReports1 {
	
	WebDriver w;
	ExtentReports reports;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		
		 reports =  new ExtentReports(".\\Reports\\LoginPageReport.html",true);
		
		 logger= reports.startTest("verify the test login");
		
		 w =BrowserFactory.getBrowser("Chrome");
	
	
		 w.get(DataProviderFactory.getConfig().getApplicationUrl());
		 
		 logger.log(LogStatus.INFO,"Application is up and running ");
	}

	@Test
	public void testHomePage() throws Exception
	{
		HomePage home = PageFactory.initElements(w, HomePage.class); 	
	
		String title = home.getTitle();
	
		System.out.println(" My Title is "+title );
	
		//Assert.assertTrue(title.contains("learn-automation"));
		
		 logger.log(LogStatus.PASS,"home page loaded nd verified ");
		
		
		 home.clickOnLogIn();
		 
		 logger.log(LogStatus.INFO,"click on signout  link ");
	
		 LoginPage log = PageFactory.initElements(w, LoginPage.class); 
	
		
		 
		 
		 log. LogInApp(DataProviderFactory.getExcel().getData(0,0,0),DataProviderFactory.getExcel().getData(0,0,1));
		
		 logger.log(LogStatus.INFO," login into application ");
		
		  log.ImageLink();
		
		
		
		
		log.logOutLink();
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(w, "validation 2")));
		
		logger.log(LogStatus.PASS," signout link appeared ");
	 }
	
	
	
    @AfterMethod
	public void tearDown(ITestResult result)
	{
    	if (result.getStatus()==ITestResult.FAILURE)
    	{
    		String path =Helper.captureScreenshot(w, result.getName());
    		logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
    		
    	}
    	w.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		BrowserFactory.closeBrowser(w);
		reports.endTest(logger);
		reports.flush();
	}
    
    
}