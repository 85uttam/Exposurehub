package ehub.com.baseLibrary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ehub.com.constants.AppConstants;
import ehub.com.utils.Excelutility;
import ehub.com.utils.ExtentManager;
import ehub.com.utils.PropertyUtility;
import ehub.com.utils.TestUtility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	public static ExtentTest test;
	public static WebDriver driver;
	public static ExtentReports extent;	
	
	static Logger log = Logger.getLogger(BaseClass.class);
	public static Excelutility excUtil = new Excelutility(System.getProperty("user.dir") + AppConstants.pathofExcelDataAsPerEnv);
	
	//Before Method
	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.getInstance();
		TestUtility.setdateForLog4j();
	}

	@BeforeTest
	public void beforeTest() {
		test = extent.createTest(getClass().getName());
	}
	
	public void initilization() {
		String browserName=excUtil.getCellData("basicDetails", "Value", 2).trim();
		//String browserName = PropertyUtility.getProperty("browserName").trim();
//		ChromeOptions options = new ChromeOptions();
//		FirefoxOptions optionsFirefox = new FirefoxOptions();
//		EdgeOptions optionsEdge = new EdgeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		optionsFirefox.addArguments("--remote-allow-origins=*");
//		optionsEdge.addArguments("--remote-allow-origins=*");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info(browserName+" : is launched successfully");

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info(browserName+" : is launched successfully");

		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			log.info(browserName+" : is launched successfully");

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info(browserName+" : is launched successfully");
		} else {
			System.out.println("Kindly pass the right browser name.");
			log.info("Kindly pass the right browser name.");
		}

		driver.manage().deleteAllCookies();
		String url=excUtil.getCellData("basicDetails", "Value", 3);
		//driver.get(PropertyUtility.getProperty("url"));
		driver.get(url);
		log.info("Enter URL : "+url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@BeforeMethod
	public void beforeMethod(ITestResult result){		
			log.info(result.getMethod().getMethodName() + " test is Started");
			test.log(Status.INFO, result.getMethod().getMethodName() + " test is Started");			
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			log.info(result.getName() + " test is Failed" + result.getThrowable());
			test.log(Status.FAIL, result.getName() + " test is Failed" + result.getThrowable());
			//String imagePath = getScreenShots(result.getName());
			//test.addScreenCaptureFromPath(imagePath);
			test.fail(result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(getScreenShots(result.getMethod().getMethodName())).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			log.info(result.getName() + " test is pass");
			test.log(Status.PASS, result.getName() + " is Pass");

		} else if (result.getStatus() == ITestResult.SKIP) {
			log.info(result.getName() + " test is skip" + result.getThrowable());
			test.log(Status.SKIP, result.getName() + " test is Skip" + result.getThrowable());
		}
		log.info(result.getName() + " - is Finished.");
		test.log(Status.INFO, result.getName() + " - is Finished.");
		extent.flush();
	}

	public static void logExtentReport(String msg) {
		test.log(Status.INFO, msg);
	}
	
	public static String getScreenShots(String imageName) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destFile = null;

		try {
			destFile = new File(System.getProperty("user.dir") + "\\src\\main\\Resources\\ScreenShots\\" + imageName
					+ "_" + formatter.format(calendar.getTime()) + ".png");
			Files.copy(srcFile.toPath(), destFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destFile.toString();
	}
	
	public static String chooseTestDataForFramework() {
		String excelName = null;
		Excelutility excUtil = new Excelutility(
				System.getProperty("user.dir") + PropertyUtility.getProperty("pathofExcelTestData"));
		String name=excUtil.getCellData("chooseTestDataForFramework", "chooseTestDataForFramework", 2);
		if(name.equals("Test")) {
			excelName="\\src\\test\\resources\\testData\\testDataForTestEnvironment.xlsx";
		}else if(name.equals("Test V2")) {
			excelName="\\src\\test\\resources\\testData\\testDataForTestV2Environment.xlsx";
		}else {
			System.out.println("Kindly pass the right Excel Name");
		}
		return excelName;
	}

	@AfterTest
	public void tearDown() {
		try {
			Thread.sleep(1000);
			//driver.close();
			driver.quit();

		} catch (Exception e) {
			System.out.println("Issue in BaseClass.tearDown " + e);
		}
	}
}
