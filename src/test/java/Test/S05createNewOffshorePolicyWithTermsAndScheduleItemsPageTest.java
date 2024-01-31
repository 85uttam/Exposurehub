package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ehub.com.baseLibrary.BaseClass;
import ehub.com.constants.AppConstants;
import ehub.com.pages.S05createNewOffshorePolicyWithTermsAndScheduleItemsPage;

public class S05createNewOffshorePolicyWithTermsAndScheduleItemsPageTest extends BaseClass{	
	
	S05createNewOffshorePolicyWithTermsAndScheduleItemsPage S05page;

	@BeforeTest(groups = { "Smoke", "Sanity", "Regression" })
	public void setupBrowser() {
		initilization();
		S05page = new S05createNewOffshorePolicyWithTermsAndScheduleItemsPage(driver);
	}

	@Test(priority = 1, enabled = true, groups = {"Sanity", "Regression" })
	public void login() {
		S05page.login();
	}
	
	@Test(priority = 2, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void createNewPolicy() {
		String expectedCreatedPolicy=AppConstants.policy_Number+"05";
		String actualCreatedPolicy=S05page.createNewPolicy(expectedCreatedPolicy);		
		Assert.assertEquals(actualCreatedPolicy, expectedCreatedPolicy);
	}
	
	@Test(priority = 3, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void addNewLimitGroup() {
		String ExpectedGroupName=AppConstants.limit_Group_Name+"05";
		String actualGroupName=S05page.addNewLimitGroup(ExpectedGroupName);		
		Assert.assertEquals(actualGroupName, ExpectedGroupName);
	}
	
	@Test(priority = 4, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void addNewLimit() {
		String expected="limit added";
		String actual=S05page.addNewLimit(expected);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 5, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void addCoverage() {
		String expectedCoverageName=AppConstants.coverage_Name+"05";
		String actualCoverageName=S05page.addCoverage(expectedCoverageName);		
		Assert.assertEquals(actualCoverageName, expectedCoverageName);
	}
	
	@Test(priority = 6, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void addSchedule() {
		String expectedMessage="schedule added";
		String actualMessage=S05page.addSchedule(expectedMessage);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

}
