package ehub.com.pagesSmoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import ehub.com.constants.AppConstants;
import ehub.com.pages.CommonLocatorsAndMethod;

public class S04quickNavigationPage {
	
	private WebDriver driver;
	CommonLocatorsAndMethod common;
	static Logger log = Logger.getLogger(S04quickNavigationPage.class);

	public S04quickNavigationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		common = new CommonLocatorsAndMethod(driver);
	}

	public void login() {
		common.login(AppConstants.username, AppConstants.password);
	}
	public String searchPolicy(String policyNumber) {
		String actual=common.searchPolicyAndOpen(policyNumber);
		return actual;
	}
	
	public void clickOnTerms() {
		try {
			common.TermsNavigationImage.click();
			log.info("Clicked on Terms Navigation");
			Thread.sleep(2000);			
		} catch (Exception e) {
			System.out.println("Issue in S04quickNavigationPage.clickOnTerms "+e);
		}		
	}
	
	public void schedule_1(String classNameXpath) {
		try {
			WebElement schedule1=driver.findElement(By.xpath("(//span[@class='material-icons'][contains(.,'"+classNameXpath+"')])[1]"));
			schedule1.click();
			log.info("Clicked on Schedule 1");
			Thread.sleep(2000);			
		} catch (Exception e) {
			System.out.println("Issue in S04quickNavigationPage.Schedule_1 "+e);
		}		
	}
	public void schedule_2(String classNameXpath) {
		try {
			WebElement schedule1=driver.findElement(By.xpath("(//span[@class='material-icons'][contains(.,'"+classNameXpath+"')])[1]"));
			schedule1.click();
			log.info("Clicked on Schedule 2");
			Thread.sleep(2000);			
		} catch (Exception e) {
			System.out.println("Issue in S04quickNavigationPage.Schedule_2 "+e);
		}		
	}
	public void schedule_3(String classNameXpath) {
		try {
			WebElement schedule1=driver.findElement(By.xpath("(//span[@class='material-icons'][contains(.,'"+classNameXpath+"')])[1]"));
			schedule1.click();
			log.info("Clicked on Schedule 3");
			Thread.sleep(2000);			
		} catch (Exception e) {
			System.out.println("Issue in S04quickNavigationPage.Schedule_3 "+e);
		}		
	}
	
	public void clickOnMap() {
		try {
			common.mapNavigationImage.click();
			log.info("Clicked on Map Navigation");
			Thread.sleep(2000);	
		} catch (Exception e) {
			System.out.println("Issue in S04quickNavigationPage.clickOnMap "+e);
		}
	}
	public void clickOnReport() {
		try {
			common.reportNavigationImage.click();
			log.info("Clicked on Report Navigation");
			Thread.sleep(2000);	
		} catch (Exception e) {
			System.out.println("Issue in S04quickNavigationPage.clickOnReport "+e);
		}
	}
	public void clickOnResult() {
		try {
			common.resultNavigationImage.click();
			log.info("Clicked on Result Navigation");
			Thread.sleep(2000);	
		} catch (Exception e) {
			System.out.println("Issue in S04quickNavigationPage.clickOnResult "+e);
		}
	}

}
