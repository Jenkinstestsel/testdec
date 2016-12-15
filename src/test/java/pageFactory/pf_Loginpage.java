package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_Loginpage {
	
	
	@FindBy(name="logid")
	public WebElement txt_uname;
	
	@FindBy(name="pswd")
	public WebElement txt_pwd;
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement btn_Login;
	
	
	@FindBy(xpath="//b[contains(text(),'Sorry we were unable to complete this step because :')]")
	public WebElement msg_Error_msg;
	

//	Constructor to initialize the elements againt the driver
	public pf_Loginpage(WebDriver driver){

		PageFactory.initElements(driver, this);
		
	}
	
	
//	enter username
	 public void enter_username(String username){
		 txt_uname.sendKeys(username);
	 }
	 
	 
//		enter password
	 public void enter_passowrd(String pwd){
			 txt_pwd.sendKeys(pwd);
		 }
	 
	 
//		click on login
	 public void click_Login(){
			 btn_Login.click();
		 } 
	 
	 
//	Login Operation
	 public void Login_operation(String Uname,String pwd ){
		 enter_username(Uname);
		 enter_passowrd(pwd);
		 click_Login();
		 
		 
	 }
	
	public String extract_errormsg(){
		return msg_Error_msg.getText();
		
	}

}
