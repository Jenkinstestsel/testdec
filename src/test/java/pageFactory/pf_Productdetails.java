package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_Productdetails {
	
	@FindBy(className="buynowbtnbig")
	public WebElement btn_buynow;
	
	
	
//	Constructor
	public pf_Productdetails(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	public void click_buynow(){
		btn_buynow.click();
	}	
	
	
	

}
