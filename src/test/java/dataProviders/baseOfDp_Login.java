package dataProviders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import genericLibrary.ExcelRW;

import org.testng.annotations.DataProvider;

public class baseOfDp_Login{
	
	
	@DataProvider(name="InvalidLogin")
	public static Iterator<Object[]> dp_invalidLogin() throws Exception{
	
		ExcelRW excelRW = new ExcelRW(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_Data.xlsx");
		
		int rowcount = excelRW.rowcount("Login");
		System.out.println(rowcount);
		int colcount = excelRW.columncount("Login");
//		List to store Object array which inturn store Map
		List<Object[]> Loginlist = new ArrayList<Object[]>();
//		row iterations
		for(int iRow =1;iRow<=rowcount ;iRow++){
			
			if(excelRW.readcellvalue("Login",iRow,2).trim().equalsIgnoreCase("Y") && excelRW.readcellvalue("Login",iRow,3).equals("Invalid_login")){
//			map to store data
			Map<String, String> hashMap = new HashMap<String,String>();
//			column iteration
			for(int jCol = 0 ;jCol<=colcount;jCol++){
				
				String Key =excelRW.readcellvalue("Login", 0, jCol);
				String Val =excelRW.readcellvalue("Login", iRow, jCol);
				
				hashMap.put(Key, Val);
				
				
			}	//col loop
			
			Object[] x = new Object[1];
			x[0]=hashMap;
			Loginlist.add(x);
			} //end of conditional statement 
		}//row loop
		
		return Loginlist.iterator();
			
	}
		
	
	
	

	@DataProvider(name="ValidLogin")
	public static Iterator<Object[]> dp_validLogin() throws Exception{
	
		ExcelRW excelRW = new ExcelRW(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_Data.xlsx");
		
		int rowcount = excelRW.rowcount("Login");
		System.out.println(rowcount);
		int colcount = excelRW.columncount("Login");
//		List to store Object array which inturn store Map
		List<Object[]> Loginlist = new ArrayList<Object[]>();
//		row iterations
		for(int iRow =1;iRow<=rowcount ;iRow++){
			
			if(excelRW.readcellvalue("Login",iRow,2).equals("Y") && excelRW.readcellvalue("Login",iRow,3).equals("Valid_login")){
//			map to store data
			Map<String, String> hashMap = new HashMap<String,String>();
//			column iteration
			for(int jCol = 0 ;jCol<=colcount;jCol++){
				
				String Key =excelRW.readcellvalue("Login", 0, jCol);
				String Val =excelRW.readcellvalue("Login", iRow, jCol);
				
				hashMap.put(Key, Val);
				
				
			}	//col loop
			
			Object[] x = new Object[1];
			x[0]=hashMap;
			Loginlist.add(x);
			} //end of conditional statement 
		}//row loop
		
		return Loginlist.iterator();
			
	}
		
	
	
	

}
