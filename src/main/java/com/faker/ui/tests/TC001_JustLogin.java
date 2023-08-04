package com.faker.ui.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.faker.pages.LoginPage;
import com.framework.testng.api.base.ProjectHooks;

public class TC001_JustLogin extends ProjectHooks{
	@BeforeTest
	public void setValues() {
		testcaseName = "Login";
		testDescription ="Login to Faker UI";
		authors="Babu";
		category ="Smoke";
	}
	
	@Test
	public void runLogin() {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.verifyHomePage();

	}

}
