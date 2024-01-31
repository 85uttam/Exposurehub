package Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ehub.com.baseLibrary.BaseClass;
import ehub.com.pages.GetClassPerilsCoveragesEntity;
import ehub.com.utils.Excelutility;
import ehub.com.utils.PropertyUtility;

public class GetClassPerilsCoveragesEntityTest extends BaseClass{
	
	GetClassPerilsCoveragesEntity getclassPage;
	Excelutility excUtil = new Excelutility(System.getProperty("user.dir") + PropertyUtility.getProperty("pathofExcelTestData"));

	@BeforeTest(groups = { "Smoke", "Sanity", "Regression" })
	public void setupBrowser() {
		initilization();
		getclassPage = new GetClassPerilsCoveragesEntity(driver);
	}

	@Test(priority = 1, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void login() {
		getclassPage.login();
	}
	
	@Test(priority = 2, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void getClassDetails() {
		getclassPage.getClassDetails();
	}

	@Test(priority = 3, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void getPerilsDetails() {
		getclassPage.getPerilsDetails();
	}

	@Test(priority = 4, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void getCoveragesDetails() {
		getclassPage.getCoveragesDetails();
	}
}
