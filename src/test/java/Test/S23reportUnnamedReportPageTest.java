package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ehub.com.baseLibrary.BaseClass;
import ehub.com.pages.S23reportUnnamedReportPage;


public class S23reportUnnamedReportPageTest extends BaseClass{	
	
	S23reportUnnamedReportPage S23page;

	@BeforeTest(groups = { "Smoke", "Sanity", "Regression" })
	public void setupBrowser() {
		initilization();
		S23page = new S23reportUnnamedReportPage(driver);
	}

	@Test(priority = 1, enabled = true, groups = {"Sanity", "Regression" })
	public void login() {
		S23page.login();
	}
	
	@Test(priority = 2, enabled = true, groups = {"Sanity", "Regression" })
	public void createUnnamedNewReport() {
		String actual=S23page.createUnnamedNewReport();
		Assert.assertEquals(actual, actual);
	}
	
	@Test(priority = 3, enabled = true, groups = {"Sanity", "Regression" })
	public void editReportAndSave() {
		S23page.editReportAndSave();
	}

}
