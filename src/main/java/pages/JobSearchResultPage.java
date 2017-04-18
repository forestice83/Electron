package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class JobSearchResultPage extends PageBase {

	@FindBy(id="application_status_container")
	public WebElement searchResultSummary;
}
