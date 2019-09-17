package com.bs.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.bs.test.ConfigArgs;

public class SingleTest extends WebDriverHandler {
	
	@ParameterizedTest
	@ArgumentsSource(ConfigArgs.class)
	public void Test_Open_Google(String os, String os_version, String browser){
		System.out.println("====> Test_Open_Google :: <=== " + " :: os = " + os + " | os_version=" + os_version + " | browser =" + browser);
		
		caps = new HashMap<String, String>();
		caps.put("project", "Test Run");
		caps.put("build", "JUnit5 Sample");
		caps.put("name", "Test_Open_Google");
		
		caps.put("os", os);
		caps.put("os_version", os_version);
		caps.put("browser", browser);
		setup(caps);
		
		driver.get("http://www.google.com");
	}
	
	@ParameterizedTest
	@ArgumentsSource(ConfigArgs.class)
	public void Test_Open_BrowserStack(String os, String os_version, String browser){
		System.out.println("====> Test_Open_BrowserStack :: <=== " + " :: os = " + os + " | os_version=" + os_version + " | browser =" + browser);
		
		caps = new HashMap<String, String>();
		caps.put("project", "Test Run");
		caps.put("build", "JUnit5 Sample");
		caps.put("name", "Test_Open_BrowserStack");
		
		caps.put("os", os);
		caps.put("os_version", os_version);
		caps.put("browser", browser);
		setup(caps);
		
		driver.get("http://www.browserstack.com");
	}

}
