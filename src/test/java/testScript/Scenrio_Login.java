package testScript;

import genericLibrary.cbase;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageFactory.pf_Homepage;
import pageFactory.pf_Loginpage;

public class Scenrio_Login extends cbase{
	
	@Test(dataProvider="InvalidLogin" , dataProviderClass=dataProviders.Dp_Login.class)
	public void Invalid_login(Map logindata){
		
		
		
//		inputdata
		
		String Uname = logindata.get("UserName").toString();
		String password = logindata.get("Pwd").toString();
		String exp_message= logindata.get("Expected").toString();
		String TCID= logindata.get("TCID").toString();
		
		startTest = extentReports.startTest(TCID);
		
	
		pf_Homepage Homepage = new pf_Homepage(driver);
//		driver.findElement(By.linkText("Sign In")).click();
		Homepage.click_Sigin();
		startTest.log(LogStatus.PASS, "Sign in clicked","Succesfully clicked on sig in");
		pf_Loginpage Loginpage = new pf_Loginpage(driver);
		
//		driver.findElement(By.name("logid")).sendKeys(Uname);
//		driver.findElement(By.name("pswd")).sendKeys(logindata.get("Pwd").toString());
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Loginpage.Login_operation(Uname, password);
		startTest.log(LogStatus.PASS, "enter login details","Succesfully entered login details");
//		String act_msg = driver.findElement(By.xpath("//b[contains(text(),'Sorry we were unable to complete this step because :')]")).getText();
		String act_msg =Loginpage.extract_errormsg();
		
		
		String  exp_msg=exp_message;
		
		if(act_msg.equals(exp_msg)){
			startTest.log(LogStatus.PASS, "Error message validation","Successfully validated the error message");
			System.out.println("pass");
			
		}else{
			startTest.log(LogStatus.FAIL, "Error message validation","Failes as Actual and expected were not matching");
			System.out.println("fail");
		}
//		
		
//		Assert.assertEquals(act_msg, exp_msg,"Failes as Actual and expected were not matching");
		
	}
	
	
	
	@Test(dataProvider="ValidLogin" , dataProviderClass=dataProviders.Dp_Login.class)
	public void Valid_login(Map logindata){
//		SoftAssert
		SoftAssert Assert = new SoftAssert();
		
		
//		inputdata
		String Uname = logindata.get("UserName").toString();
		String password = logindata.get("Pwd").toString();
		String exp_message= logindata.get("Expected").toString();
		
		pf_Homepage Homepage = new pf_Homepage(driver);
		Homepage.click_Sigin();
		
		Assert.assertEquals(driver.getTitle(), "rediff","page not loaded");
		
		pf_Loginpage Loginpage = new pf_Loginpage(driver);
		Loginpage.Login_operation(Uname, password);
		
		String act_msg = Homepage.extract_username();
		
		String  exp_msg=exp_message;
		
//		if(act_msg.equals(exp_msg)){
//			
//			System.out.println("pass");
//			
//		}else{
//			System.out.println("failed as the expected was " + exp_msg + "  and actual is " + act_msg);
//		}
			
		Assert.assertEquals(act_msg, exp_msg,"failed as the expected was " + exp_msg + "  and actual is " + act_msg);
	
		Assert.assertAll();
	}
	
	
	
	
	
}
