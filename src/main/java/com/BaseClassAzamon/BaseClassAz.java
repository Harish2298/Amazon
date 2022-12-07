package com.BaseClassAzamon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClassAz {
	public static WebDriver driver =null;
    public static void sendKeys(WebElement element, String values) {
	element.sendKeys(values);
}
	
	public static void click(WebElement element) {
        element.click();
	}
	public static void clear(WebElement element) {
		element.clear();
	}
	public static void selectvalue(WebElement element, String values) {
		Select p = new Select(element);
		p.selectByValue(values);
	}
	public static void selecttext(WebElement element, String values) {
		Select h = new Select(element);
		h.selectByVisibleText(values);
	}
	public static void selectindex(WebElement element, int values) {
		Select hp = new Select(element);
		hp.selectByIndex(values);
	}
	public static void currentUrl( String values) {
		driver.get(values);
	}
	public static WebDriver browserLaunch(String value) {
		if(value.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/Selinum/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}else if(value.equalsIgnoreCase("edger")) {
			System.setProperty("webdriver.edge.driver", "/Users/r.harish/eclipse-workspace/Selinum/edgedriver");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			
		}else if(value.equalsIgnoreCase("gecko")) {
			System.setProperty("webdriver.gecko.driver", "/Users/r.harish/eclipse-workspace/Selinum/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		return driver;
		
	}
	
	public static void close() {
		driver.close();
	}
	public static void implictwait() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	public static void alert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
//	public static String  text(WebElement element) {
//		return text(null);
//	}
	
	public static void maxi() {
		driver.manage().window().maximize();
	}
	
	
	
	
	
	
	
}
