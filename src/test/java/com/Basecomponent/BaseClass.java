package com.Basecomponent;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utilities.WebUtils;

public class BaseClass extends WebUtils {

	@BeforeSuite()
	public void beforesuite() {
		startReport();

	}

	@BeforeMethod(alwaysRun = true)
	public void before() {
		test = reports.createTest("Test Report");
		browserlaunch(readProperty("browser"));
		implicitWait(15);
		pageLaunch(readProperty("url"));

	}

	@AfterMethod(alwaysRun = true)
	public void aftermethod() {
		browserEnd();
		stopReport();

	}

	@AfterSuite(alwaysRun = true)
	public void aftersuite() {
		stopReport();
	}

}