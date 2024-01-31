package TestSmoke;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ehub.com.baseLibrary.BaseClass;
import ehub.com.pagesSmoke.S03deletePolicyPage;
import ehub.com.utils.Excelutility;
import ehub.com.utils.PropertyUtility;

public class S03deletePolicyPageTest extends BaseClass{
	
	S03deletePolicyPage S03page;
	Excelutility excUtil = new Excelutility(System.getProperty("user.dir") + PropertyUtility.getProperty("pathofExcelTestData"));

	@BeforeTest(groups = { "Smoke", "Sanity", "Regression" })
	public void setupBrowser() {
		initilization();
		S03page = new S03deletePolicyPage(driver);
	}

	@Test(priority = 1, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void login() {
		S03page.login();
	}
	
	@Test(priority = 2, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void searchPolicy() {
		S03page.searchPolicy();
	}
	
	@Test(priority = 3, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void deletLimit() {
		Boolean actual=S03page.deletLimit();
		Assert.assertTrue(actual);
	}
	
	@Test(priority = 4, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void deleteLimitGroup() {
		Boolean actual=S03page.deleteLimitGroup();
		Assert.assertTrue(actual);
	}
	
	
	@Test(priority = 5, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void deleteScheduleCyber() {
		String message="cyber schedule deleted";
		String actual=S03page.deleteScheduleCyber(message);
		Assert.assertEquals(actual, message);
	}
	
	@Test(priority = 6, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void deleteScheduleOffshore() {
		String message="offshore schedule deleted";
		String actual=S03page.deleteScheduleOffshore(message);
		Assert.assertEquals(actual, message);
	}
	
	
	@Test(priority = 7, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void deleteScheduleOffshoreRenewables() {
		String message="offshore renewables schedule deleted";
		String actual=S03page.deleteScheduleOffshoreRenewables(message);
		Assert.assertEquals(actual, message);
	}
	
	
	@Test(priority = 8, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void deletePolicy() {
		S03page.deletePolicy();
	}

}
