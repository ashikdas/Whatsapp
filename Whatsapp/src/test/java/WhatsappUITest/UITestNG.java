package WhatsappUITest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;


public class UITestNG {
	
	static WebDriver driver = null;

	@BeforeTest
	public static void setup() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://web.whatsapp.com/");
		Thread.sleep(15000);
	}
	@Test
	public void verifySearchNumber() throws Exception{
		
		// File object create & location the xlsx file
		
		File src=new File("D:\\SQA Projects\\QUPS\\Numbers.xlsx");
				
		// File input stream class used for read & write action from the file & pass the file object as a parameter
				
		FileInputStream fis=new FileInputStream(src);
				
		XSSFWorkbook xsf= new XSSFWorkbook(fis);
				
		// Created XSSFSheet sheet object
		// XSSFSheet loads the specific sheet in our workbook at initial value 
				
		XSSFSheet sheet= xsf.getSheetAt(0);
				
		// Get row & get column action
				
		String data =sheet.getRow(0).getCell(0).getStringCellValue();
		
//		System.out.println(new DataFormatter().formatCellValue(sheet.getRow(1).getCell(0)));
		
		String number = new DataFormatter().formatCellValue(sheet.getRow(1).getCell(0));
		
		// Test Case 1
		UITestObject.searchBox(driver).sendKeys(number);
		Thread.sleep(3000);
		
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		// Test Case 2
		UITestObject.writeMessage(driver).sendKeys("Vai");
//		Thread.sleep(3000);
		
		Robot sendKey = new Robot();
		sendKey.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);
//		rb.keyPress(KeyEvent.VK_ENTER);
		
		xsf.close();
		
	}

}
