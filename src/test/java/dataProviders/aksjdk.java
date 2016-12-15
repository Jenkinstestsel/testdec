package dataProviders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class aksjdk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(System.getProperty("user.dir"));
//		Date date = new Date();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
//		System.out.println(simpleDateFormat.format(date));
//		
//		
//		System.out.println(date);
		
		
//		implicit and explicit wait
		WebDriver driver = new FirefoxDriver();
		driver.get("http://books.rediff.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
//		explicit wait
		WebElement btn_search = driver.findElement(By.className("newsrchbtn"));
		
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(btn_search));
		
		
		
		
		
		
		
		
		
	}

}

