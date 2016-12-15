package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	FileInputStream fis;
	XSSFWorkbook wb;
	
	public ExcelRW(String path) throws Exception{
//		open a input stream
		 fis = new FileInputStream(path);

		//create a workbook object
		 wb = new XSSFWorkbook(fis);		
		
	}
	
	
	
//	initiliaze workbook and FIS
	public void intializeExcel(String path) throws Exception{
//		open a input stream
		 fis = new FileInputStream(path);

		//create a workbook object
		 wb = new XSSFWorkbook(fis);
		
	}
	
	public int rowcount(String Sheetname){
		XSSFSheet sheet = wb.getSheet(Sheetname)	;	
		
		return sheet.getLastRowNum();
		
		
	}
	
	public int columncount(String Sheetname){
		XSSFSheet sheet = wb.getSheet(Sheetname)	;	
		
		return sheet.getRow(0).getLastCellNum()-1;
		
		
	}
	
	public int columncount(String Sheetname,int row){
		XSSFSheet sheet = wb.getSheet(Sheetname)	;	
		
		return sheet.getRow(row).getLastCellNum();
		
		
	}
	
	public String  readcellvalue(String Sheetname,int row,String  colname){
		return null;
	}
	
	public String  readcellvalue(String Sheetname,int row,int col){
		XSSFSheet sheet = wb.getSheet(Sheetname)	;
		XSSFCell cell = sheet.getRow(row).getCell(col);
		String celltext = null;
		  		if(cell.getCellType()==Cell.CELL_TYPE_STRING){
		  			celltext=cell.getStringCellValue();
		  		}else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
		  			
		  			celltext=String.valueOf(cell.getNumericCellValue());
		  		}else if (cell.getCellType()==Cell.CELL_TYPE_BLANK){
		  			
		  			
		  			celltext="";
		  		}
		  		
		  		return celltext;
		
	}
	
	public void writecell(String Sheetname,int row,int col,String val){
		XSSFSheet sheet = wb.getSheet(Sheetname)	;
		sheet.getRow(row).getCell(col).setCellValue(val);
		
	}
	
	public void saveandclose(String xpath) throws Exception{
//		open output stream
		FileOutputStream fos = new FileOutputStream(xpath);
//		 write to stream
		wb.write(fos);
//		close stream
		fos.close();
		fis.close();
		
		
	}
	
	
	

}
