package com.faker.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectHooks;

import config.ConfigurationManager;

public class LoginPage extends ProjectHooks{
	
	public LoginPage enterUsername() {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='email']"), ConfigurationManager.configuration().appUserName());
		reportStep("The username: "+ ConfigurationManager.configuration().appUserName()+" entered successfully","pass");
		return this;
	}
	
	public LoginPage enterPassword() {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='password']"), ConfigurationManager.configuration().appPassword());
		reportStep("The password: "+ConfigurationManager.configuration().appPassword()+" entered successfully","pass");
		return this;
	}
	 
	public HomePage clickLogin() {
		click(locateElement(Locators.XPATH, "//button[text()='Sign In']"));
		reportStep("Login button clicked successfully", "pass");
		return new HomePage();
	}
	
	public HomePage doLogin() {
		return enterUsername().enterPassword().clickLogin();
	}

}
