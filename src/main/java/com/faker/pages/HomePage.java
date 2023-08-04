package com.faker.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectHooks;

public class HomePage extends ProjectHooks{

	public HomePage verifyHomePage() {
		verifyDisplayed(locateElement(Locators.XPATH, "//div[text()='Welcome to home page!']"));
		reportStep("Homepage is loaded successfully", "pass");
		return this;
	}

	public HomePage selectMenu(String menu, String subMenu) {

		click(locateElement(Locators.XPATH,"//li[text()='"+menu+"']"));
		click(locateElement(Locators.XPATH,"//a[text()='"+subMenu+"']"));
		reportStep(subMenu+" is loaded successfully", "pass");
		return this;
	}

	public HomePage clickAPI(String menu) {

		click(locateElement(Locators.XPATH,"//button[text()='"+menu+"']"));
		reportStep(menu+" : button clicked successfully", "pass");
		return this;
	}
	
	public HomePage useCache() {
		WebElement cache = locateElement(Locators.ID,"cacheCheckbox");
		if(!isChecked(cache)) cache.click();
		return this;
	}
	
	public HomePage selectLimit(int count) {
		selectDropDownUsingValue(locateElement(Locators.ID,"limit-select"), ""+count);
		reportStep("Limit : "+count+" selected successfully", "pass");
		return this;
	}

	public HomePage verifyData(List<String> columns) {
		for (String eachColumn : columns) {
			verifyDisplayed(locateElement(Locators.XPATH,"//th[text()='"+eachColumn+"']"));
		}
		return this;
	}


	public List<String> getFirstRowRecord() {
		List<String> firstRow = new ArrayList<>();
		List<WebElement> allFirstRowElements = getDriver().findElements(By.xpath("//table[@class='table']/tbody/tr[1]/td"));
		for (WebElement column : allFirstRowElements) {
			firstRow.add(column.getText());
		}
		return firstRow;
	}
	
	public HomePage verifyTableSize(int count) {
		int rowCount = getDriver().findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		if(rowCount == count)
			reportStep("Row count : "+count+" matches successfully", "pass");
		else
			reportStep("Row count : "+count+" mismatches wih expectation "+rowCount, "warning");

		return this;
	}

	
}
