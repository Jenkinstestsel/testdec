package dataProviders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import genericLibrary.ExcelRW;
import genericLibrary.utility;

import org.testng.annotations.DataProvider;

public class Dp_Login{
	
	
	@DataProvider(name="InvalidLogin")
	public static Iterator<Object[]> dp_invalidLogin() throws Exception{
		List<Object[]> Loginlist = utility.commondpLogic("Invalid_login","Login");
		return Loginlist.iterator();
			
	}
	

	@DataProvider(name="ValidLogin")
	public static Iterator<Object[]> dp_validLogin() throws Exception{
		List<Object[]> Loginlist = utility.commondpLogic("Valid_login","Login");
		return Loginlist.iterator();
			
	}
		
	

}
