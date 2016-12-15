package genericLibrary;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	public WebDriver driver;
	public static ExtentReports extentReports;
	public ExtentTest startTest;
	public String btype;
	
	@BeforeSuite
	public void intitalSetup(){
		
		extentReports = new ExtentReports("E:\\Project\\Report\\" + "rediffAutomationreport_" + timestamp() + ".html"    ,false);
				
	}
	
	
//	create unique date time stamp
	public String timestamp(){
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		String reportdate = simpleDateFormat.format(date);
		return reportdate;
	}
	
	
	@BeforeMethod
	@Parameters({"browser"})
	public void launch_App(String tbrowser) throws Exception{
		btype=tbrowser;
		System.out.println(tbrowser);
		if(tbrowser.equals("firefox")){
			driver = new FirefoxDriver();	
		}else if(tbrowser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(tbrowser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "E:\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();		
		}

		System.out.println(utility.getpropertyval("url"));
		driver.get(utility.getpropertyval("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	
	@AfterMethod
	public void teardown(){
		
		driver.close();
		extentReports.endTest(startTest);
		extentReports.flush();
		
	}	
	
//	Explicit wait
	public void wait(WebElement ele){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	
//	screenshot
	public String screenshot(String TCID,String Orderid) throws Exception{
		
		TakesScreenshot Screenshot=(TakesScreenshot)driver;
		File screenshotAs = Screenshot.getScreenshotAs(OutputType.FILE);
		
		String path = "E:\\Project\\Screenshot\\" + TCID + "_" + Orderid + "_" + timestamp() + ".png";
		FileUtils.copyFile(screenshotAs, new File(path));
		return path;
		
		
	}
	
	
	
//	elements exist or not
	public int exist(List<WebElement> fd ){
				return fd.size();
		
	}

}
