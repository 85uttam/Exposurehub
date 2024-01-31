package TestSmoke;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ehub.com.baseLibrary.BaseClass;
import ehub.com.constants.AppConstants;
import ehub.com.pagesSmoke.S01createNewPolicyAllClassesPage;
import ehub.com.utils.Excelutility;
import ehub.com.utils.PropertyUtility;

public class S01createNewPolicyAllClassesPageTest extends BaseClass{
	
	 
	S01createNewPolicyAllClassesPage S01page;
	Excelutility excUtil = new Excelutility(System.getProperty("user.dir") + PropertyUtility.getProperty("pathofExcelTestData"));

	@BeforeTest(groups = { "Smoke", "Sanity", "Regression" })
	public void setupBrowser() {
		initilization();
		S01page = new S01createNewPolicyAllClassesPage(driver);
	}

	@Test(priority = 1, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void login() {
		S01page.login();
	}

	@Test(priority = 2, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void createNewPolicy() {
		String expectedCreatedPolicy=AppConstants.policy_Number+"S01";
		String actualCreatedPolicy=S01page.createNewPolicy(expectedCreatedPolicy);		
		Assert.assertEquals(actualCreatedPolicy, expectedCreatedPolicy);
	}
	
	@Test(priority = 3, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void addNewLimitGroup() {
		String ExpectedGroupName=AppConstants.limit_Group_Name+"S01";
		String actualGroupName=S01page.addNewLimitGroup(ExpectedGroupName);		
		Assert.assertEquals(actualGroupName, ExpectedGroupName);
	}
	
	@Test(priority = 4, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void addNewLimit() {
		String expected="limit added";
		String actual=S01page.addNewLimit(expected);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 5, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void addCyberSchedule() {
		String expected="schedule added";
		String actual=S01page.addCyberSchedule(expected);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 6, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void addOffshoreSchedule() {
		String expected="schedule added";
		String actual=S01page.addOffshoreSchedule(expected);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 7, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void addOffshoreRenewablesSchedule() {
		String expected="schedule added";
		String actual=S01page.addOffshoreRenewablesSchedule(expected);
		Assert.assertEquals(actual, expected);
	}

}
