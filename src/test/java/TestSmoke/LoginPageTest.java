package TestSmoke;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ehub.com.baseLibrary.BaseClass;
import ehub.com.constants.AppConstants;
import ehub.com.pages.LoginPage;
import ehub.com.utils.PropertyUtility;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginPage;
	
	@BeforeTest
	public void setupBrowser() {
		initilization();
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyLoginURL() {
		String actualURL=loginPage.verifyLoginURL();
		//String expectedURL=PropertyUtility.getProperty("url");
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
		//Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(priority = 2, enabled = true)
	public void verifyLoginPageTitle() {
		String actualLoginPageTitle=loginPage.verifyLoginPageTitle();
		String expectedLoginPageTitle=AppConstants.LOGIN_PAGE_TITLE_VALUE;
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);		
	}
	
	@Test(priority = 3, enabled = true)
	public void verifyLogoImage() {
		boolean logoImageExist=loginPage.verifyLogo();
		Assert.assertTrue(logoImageExist);		
	}
	
	@Test(priority = 4, enabled = true)
	public void verifyUserIdLabel() {
		String actualUserIdLabel=loginPage.verifyUserIdLabel();
		String expectedUserIdLabel=AppConstants.userID_Label;
		Assert.assertEquals(actualUserIdLabel, expectedUserIdLabel);
	}
	
	@Test(priority = 5, enabled = true)
	public void verifyPasswordLabel() {
		String actualPasswordLabel=loginPage.verifyPasswordLabel();
		String expectedPasswordLabel=AppConstants.password_Label;
		Assert.assertEquals(actualPasswordLabel, expectedPasswordLabel);
	}
	
	@Test(priority = 6, enabled = true)
	public void verifyLoginButtonText() {
		String actualLoginButtonText=loginPage.verifyLoginButtonText();
		String expectedLoginButtonText=AppConstants.login_Button_Text;
		Assert.assertEquals(actualLoginButtonText, expectedLoginButtonText);
	}
	
	@Test(priority = 7, enabled = true)
	public void verifyPoweredByText() {
		String actualPoweredByText=loginPage.verifyPoweredByText();
		String expectedPoweredByText=AppConstants.powered_By_Text;
		Assert.assertEquals(actualPoweredByText, expectedPoweredByText);
	}
	
	@Test(priority = 8, enabled = true)
	public void verifyFooterLogo() {
		boolean logoImageExist=loginPage.verifyFooterLogo();
		Assert.assertTrue(logoImageExist);		
	}
	
	@Test(priority = 9, enabled = true)
	public void doLogin() {
		loginPage.doLogin(AppConstants.username, AppConstants.password);		
	}
		
	@Test(priority = 10, enabled = true)
	public void verifyUserLogin() {
		String actualUserLogin=loginPage.verifyUserLogin();
		String expectedUserLogin=PropertyUtility.getProperty("loginUsername");
		Assert.assertEquals(actualUserLogin, expectedUserLogin);
	}
	

}
