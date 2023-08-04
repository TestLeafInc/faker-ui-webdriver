package com.framework.selenium.api.base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigurationManager;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public class DriverInstance  extends AbstractTestNGCucumberTests{

	private static final ThreadLocal<RemoteWebDriver> remoteWebdriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new  ThreadLocal<WebDriverWait>();

	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(30)));
	}

	public WebDriverWait getWait() {
		return wait.get();
	}

	public void setDriver(String browser, boolean headless) throws MalformedURLException {		
	    DesiredCapabilities capabilities = new DesiredCapabilities();

	    switch (browser) {
	        case "chrome":
	            capabilities.setBrowserName("chrome");
	            break;
	        case "firefox":
	            capabilities.setBrowserName("firefox");
	            break;
	        case "msedge":
	            capabilities.setBrowserName("MicrosoftEdge");
	            break;
	        default:
	            break;
	    }
	    remoteWebdriver.set(new RemoteWebDriver(new URL("http://"+ConfigurationManager.configuration().seleniumHub()+":"+ConfigurationManager.configuration().hubPort()+"/wd/hub"), capabilities));
	}
	
	public RemoteWebDriver getDriver() {
		return remoteWebdriver.get();
	}
	
}
