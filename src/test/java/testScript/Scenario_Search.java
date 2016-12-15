package testScript;

import java.util.Map;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.pf_Homepage;
import genericLibrary.cbase;

public class Scenario_Search extends cbase{
	
	
//	Invalid Search
	@Test(dataProvider="InvalidSearch",dataProviderClass=dataProviders.Dp_Search.class)
	public void InvalidSearch(Map Searchdata) throws Exception{
		
		String searchtext = Searchdata.get("Searchtext").toString();
		String expected = Searchdata.get("expected").toString();
		String tcid=Searchdata.get("TCID").toString();
		String orderid=Searchdata.get("order").toString();
		
		
		startTest = extentReports.startTest(btype + "-" +tcid);
		
		if(driver.getTitle().contains("rediff")){
			startTest.log(LogStatus.PASS, "validate title","Passed  Validate title" + startTest.addScreenCapture(screenshot(tcid, orderid)));
		}else{
			startTest.log(LogStatus.FAIL, "validate title","Failed  Validate title as Expected was rediff and actual is " + driver.getTitle()+ " ."  + startTest.addScreenCapture(screenshot(tcid, orderid)));
		}
		
		pf_Homepage Homepage = new pf_Homepage(driver);
		
		Homepage.search_opertaion(searchtext);
		wait(Homepage.msg_Sorry);
			
		String Actual = Homepage.extract_errormsg();
		
		if(Actual.equals(expected)){
			startTest.log(LogStatus.PASS, "Validating error message","Passed as successfully validate error message" + startTest.addScreenCapture(screenshot(tcid, orderid)));
			
		}else{
			startTest.log(LogStatus.FAIL, "Validating error message","Failed as actual was" + Actual + " and expected was " + expected + startTest.addScreenCapture(screenshot(tcid, orderid)));
		} 
		
		
	}	
		
//	Valid Search
	@Test(dataProvider="ValidSearch",dataProviderClass=dataProviders.Dp_Search.class)
	public void ValidSearch(Map Searchdata) throws Exception{
		
		String searchtext = Searchdata.get("Searchtext").toString();
		String expected = Searchdata.get("expected").toString();
		String tcid=Searchdata.get("TCID").toString();
		String orderid=Searchdata.get("order").toString();
		
		
		startTest = extentReports.startTest(btype + "-" +tcid);
		
		if(driver.getTitle().contains("rediff")){
			startTest.log(LogStatus.PASS, "validate title","Passed  Validate title" + startTest.addScreenCapture(screenshot(tcid, orderid)));
		}else{
			startTest.log(LogStatus.FAIL, "validate title","Failed  Validate title as Expected was rediff and actual is " + driver.getTitle()+ " ."  + startTest.addScreenCapture(screenshot(tcid, orderid)));
		}
		
		pf_Homepage Homepage = new pf_Homepage(driver);
		
		Homepage.search_opertaion(searchtext);
		wait(Homepage.msg_searchcount);
		String Actual = Homepage.extract_searchcount();
		
		if(Actual.equals(expected)){
			startTest.log(LogStatus.PASS, "Validating search","Passed as successfully validate error message" + startTest.addScreenCapture(screenshot(tcid, orderid)));
			
		}else{
			startTest.log(LogStatus.FAIL, "Validating search","Failed as actual was" + Actual + " and expected was " + expected + startTest.addScreenCapture(screenshot(tcid, orderid)));
		} 
		
		
	}	
	
	
	
	
	
	}