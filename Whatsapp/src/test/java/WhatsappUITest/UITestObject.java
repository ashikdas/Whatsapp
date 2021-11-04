package WhatsappUITest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UITestObject {
	
private static WebElement locator = null;
	
	public static WebElement searchBox(WebDriver driver){
		locator = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/label[1]/div[1]/div[2]"));
		return locator;
	}
	
	public static WebElement writeMessage(WebDriver driver){
		locator = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/footer[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]"));
		return locator;
	}
	
	public static WebElement messageStatus(WebDriver driver){
		locator = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[2]/div[3]/div[last()]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]"));
		return locator;
	}

	public static WebElement menu(WebDriver driver){
		locator = driver.findElement(By.xpath("//span[@data-testid='menu']"));
		return locator;
	}
	
//	public static XSSFWorkbook workBook() throws Exception{
//		File src=new File("D:\\SQA Projects\\QUPS\\Whatsapp\\Numbers.xlsx");
//		
//		// File input stream class used for read & write action from the file & pass the file object as a parameter
//				
//		FileInputStream fis=new FileInputStream(src);
//				
//		XSSFWorkbook xsf= new XSSFWorkbook(fis);
//		
//		return xsf;
//	}
}

