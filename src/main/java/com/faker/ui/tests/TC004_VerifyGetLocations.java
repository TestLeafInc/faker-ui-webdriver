package com.faker.ui.tests;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.faker.pages.LoginPage;
import com.framework.testng.api.base.ProjectHooks;

public class TC004_VerifyGetLocations extends ProjectHooks{
	@BeforeTest
	public void setValues() {
		testcaseName = "Location API";
		testDescription ="Verify Locations API Generates Random Multiple Data";
		authors="Babu";
		category ="Sanity";
	}

	@Test
	public void runLogin() {
		
        int randomLimit = ThreadLocalRandom.current().nextInt(1, 11);

        new LoginPage()
		.doLogin()
		.selectMenu("Location", "Get Multiple Locations")
		.selectLimit(randomLimit)
		.clickAPI("Get Locations")
		.verifyData(Arrays.asList("Country","State","City","Postal Code","Full Address"))
		.verifyTableSize(randomLimit);
	}

}
