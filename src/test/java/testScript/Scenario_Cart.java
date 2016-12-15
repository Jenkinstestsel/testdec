package testScript;

import genericLibrary.Base;
import genericLibrary.cbase;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pageFactory.pf_Cartpage;
import pageFactory.pf_Homepage;
import pageFactory.pf_Productdetails;

import com.relevantcodes.extentreports.LogStatus;

public class Scenario_Cart  extends Base{

	
	@Test(dataProvider="Addtocart",dataProviderClass=dataProviders.Dp_cart.class)
	public void Add_to_cart(Map cartdata) throws Exception{
		
		String searchtext = cartdata.get("Searchtext").toString();
		String tcid=cartdata.get("TCID").toString();
		String orderid=cartdata.get("order").toString();
		
		startTest = extentReports.startTest(btype + "-" +tcid);
		
		if(driver.getTitle().contains("rediff")){
			startTest.log(LogStatus.PASS, "validate title","Passed  Validate title" + startTest.addScreenCapture(screenshot(tcid, orderid)));
		}else{
			startTest.log(LogStatus.FAIL, "validate title","Failed  Validate title as Expected was rediff and actual is " + driver.getTitle()+ " ."  + startTest.addScreenCapture(screenshot(tcid, orderid)));
		}
		
		pf_Homepage Homepage = new pf_Homepage(driver);
		
		Homepage.search_opertaion(searchtext);
		wait(Homepage.msg_searchcount);
		
		Homepage.click_image();
		
//		Product details page
		if(driver.getTitle().contains("Flood and Fire")){
			startTest.log(LogStatus.PASS, "validate products title","Passed  Validate title" + startTest.addScreenCapture(screenshot(tcid, orderid)));
		}else{
			startTest.log(LogStatus.FAIL, "validate products title","Failed  Validate title as Expected was rediff and actual is " + driver.getTitle()+ " ."  + startTest.addScreenCapture(screenshot(tcid, orderid)));
		}
		
		pf_Productdetails Productdetails = new pf_Productdetails(driver);
		wait(Productdetails.btn_buynow);
		
		Productdetails.click_buynow();
		
		
//		Cart page
		if(driver.getTitle().contains("rediff.com")){
			startTest.log(LogStatus.PASS, "validate products title","Passed  Validate title" + startTest.addScreenCapture(screenshot(tcid, orderid)));
		}else{
			startTest.log(LogStatus.FAIL, "validate products title","Failed  Validate title as Expected was rediff and actual is " + driver.getTitle()+ " ."  + startTest.addScreenCapture(screenshot(tcid, orderid)));
		}
		
		
		
		
		
		pf_Cartpage Cartpage = new pf_Cartpage(driver);	
		
		wait(Cartpage.frame);
		driver.switchTo().frame(Cartpage.frame);
		wait(Cartpage.msg_fl_fire);
		
		
		if(exist(Cartpage.msg_fllofire)>0){
			
			startTest.log(LogStatus.PASS, "validate Add product","Passed  Validate title" + startTest.addScreenCapture(screenshot(tcid, orderid)));
		}else{
			startTest.log(LogStatus.FAIL, "validate Add product","Failed  as product not added"  + startTest.addScreenCapture(screenshot(tcid, orderid)));
			
		}
		
		driver.switchTo().defaultContent();
		
	}
	
	
	
	@Test
	public void hola(){
		System.out.println("hola");
		 FirefoxDriver fd = new FirefoxDriver();
		  fd.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		
//		enter amount
		  fd.findElement(By.id("one")).sendKeys("10000");
		
//		Enter rate of intr=erest
		  WebElement findElement = fd.findElement(By.id("two"));
		  
		  findElement.sendKeys("10");
		
//		enter tenure
		  fd.findElement(By.id("three")).sendKeys("120");
		
//		Click on calcuate
		  fd.findElement(By.name("B1")).click();  
		  
		
//		extract EMI
		  String output = fd.findElement(By.id("four")).getAttribute("value");
		  
		System.out.println(output);
//		cloase app
		
		fd.close();
		
		
		
	}
	
	
	
}
