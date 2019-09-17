package com.bs.test;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverHandler {

	WebDriver driver = null;
	DesiredCapabilities capabilities = null;
	
	final String BROWSERSTACK_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
	final String BROWSERSTACK_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
	
	Map<String, String> caps = null;
	String HUB_URL = "https://"+BROWSERSTACK_USERNAME+":"+BROWSERSTACK_ACCESS_KEY+"@hub-cloud.browserstack.com/wd/hub";
	
	public void setup(Map<String, String> caps){
		try {
			
			capabilities = new DesiredCapabilities();
			Iterator itr = caps.entrySet().iterator();
			while(itr.hasNext()){
				Map.Entry<String, String> pair = (Map.Entry<String, String>) itr.next();
				capabilities.setCapability(pair.getKey(), pair.getValue());
			}
			
			driver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterEach
	public void tearDown(){
		if(driver != null){
			driver.quit();
		}
	}

}
