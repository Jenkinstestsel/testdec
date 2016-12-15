package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_Cartpage {
	
	
	
	@FindBy(xpath="//span[contains(text(), 'Flood and Fire')]")
	public List<WebElement> msg_fllofire;
	
	
	@FindBy(xpath="//span[contains(text() ,'Flood and Fire')]")
	public WebElement msg_fl_fire;
	
	@FindBy(id="frmCart")
	public WebElement frame;
	
	
//	Constructor
	public pf_Cartpage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	
	

}
