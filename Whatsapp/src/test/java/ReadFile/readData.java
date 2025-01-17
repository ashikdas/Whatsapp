package ReadFile;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readData {
	
	public static void main(String[] args) throws Exception {
		
		// Dependency section:
		  /* Apache poi dependency:
			https://mvnrepository.com/artifact/org.apache.poi/poi
			Apache POI API Based On OPC and OOXML Schemas:
			https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml */
		
		
		// File object create & location the xlsx file
		
		File src=new File("D:\\SQA Projects\\QUPS\\Numbers.xlsx");
		
		// File input stream class used for read & write action from the file & pass the file object as a parameter
		
		FileInputStream fis=new FileInputStream(src);
		
		// XSSFWorkbook class load the complete excel workbook 
		// XSSFWorkbook class is being used here to work on .xlsx file
		// HSSFWorkbook class is being used here to work on .xls file
		
		XSSFWorkbook xsf= new XSSFWorkbook(fis);
		
		// Created XSSFSheet sheet object
		// XSSFSheet loads the specific sheet in our workbook at initial value 
		
		XSSFSheet sheet= xsf.getSheetAt(0);
		
		// Get row & get column action
		String data =sheet.getRow(0).getCell(0).getStringCellValue();
//		String data2 =sheet.getRow(1).getCell(0).getStringCellValue();
		
		// read the excel value
		System.out.println("The value is : "+data);
		
		// read the excel value
//		System.out.println("The value is : "+data2);
		
		System.out.println(new DataFormatter().formatCellValue(sheet.getRow(1).getCell(0)));
		
		xsf.close();
		
		
		
		

	}

}
