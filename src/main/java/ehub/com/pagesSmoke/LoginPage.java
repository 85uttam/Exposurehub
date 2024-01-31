package ehub.com.pagesSmoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import ehub.com.utils.ElementUtil;
import ehub.com.utils.JavaScriptUtil;

public class LoginPage {

	//private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	static Logger log = Logger.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	@FindBy(id = "mat-input-0")
	private WebElement username;

	@FindBy(id = "mat-input-1")
	private WebElement password;

	@FindBy(xpath = "//button[contains(.,'LOGIN')]")
	private WebElement login;

	@FindBy(xpath = "//div[@class='logoContainer']/img")
	private WebElement logo;

	@FindBys(@FindBy(xpath = "//div/input[@id='mat-input-0']/parent::div/span/label"))
	private WebElement useridLabel;
	
	@FindBys(@FindBy(xpath = "//div/input[@id='mat-input-1']/parent::div/span/label"))
	private WebElement passwordLabel;
	
	@FindBy(xpath = "(//button[@type='submit']/span)[1]")
	private WebElement loginButtonTextVerify;
	
	@FindBy(xpath = "//div[@class='col-100 poweredBy text-center mt-4']/span")
	private WebElement poweredByTextVerify;
	
	@FindBy(xpath = "//div[@class='col-100 poweredBy text-center mt-4']/img")
	private WebElement footerLogo;
	
	@FindBy(xpath = "//*[@class='top-header-right']//button[1]")
	private WebElement userLoginVerify;
	

	public String verifyLoginURL() {
		log.info("Verify URL");
		return eleUtil.getCurrentURL();

	}

	public String verifyLoginPageTitle() {
		log.info("Verify login page Title");
		return eleUtil.getCurrentTitle();
	}

	public Boolean verifyLogo() {
		log.info("Verify Logo");
		return jsUtil.verifyImage(logo);

	}

	public String verifyUserIdLabel() {
		log.info("Verify User ID Label");
		return useridLabel.getText();
	}
	
	public String verifyPasswordLabel() {
		log.info("Verify Password Label");
		return passwordLabel.getText();
	}
	public String verifyLoginButtonText() {
		log.info("Verify Login Button Text");
		return loginButtonTextVerify.getText();
	}
	public String verifyPoweredByText() {
		log.info("Verify Powered By Text");
		return poweredByTextVerify.getText();
	}
	public Boolean verifyFooterLogo() {
		log.info("Verify Footer Logo");
		return jsUtil.verifyImage(footerLogo);
	}
	public void doLogin(String loginUsername, String loginPassword) {
		try {
			username.clear();
			username.sendKeys(loginUsername);
			log.info("Enter Username : "+loginUsername);
			
			password.clear();
			password.sendKeys(loginPassword);
			log.info("Enter Password : "+loginPassword);
			
			login.click();
			log.info("Clicked on Login");
			
			Thread.sleep(5000);
			
		} catch (Exception e) {
			System.out.println("Issue in LoginPage.doLogin "+e);
		}		
	}
	
	public String verifyUserLogin() {
		log.info("Verify User Login");
		eleUtil.waitForElementVisible(userLoginVerify, 10);
		return userLoginVerify.getText();
		
	}

}
