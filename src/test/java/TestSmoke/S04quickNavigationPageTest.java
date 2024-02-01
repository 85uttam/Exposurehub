package TestSmoke;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ehub.com.baseLibrary.BaseClass;
import ehub.com.constants.AppConstants;
import ehub.com.pagesSmoke.S04quickNavigationPage;
import ehub.com.utils.Excelutility;
import ehub.com.utils.PropertyUtility;

public class S04quickNavigationPageTest extends BaseClass{
	
	S04quickNavigationPage S04page;
	Excelutility excUtil = new Excelutility(System.getProperty("user.dir") + PropertyUtility.getProperty("pathofExcelTestData"));

	@BeforeTest
	public void setupBrowser() {
		initilization();
		S04page = new S04quickNavigationPage(driver);
	}

	@Test(priority = 1, enabled = true)
	public void login() {
		S04page.login();
	}

	@Test(priority = 2, enabled = true)
	public void searchPolicy() {
		String expectedCreatedPolicy=AppConstants.policy_Number+"S01update";
		String actualCreatedPolicy=S04page.searchPolicy(expectedCreatedPolicy);		
		Assert.assertEquals(actualCreatedPolicy, expectedCreatedPolicy);
	}
	
	@Test(priority = 3, enabled = true)
	public void scheduleCyber() {
		String classNameXpath=AppConstants.class_Cyber_Fraction_Value;
		S04page.schedule_1(classNameXpath);
	}
	
	@Test(priority = 4, enabled = true)
	public void scheduleOffshore() {
		String classNameXpath=AppConstants.class_Offshore_Fraction_Value;
		S04page.schedule_2(classNameXpath);
	}
	
	@Test(priority = 5, enabled = true)
	public void scheduleOffshoreRenewables() {
		String classNameXpath=AppConstants.class_Offshore_Renewables_Fraction_Value;
		S04page.schedule_3(classNameXpath);
	}
	
	@Test(priority = 6, enabled = true)
	public void clickOnMap() {
		S04page.clickOnMap();
	}
	
	@Test(priority = 7, enabled = true)
	public void clickOnReport() {
		S04page.clickOnReport();
	}	
	
	@Test(priority = 8, enabled = true)
	public void clickOnResult() {
		S04page.clickOnResult();
	}	
}
