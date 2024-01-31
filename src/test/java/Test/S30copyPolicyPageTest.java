package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ehub.com.baseLibrary.BaseClass;
import ehub.com.constants.AppConstants;
import ehub.com.pages.S30copyPolicyPage;

public class S30copyPolicyPageTest extends BaseClass{
	
	
	S30copyPolicyPage S30page;

	@BeforeTest(groups = { "Smoke", "Sanity", "Regression" })
	public void setupBrowser() {
		initilization();
		S30page = new S30copyPolicyPage(driver);
	}

	@Test(priority = 1, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void login() {
		S30page.login();
	}
	
	@Test(priority = 2, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void createNewPolicy() {
		String expectedPolicyNumber=AppConstants.policy_Number+"30";
		String actual=S30page.createNewPolicy(expectedPolicyNumber);
		Assert.assertEquals(actual, expectedPolicyNumber);
	}	
	
	@Test(priority = 3, enabled = true, groups = {"Smoke", "Sanity", "Regression" })
	public void copyNewPolicy() {
		String expected=AppConstants.policy_Number+"30copy";
		String actual=S30page.copyNewPolicy(expected);
		Assert.assertEquals(actual, expected);
	}
}
