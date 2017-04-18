package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestJobSearchPage extends TestBase {

	@BeforeClass
	public void classSetUp() {

		menuBar.jobSearchLink.click();
		// http://elitecareer.net/profile
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testJobSearchWithoutSelectingJobCategory() {
		jobSearchPage.searchButton.click();

		String resultSummary = jobSearchResultPage.searchResultSummary.getText();

		Assert.assertTrue(jobSearchResultPage.getCurrentUrl().contains("?JobCategory=-Please+Select-&submit=Search"));
		Assert.assertEquals(resultSummary, "Please Select Job Category");

	}

	@Test
	public void testJobSearchWithRandomlySelectedJobCategory() {
		String selectedJobCategory = jobSearchPage.processDropdownList(jobSearchPage.jobCategoryDropdownList);

		String resultSummary = jobSearchResultPage.searchResultSummary.getText();

		int totalJobs = jobSearchPage.getNumFromString(resultSummary);

		if (totalJobs == 0) {
			Assert.assertTrue(jobSearchResultPage.getCurrentUrl().contains("/jobsearch"));
		} else if (totalJobs > 0) {
			// System.out.println("Total Jobs : " +
			// jobSearchPage.jobTitleLinkList.size());
			int maxIndex = jobSearchPage.jobTitleLinkList.size() - 1;
			int randomIndex = jobSearchPage.getRandomNumber(0, maxIndex);
			jobSearchPage.jobTitleLinkList.get(randomIndex).click();

			String jobOverView = jobDetailPage.jobOverView.getText();
			Assert.assertTrue(jobOverView.contains(selectedJobCategory));
		}

	}

	@AfterMethod
	public void classTearDown() {
		menuBar.jobSearchLink.click();

	}
}
