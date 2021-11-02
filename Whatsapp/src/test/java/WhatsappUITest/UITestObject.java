package WhatsappUITest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UITestObject {
	
private static WebElement locator = null;
private static List<WebElement> locators = null;
	
	public static WebElement searchBox(WebDriver driver){
		locator = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/label[1]/div[1]/div[2]"));
		return locator;
	}
	
	public static WebElement writeMessage(WebDriver driver){
		locator = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/footer[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]"));
		return locator;
	}
	
	public static WebElement messageStatus(WebDriver driver){
//		locators = driver.findElements(By.xpath("//body[@class='web']/div[@id='app']/div[@class='_1ADa8 _3Nsgw app-wrapper-web os-win']/div[@class='_1XkO3 two']/div[@class='ldL67 _3sh5K']/div[@id='main']/div[@class='_1LcQK']/div[@class='tm2tP copyable-area']/div[@class='_33LGR']/div[@class='y8WcF']/div[20]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]"));
		locator = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[2]/div[3]/div[22]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/*"));
		return locator;
	}

}
//body[@class='web']/div[@id='app']/div[@class='_1ADa8 _3Nsgw app-wrapper-web os-win']/div[@class='_1XkO3 two']/div[@class='ldL67 _3sh5K']/div[@id='main']/div[@class='_1LcQK']/div[@class='tm2tP copyable-area']/div[@class='_33LGR']/div[@class='y8WcF']/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]
//body[@class='web']/div[@id='app']/div[@class='_1ADa8 _3Nsgw app-wrapper-web os-win']/div[@class='_1XkO3 two']/div[@class='ldL67 _3sh5K']/div[@id='main']/div[@class='_1LcQK']/div[@class='tm2tP copyable-area']/div[@class='_33LGR']/div[@class='y8WcF']/div[17]/div[1]/div[1]/div[1]/div[1]/div[1]
//body[@class='web']/div[@id='app']/div[@class='_1ADa8 _3Nsgw app-wrapper-web os-win']/div[@class='_1XkO3 two']/div[@class='ldL67 _3sh5K']/div[@id='main']/div[@class='_1LcQK']/div[@class='tm2tP copyable-area']/div[@class='_33LGR']/div[@class='y8WcF']/div[16]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]
//body[@class='web']/div[@id='app']/div[@class='_1ADa8 _3Nsgw app-wrapper-web os-win']/div[@class='_1XkO3 two']/div[@class='ldL67 _3sh5K']/div[@id='main']/div[@class='_1LcQK']/div[@class='tm2tP copyable-area']/div[@class='_33LGR']/div[@class='y8WcF']/div[17]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]
//body[@class='web']/div[@id='app']/div[@class='_1ADa8 _3Nsgw app-wrapper-web os-win']/div[@class='_1XkO3 two']/div[@class='ldL67 _3sh5K']/div[@id='main']/div[@class='_1LcQK']/div[@class='tm2tP copyable-area']/div[@class='_33LGR']/div[@class='y8WcF']/div[20]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]
