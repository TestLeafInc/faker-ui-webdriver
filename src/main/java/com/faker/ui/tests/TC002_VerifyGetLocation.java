package com.faker.ui.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.faker.pages.HomePage;
import com.faker.pages.LoginPage;
import com.framework.testng.api.base.ProjectHooks;

public class TC002_VerifyGetLocation extends ProjectHooks{
	@BeforeTest
	public void setValues() {
		testcaseName = "Location API";
		testDescription ="Verify Location API Generates Random Data";
		authors="Babu";
		category ="Smoke";
	}
	
	@Test
	public void runLogin() {
		
		List<String> record1 = 
				new LoginPage()
				.doLogin()
				.selectMenu("Location", "Get Location Details")
				.clickAPI("Get Location")
				.verifyData(Arrays.asList("Country","State","City","Postal Code","Full Address"))
				.getFirstRowRecord();
		
				
		List<String> record2 = 
				new HomePage()
				.clickAPI("Get Location")
				.getFirstRowRecord();
		
		if(isDataSame(record1, record2)) {
			System.out.println("Data Matches and the test failed");
		} else {
			System.out.println("Data fetched is different and test passed");
		}
	}

}
