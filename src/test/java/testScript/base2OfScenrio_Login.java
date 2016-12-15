package testScript;

import genericLibrary.cbase;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class base2OfScenrio_Login extends cbase{
	
//	@Test(dataProvider="InvalidLogin" , dataProviderClass=dataProviders.Dp_Login.class)
	public void Invalid_login(Map logindata){
		String Uname = logindata.get("UserName").toString();		
	
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("logid")).sendKeys(Uname);
		driver.findElement(By.name("pswd")).sendKeys(logindata.get("Pwd").toString());
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String act_msg = driver.findElement(By.xpath("//b[contains(text(),'Sorry we were unable to complete this step because :')]")).getText();
		
		String  exp_msg=logindata.get("Expected").toString();
		
		if(act_msg.equals(exp_msg)){
			
			System.out.println("pass");
			
		}else{
			System.out.println("fail");
		}
		
		
	}
	
	
	
	@Test(dataProvider="ValidLogin" , dataProviderClass=dataProviders.Dp_Login.class)
	public void Valid_login(Map logindata){
		String Uname = logindata.get("UserName").toString();
		
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("logid")).sendKeys(Uname);
		driver.findElement(By.name("pswd")).sendKeys(logindata.get("Pwd").toString());
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String act_msg = driver.findElement(By.className("proper")).getText();
		
		String  exp_msg=logindata.get("Expected").toString();
		
		if(act_msg.equals(exp_msg)){
			
			System.out.println("pass");
			
		}else{
			System.out.println("failed as the expected was " + exp_msg + "  and actual is " + act_msg);
		}
			
	
		
	}
	
	
	
	
	
}
