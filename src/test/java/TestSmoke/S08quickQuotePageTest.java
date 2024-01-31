package TestSmoke;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ehub.com.baseLibrary.BaseClass;
import ehub.com.pagesSmoke.S08quickQuotePage;
import ehub.com.utils.Excelutility;
import ehub.com.utils.PropertyUtility;

public class S08quickQuotePageTest extends BaseClass{
	
	S08quickQuotePage S08page;
	Excelutility excUtil = new Excelutility(System.getProperty("user.dir") + PropertyUtility.getProperty("pathofExcelTestData"));

	@BeforeTest(groups = { "Smoke", "Sanity", "Regression" })
	public void setupBrowser() {
		initilization();
		S08page = new S08quickQuotePage(driver);
	}

	@Test(priority = 1, enabled = true, groups = { "Smoke", "Sanity", "Regression" })
	public void login() {
		S08page.login();
	}

}
