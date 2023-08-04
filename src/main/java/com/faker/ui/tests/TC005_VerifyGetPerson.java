package com.faker.ui.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.faker.pages.HomePage;
import com.faker.pages.LoginPage;
import com.framework.testng.api.base.ProjectHooks;

public class TC005_VerifyGetPerson extends ProjectHooks{
	@BeforeTest
	public void setValues() {
		testcaseName = "Person API";
		testDescription ="Verify Person API Generates Different Data";
		authors="Babu";
		category ="Sanity";
	}
	
	@Test
	public void runLogin() {
		
		List<String> record1 = 
				new LoginPage()
				.doLogin()
				.selectMenu("Person", "Get Person Details")
				.clickAPI("Get Person")
				.verifyData(Arrays.asList("First Name","Last Name","Email","Address","Date of Birth"))
				.getFirstRowRecord();
		
				
		List<String> record2 = 
				new HomePage()
				.clickAPI("Get Person")
				.getFirstRowRecord();
		
		if(isDataSame(record1, record2)) {
			System.out.println("Data Matches and the test failed");
		} else {
			System.out.println("Data fetched is different and test passed");
		}
	}

}
