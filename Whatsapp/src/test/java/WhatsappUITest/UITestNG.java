package WhatsappUITest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
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
		
		File src=new File("D:\\SQA Projects\\QUPS\\Whatsapp\\Numbers.xlsx");
				
		// File input stream class used for read & write action from the file & pass the file object as a parameter
				
		FileInputStream fis=new FileInputStream(src);
				
		XSSFWorkbook xsf= new XSSFWorkbook(fis);
				
		XSSFSheet sheet= xsf.getSheetAt(0);
				
		String data =sheet.getRow(0).getCell(0).getStringCellValue();
		
//		System.out.println(new DataFormatter().formatCellValue(sheet.getRow(1).getCell(0)));
		
		String number = new DataFormatter().formatCellValue(sheet.getRow(1).getCell(0));
		
		// Test Case 1
		UITestObject.searchBox(driver).sendKeys(number);
		Thread.sleep(3000);
		
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		// Test Case 2
		UITestObject.writeMessage(driver).sendKeys("Robot send message");
//		Thread.sleep(3000);
		
		Robot sendKey = new Robot();
		sendKey.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);

		
		// Test Case 3
//		CellBase cell = sheet.getRow(1).createCell(1);
		
		XSSFCell cell = sheet.getRow(1).createCell(1);
		
		cell.setCellValue("Sent");
		
		FileOutputStream outputStream = new FileOutputStream("D:\\SQA Projects\\QUPS\\Whatsapp\\Numbers.xlsx");
		xsf.write(outputStream);
		
		xsf.close();
		
		// Test Case 4
		
		UITestObject.messageStatus(driver).getText();
		
		System.out.println("Output" + UITestObject.messageStatus(driver).getText());
		
		driver.quit();
		
	}

}
