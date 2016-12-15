package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.support.ui.WebDriverWait;

public class utility {
	
	
//	read from properties file
	
	public static String getpropertyval(String key) throws Exception{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.get(key).toString();
		
		
	}
	


// Extract data from testdata sheet

	public static List<Object[]> commondpLogic(String scriptid,String Sheetname) throws Exception{
		
		
		ExcelRW excelRW = new ExcelRW(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_Data.xlsx");
		
		int rowcount = excelRW.rowcount(Sheetname);
		System.out.println(rowcount);
		int colcount = excelRW.columncount(Sheetname);
//		List to store Object array which inturn store Map
		List<Object[]> Loginlist = new ArrayList<Object[]>();
//		row iterations
		for(int iRow =1;iRow<=rowcount ;iRow++){
			
			if(excelRW.readcellvalue(Sheetname,iRow,2).equals("Y") && excelRW.readcellvalue(Sheetname,iRow,3).equals(scriptid)){
//			map to store data
			Map<String, String> hashMap = new HashMap<String,String>();
//			column iteration
			for(int jCol = 0 ;jCol<=colcount;jCol++){
				
				String Key =excelRW.readcellvalue(Sheetname, 0, jCol);
				String Val =excelRW.readcellvalue(Sheetname, iRow, jCol);
				
				hashMap.put(Key, Val);
				
				
			}	//col loop
			
			Object[] x = new Object[1];
			x[0]=hashMap;
			Loginlist.add(x);
			} //end of conditional statement 
		}//row loop
		
		return Loginlist;	
		
		}
	
	
	

}
