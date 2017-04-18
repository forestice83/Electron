package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.JobDetailPage;
import pages.JobSearchPage;
import pages.JobSearchResultPage;
import pages.MenuBar;
import pages.RegistrationPage;
import pages.SigninPage;


@Listeners(listener.EliteListener.class)
public class TestBase extends SauceLabs {
	public static MenuBar menuBar;
	public static SigninPage signin;
	public static RegistrationPage registrationPage;
	public static JobSearchPage jobSearchPage;
	public static JobSearchResultPage jobSearchResultPage;
	public static JobDetailPage jobDetailPage;
	

	@BeforeSuite
	public void setUp() {
		

		if (Boolean.valueOf(getProperty("saucelabs"))) {
			setSauceLabs();
		} else {
			setDriver();
		}
		driver.get(getProperty("appUrl"));
		
		
		menuBar = PageFactory.initElements(driver, MenuBar.class);
		signin = PageFactory.initElements(driver, SigninPage.class);
		registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
		jobSearchPage = PageFactory.initElements(driver, JobSearchPage.class);
		jobSearchResultPage = PageFactory.initElements(driver, JobSearchResultPage.class);
		jobDetailPage = PageFactory.initElements(driver, JobDetailPage.class);
	
	}

//	@Test
//	public void sampleInvalidTest() {
//		Assert.assertEquals(driver.getTitle(), "something");
//	}
//
//	@Test
//	public void sampleValidTest() {
//		Assert.assertEquals(driver.getTitle(), "Job Search, Employment and Careers | EliteCareer");
//	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
