package com.aaa.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeTest {

	WebDriver driver;
	ExtentReports extent;
	
	@BeforeMethod
	public void configuration() {

		//where report is folder name and index  is file name and .html is a extension
		String pathOfProject = System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(pathOfProject);
		reporter.config().setReportName("Amol ");  //name of a Report
		reporter.config().setDocumentTitle("Amol Bramhane"); //title of the page shown on pagename
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		// all data stored in system environment
		extent.setSystemInfo("Operating System", "Windows 10");
		extent.setSystemInfo("Tested by", "AB");
	}

	@Test
	public void testOne() {

		//Test name 
		ExtentTest eTest = extent.createTest("Test One");
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    
	  //lof info with timeStamp --we can put this before every Event done
	    eTest.info("Chrome Browser Launch"); 
	    
		driver.get("https://demowebshop.tricentis.com/");

	}
	
	@AfterMethod
	public void turnDown() {
		
		driver.close();
		extent.flush();  //flush all this things into report and closing the report
		
	}

}
