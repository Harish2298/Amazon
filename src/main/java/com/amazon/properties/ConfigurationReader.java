package com.amazon.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	Properties p ;
	public  ConfigurationReader() throws IOException {
	File f = new File("/Users/r.harish/eclipse-workspace/Amazon/src/main/java/com/amazon/properties/amazon.properties");
	FileInputStream fi = new FileInputStream(f);
		 p = new Properties();
		 p.load(fi);
	
	}
	public String getBrowser() {
    String browser=p.getProperty("browser");
    return browser;
 
	}
	 public String getUrl() {
		 String Url=p.getProperty("url");
		 return Url;
	 }
	public String getSheet() {
		String sheet=p.getProperty("sheet");
		return sheet;
	}
	
	
	
	

}
