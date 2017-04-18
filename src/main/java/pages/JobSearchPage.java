package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class JobSearchPage extends PageBase {
	@FindBy(name = "JobCategory")
	public WebElement jobCategoryDropdownList;
	
	@FindBy(name = "submit")
	public WebElement searchButton;
	// NEW JOBS FEATURE
	@FindBy(xpath = ".//*[@id='job_title_style']/a")
	public List<WebElement> jobTitleLinkList;
	
	public String processDropdownList(WebElement element) {
		String catagory = randomlySelectFromDropdownList(element);
		// System.out.println( catagory );
		searchButton.click();
		return catagory;
	}
}
