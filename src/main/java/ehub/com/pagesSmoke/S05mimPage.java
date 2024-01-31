package ehub.com.pagesSmoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import ehub.com.constants.AppConstants;
import ehub.com.pages.CommonLocatorsAndMethod;

public class S05mimPage {
	
	private WebDriver driver;
	CommonLocatorsAndMethod common;

	public S05mimPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		common = new CommonLocatorsAndMethod(driver);
	}

	public void login() {
		common.login(AppConstants.username, AppConstants.password);
	}
	public String searchReportAndOpen(String reportName) {
		String actual=common.searchReportAndOpen(reportName);
		return actual;
	}
	
	public void mimReport() {
		try {
			common.eleUtil.waitForElementVisibleAndToBeClickable(common.PolicyNavigationImage, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
			common.PolicyNavigationImage.click();
			Thread.sleep(5000);
			
			WebElement policyData1=driver.findElement(By.xpath("(//div[@col-id='EntityId' and @role='gridcell'])[1]"));
			Thread.sleep(1000);
			common.eleUtil.waitForElementVisibleAndToBeClickable(policyData1, AppConstants.DEFAULT_LONG_TIME_OUT);
			policyData1.click();
			Thread.sleep(8000);
			
			driver.navigate().back();
			Thread.sleep(5000);
			
		} catch (Exception e) {
			System.out.println("Issue in S05mimPage.mimReport "+e);
		}
	}
	public void mimResult() {
		try {
			common.eleUtil.waitForElementVisibleAndToBeClickable(common.resultNavigationImage, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
			common.resultNavigationImage.click();
			Thread.sleep(5000);
			
			WebElement policyData1=driver.findElement(By.xpath("(//div[@col-id='[RRO].Description' and @role='gridcell'])[1]"));
			Thread.sleep(1000);
			common.jsUtil.clickElementByJS(policyData1);
			Thread.sleep(8000);
			
			common.eleUtil.waitForElementVisibleAndToBeClickable(common.hubNavigation, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
			common.hubNavigation.click();
			Thread.sleep(2000);
			
			common.eleUtil.waitForElementVisibleAndToBeClickable(common.resultNavigationImage, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
			common.resultNavigationImage.click();
			Thread.sleep(2000);
			
			common.eleUtil.waitForElementVisibleAndToBeClickable(common.PolicyNavigationImage, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
			common.PolicyNavigationImage.click();
			Thread.sleep(8000);
			
			WebElement policyData34=driver.findElement(By.xpath("(//div[@col-id='EntityId' and @role='gridcell'])[1]"));
			Thread.sleep(1000);
			policyData34.click();
			Thread.sleep(8000);
			
			driver.navigate().back();
			Thread.sleep(5000);
			
			common.reportNavigationImage.click();
			Thread.sleep(8000);
			
			WebElement policyData99=driver.findElement(By.xpath("(//div[@col-id='[RRP].Description' and @role='gridcell'])[1]"));
			Thread.sleep(1000);
			policyData99.click();
			Thread.sleep(8000);
			
			driver.navigate().back();
			Thread.sleep(5000);
			
			
		} catch (Exception e) {
			System.out.println("Issue in S05mimPage.mimResult "+e);
		}
	}

}
