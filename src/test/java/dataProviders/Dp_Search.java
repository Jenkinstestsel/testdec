package dataProviders;

import genericLibrary.utility;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class Dp_Search {
	
	
	@DataProvider(name="InvalidSearch")
	public static Iterator<Object[]> dp_invalidSearch() throws Exception{
		List<Object[]> Loginlist = utility.commondpLogic("Invalid_Search","Search");
		return Loginlist.iterator();
			
	}
	
	@DataProvider(name="ValidSearch")
	public static Iterator<Object[]> dp_ValidSearch() throws Exception{
		List<Object[]> Loginlist = utility.commondpLogic("Valid_Search","Search");
		return Loginlist.iterator();
			
	}	
	
	
	

}
