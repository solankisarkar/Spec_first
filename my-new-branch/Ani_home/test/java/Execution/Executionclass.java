package Execution;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Executionclass 
{

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeTest
	public void navigate() throws InterruptedException, IOException
	{
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (1)\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("http://www.way2testing.com");
	report=new ExtentReports("./Reports/TestReport.html");
	}
	
	
	@Test(priority = 0)
	public void title()
	{
	logger=report.startTest("Verifytitle");
	logger.log(LogStatus.INFO, "test started ");
	System.out.println("Your Title is :" + driver.getTitle());
	String title = driver.getTitle();
	if(title.equalsIgnoreCase(" Online Software Testing: Software Testing"))
	{
	logger.log(LogStatus.PASS, "Test Verified");
	}
	else
	{
	logger.log(LogStatus.FAIL, "Test Failed");
	}
	report.endTest(logger);
	//Flush the data to report
	report.flush();
	}
	
	
	
	
	
	@AfterTest
	public void tearDown() throws InterruptedException 
	{			
		  Thread.sleep(3000);
		  driver.close();
		  driver.quit();
	}
	
}
