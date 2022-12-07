package com.singleton_design_pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon_pom.Amazon_Pom;
import com.amazon_pom.SearchProduct;

public class Sdp {
	public WebDriver driver;
	
	public SearchProduct sp;
	public Amazon_Pom apom;
	
	public SearchProduct getSearchProduct() {//creating the object
		
		if(sp==null) {
			sp= new SearchProduct(driver);// refname = new className of particular pom(Driver);
		}
		return sp;
	}
	
	public Amazon_Pom getAmazon_Pom() {
		if(apom==null) {
			apom= new Amazon_Pom (driver);
		}
		return apom;
	}
	
	public Sdp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
