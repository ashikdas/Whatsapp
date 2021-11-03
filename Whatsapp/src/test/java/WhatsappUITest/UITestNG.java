package WhatsappUITest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
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
	@Test (priority=1)
	public void verifySearchNumber() throws Exception{
		
		// File object create & location the xlsx file
		
		File src=new File("D:\\SQA Projects\\QUPS\\Whatsapp\\Numbers.xlsx");
				
		// File input stream class used for read & write action from the file & pass the file object as a parameter
				
		FileInputStream fis=new FileInputStream(src);
				
		XSSFWorkbook xsf= new XSSFWorkbook(fis);
				
		XSSFSheet sheet= xsf.getSheetAt(0);
				
//		String data =sheet.getRow(0).getCell(0).getStringCellValue();
		
//		System.out.println(new DataFormatter().formatCellValue(sheet.getRow(1).getCell(0)));
		
		String number = new DataFormatter().formatCellValue(sheet.getRow(1).getCell(0));
		
		// Test Case 1
		UITestObject.searchBox(driver).sendKeys(number);
		Thread.sleep(3000);
		
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		rb.keyRelease(KeyEvent.VK_ENTER);
		xsf.close();
		
		/*
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
		
		Thread.sleep(5000);
		String result= UITestObject.messageStatus(driver).getAttribute("aria-label");
		
		XSSFCell cell = sheet.getRow(1).createCell(2);
		
		cell.setCellValue(result);
		
		FileOutputStream outputStream = new FileOutputStream("D:\\SQA Projects\\QUPS\\Whatsapp\\Numbers.xlsx");
		xsf.write(outputStream);
		
		xsf.close();
		

		// Test Case 5
		
		UITestObject.menu(driver).click();
		
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_UP);
		rb.keyRelease(KeyEvent.VK_UP);
		
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000); */
		
//		driver.quit();
		
	}
	@Test (priority=2)
	public void verifySendMessage() throws Exception{
		
		UITestObject.writeMessage(driver).sendKeys("Robot send message");
		Thread.sleep(3000);
		
		Robot sendKey = new Robot();
		sendKey.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
	}
	
	@Test (priority=3)
	public void verifySuccessfullySendMessage() throws Exception{
		
		File src=new File("D:\\SQA Projects\\QUPS\\Whatsapp\\Numbers.xlsx");
		
		// File input stream class used for read & write action from the file & pass the file object as a parameter
				
		FileInputStream fis=new FileInputStream(src);
				
		XSSFWorkbook xsf= new XSSFWorkbook(fis);
				
		XSSFSheet sheet= xsf.getSheetAt(0);
		
		XSSFCell cell = sheet.getRow(1).createCell(1);
		
		cell.setCellValue("Sent");
		
		FileOutputStream outputStream = new FileOutputStream("D:\\SQA Projects\\QUPS\\Whatsapp\\Numbers.xlsx");
		xsf.write(outputStream);
		
		xsf.close();
	}
	
	@Test (priority=4)
	public void verifySendMessageStatus() throws Exception{
	
		Thread.sleep(5000);
		File src=new File("D:\\SQA Projects\\QUPS\\Whatsapp\\Numbers.xlsx");
		
		// File input stream class used for read & write action from the file & pass the file object as a parameter
				
		FileInputStream fis=new FileInputStream(src);
				
		XSSFWorkbook xsf= new XSSFWorkbook(fis);
				
		XSSFSheet sheet= xsf.getSheetAt(0);
		
		String result= UITestObject.messageStatus(driver).getAttribute("aria-label");
		
		if (result =="Read"){
			
			result = "seen";
		}
		else{
			result = "not seen";
		}
		
		XSSFCell cell = sheet.getRow(1).createCell(2);
		
		cell.setCellValue(result);
		
		FileOutputStream outputStream = new FileOutputStream("D:\\SQA Projects\\QUPS\\Whatsapp\\Numbers.xlsx");
		xsf.write(outputStream);
		
		xsf.close();
	
	}
	
	@Test (priority=5)
	public void verifyLogout() throws Exception{
		
		UITestObject.menu(driver).click();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_UP);
		rb.keyRelease(KeyEvent.VK_UP);
		
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
	}
	
	@AfterTest
	public static void Teardown()
	{
		driver.close();
		System.out.println("Testing end");
	}

}
