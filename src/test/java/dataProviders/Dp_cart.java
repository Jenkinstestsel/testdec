package dataProviders;

import genericLibrary.utility;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class Dp_cart {

	
	@DataProvider(name="Addtocart")
	public static Iterator<Object[]> dp_invalidSearch() throws Exception{
		List<Object[]> Loginlist = utility.commondpLogic("Addtocart","Cart");
		return Loginlist.iterator();
			
	}
	
	
	
	
	
	
	
	
}
