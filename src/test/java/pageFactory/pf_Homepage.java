package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_Homepage {
	
	@FindBy(linkText = "Sign In")
	public WebElement lk_Signin;
	
	@FindBy(className = "proper")
	public WebElement lk_username;
	
	@FindBy(id="srchword")
	public WebElement txt_searchbox;
	
	@FindBy(className="newsrchbtn")
	public WebElement btn_search;
	
	@FindBy(className="sorrymsg")
	public WebElement msg_Sorry;
	
	@FindBy(id="find")
	public WebElement msg_searchcount;
	
	@FindBy(xpath="//img[@alt='Flood and Fire: Book by Janet Elaine Smith']")
	public WebElement img_Floodandfire;
	
	
	
	
//	Constructor
	public pf_Homepage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
//	click on Sigin
	public void click_Sigin(){
		lk_Signin.click();
	}
	
	
	public String extract_username(){
		return lk_username.getText();
	}
	
	
//	ente t sarch oprtion and click search
	public void search_opertaion(String searchoption){
		txt_searchbox.sendKeys(searchoption);
		btn_search.click();
	}
	
	
//	extract the error messagae
	public String extract_errormsg(){
		return msg_Sorry.getText();
		
	}
	
//	extract search count
	
	public String extract_searchcount(){
		return msg_searchcount.getText();
	}
	
	
	public void click_image(){
		img_Floodandfire.click();
		
	}

}
