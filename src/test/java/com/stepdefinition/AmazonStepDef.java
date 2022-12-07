package com.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Alldataamazon.Amazonalldata;
import com.Amazon.Amazon;
import com.BaseClassAzamon.BaseClassAz;
import com.amazon.properties.ConfigurationHelper;
import com.amazon_pom.Amazon_Pom;
import com.runner.AmazonRunner1;
import com.singleton_design_pattern.Sdp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonStepDef extends BaseClassAz {
	public static WebDriver driver = AmazonRunner1.driver;
	int results;
	
    Sdp amazon = new Sdp(driver);
    
	@Given("^user Launch The Application$")
	public void user_Launch_The_Application() throws Throwable {
//		driver.get("https://www.amazon.in/");
//		driver.manage().window().maximize();
		String url = ConfigurationHelper.getInstance().getUrl();
		//currentUrl("https://www.amazon.in/");
	   currentUrl(url);
		
	}

	@When("^user Select The Drop Down$")
	public void user_Select_The_Drop_Down() throws Throwable {
		implictwait();
		Thread.sleep(3000);
		//WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		String sheet = ConfigurationHelper.getInstance().getSheet();
		//String expected = Amazonalldata.allData("Amazon", 1, 0);--> dataDriven
		String expected = Amazonalldata.allData(sheet , 1, 0);//--->properties
		//String expected = "Books";
	    //Select s = new Select(pom.getDropDown());
		Select s = new Select(amazon.getSearchProduct().getDropDown());
		Thread.sleep(3000);
		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			 String dDown = option.getText();
			if (expected.equalsIgnoreCase(dDown)) {	
			 s.selectByVisibleText(expected);
			} else {
				continue;
			}

		}
	}

	@When("^user Enter Product In Searchbox$")
	public void user_Enter_Product_In_Searchbox() throws Throwable {
		Thread.sleep(3000);
		//WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
	//	String value = Amazonalldata.allData("Amazon", 2, 1);
		String sheet = ConfigurationHelper.getInstance().getSheet();//--> property file (key= sheet)
		String value = Amazonalldata.allData(sheet, 2, 1);
		//String value = "ikigai";
		// search.sendKeys(value);
		//sendKeys(pom.getSearch(), value);
		sendKeys(amazon.getSearchProduct().getSearch(),value);
	}

	@And("^user Click The Search Option$")
	public void user_Click_The_Search_Option() throws Throwable {
		Thread.sleep(2000);
		//WebElement searchOption = driver.findElement(By.xpath("(//div[@class='s-suggestion-container'])[3]"));
		// .click();
	    //click(searchOption);
	//click(pom.getSearchOption());
		click(amazon.getAmazon_Pom().getSearchOption());
	}

	@Then("^user Get Text All Search Items$")
	public void user_Get_Text_All_Search_Items() throws Throwable {
		//List<WebElement> results = driver
		//		.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		//for (WebElement result : pom.getResults()) {
		for(WebElement result: amazon.getAmazon_Pom().getResults()) {
			String text = result.getText();
			//String text = text(result);
		}
		//System.out.println("The Total count is" + "=" + pom.getResults().size());
		System.out.println("The Total count is" + "=" + amazon.getAmazon_Pom().getResults().size());
	}

	@Then("^user Match With The Text$")
	public void user_Match_With_The_Text() throws Throwable {

		Thread.sleep(2000);

	}

}
