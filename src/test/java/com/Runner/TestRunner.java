package com.Runner;



import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;



@CucumberOptions(
		features="src/test/resources/features",
		glue={"com.StepDefinition"},
				
		 //plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:path/report.html"},
		 plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/Extent-reports/report.html"},
		//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		format=
				{"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/re-run.txt",
				},
				monochrome=true
		)
public class TestRunner {
	
	public static WebDriver driver;
	private static TestNGCucumberRunner testRunner;
	
	@BeforeClass
	public void setUP()
	{
		System.setProperty("webdriver.chrome.driver", "O:/workspace/Cucumber_Maven_TestNG_V2/DriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		testRunner = new TestNGCucumberRunner(TestRunner.class);
		
	}
	@Test(description="login",dataProvider="features")
	public void login(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}
	
	@DataProvider(name="features")
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
	}
	
	/*@AfterClass
	public void tearDown()
	{
		testRunner.finish();
	}*/
	
	
	@AfterClass
	public static void tearDown()
	{
	Reporter.loadXMLConfig(new File("O:/workspace/Cucumber_Maven_TestNG_V2/extent-config.xml"));
	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "AJ");
	Reporter.setSystemInfo("Application Name", "Test App ");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	testRunner.finish();
	
	}
	/* @AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	 }
	*/
	

}
