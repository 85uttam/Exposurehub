package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ehub.com.baseLibrary.BaseClass;
import ehub.com.constants.AppConstants;
import ehub.com.pages.S24reportsPage;


public class S24reportsPageTest extends BaseClass{
	
	
	S24reportsPage S24page;

	@BeforeTest(groups = { "Smoke", "Sanity", "Regression" })
	public void setupBrowser() {
		initilization();
		S24page = new S24reportsPage(driver);
	}

	@Test(priority = 1, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void login() {
		S24page.login();
	}	
	
	@Test(priority = 2, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void createNewReport() {
		String expected=AppConstants.report_Name+"24";
		String actual=S24page.createNewReport(expected);
		Assert.assertEquals(actual, expected);
	}
}
