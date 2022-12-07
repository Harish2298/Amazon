package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.BaseClassAzamon.BaseClassAz;
import com.amazon.properties.ConfigurationHelper;
import com.amazon.properties.ConfigurationReader;
import com.singleton_design_pattern.Sdp;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/r.harish/eclipse-workspace/Amazon/src/test/java/com/feature/Amazon.feature",
glue="com.stepdefinition",monochrome=true, plugin= {"pretty",
		"html:Report/htmlReport.html",
		"json:Report/jsonreport.json",
		"junit:Report/junitReport.xml",
		//"com.cucumber.listener.ExtentCucumberFormatter:Report/ExtentReport.html"
		}
)

public class AmazonRunner1 extends BaseClassAz {


public static WebDriver driver=null;
		
	@BeforeClass
		public static void setUp() throws IOException {
//		System.setProperty("webdriver.chrome.driver", "/Users/r.harish/eclipse-workspace/DataDriven/chromedriver");
//		 driver = new ChromeDriver();
		String browser = ConfigurationHelper.getInstance().getBrowser();
		driver= browserLaunch(browser);
		//Sdp amazon = new Sdp(driver);// sdp oda object created
		
		//BaseClassAz.browserLaunch("chrome");
	}
		@AfterClass 
		public static void tearDown() {
			//driver.close();
			close();

		}

}
