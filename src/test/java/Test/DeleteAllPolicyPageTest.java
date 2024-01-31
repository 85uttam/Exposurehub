package Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ehub.com.baseLibrary.BaseClass;
import ehub.com.constants.AppConstants;
import ehub.com.pages.CommonLocatorsAndMethod;

public class DeleteAllPolicyPageTest extends BaseClass {

	CommonLocatorsAndMethod common;

	@BeforeTest(groups = { "Smoke", "Sanity", "Regression" })
	public void setupBrowser() {
		initilization();
		common = new CommonLocatorsAndMethod(driver);
	}

	@Test(priority = 1, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void login() {
		common.login(AppConstants.username, AppConstants.password);
	}

	@Test(priority = 2, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void policySeach() {
		common.searchPolicyAndOpen(AppConstants.policy_Number + "01");
	}

	@Test(priority = 3, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void searchAndDeletePolicy() {
		String policyNumber = null;
		for (int i = 1; i <= 36; i++) {
			if (i <= 9) {
				policyNumber = AppConstants.policy_Number + "0" + i;
			} else {
				policyNumber = AppConstants.policy_Number + i;
			}
			common.deletePolicyFromPolicyPage(policyNumber);
		}
	}
}
