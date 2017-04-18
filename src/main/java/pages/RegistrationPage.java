package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.PageBase;

public class RegistrationPage extends PageBase {

	@FindBy(name = "FirstName")
	public WebElement firstNameField;

	@FindBy(name = "LastName")
	public WebElement lastNameField;

	@FindBy(name = "Gender")
	public WebElement genderDropdownList;

	@FindBy(name = "DateOfBirth")
	public WebElement dateOfBirth;

	@FindBy(name = "PhoneNo")
	public WebElement phoneNoFiled;

	@FindBy(name = "UserType")
	public WebElement userTypeDropdownList;

	@FindBy(name = "Email")
	public WebElement emailField;

	@FindBy(name = "Password")
	public WebElement passwordField;

	@FindBy(name = "ConfirmPassword")
	public WebElement confirmPasswordField;

	@FindBy(name = "Captcha")
	public WebElement captchaField;

	@FindBy(name = "submit")
	public WebElement submitButton;

	@FindBy(id = "error")
	public List<WebElement> errorMessage;

	@FindBy(name = "Privacy")
	public WebElement privacyCheckBox;

	@FindBy(name = "Subscribe")
	public WebElement subscribeCheckBox;

	// WebElement genderDropdownListWebElement =
	// driver.findElement(By.name("Gender"));

	public Object[] error;

	public void firstNameData(String firstName) {
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
		submitButton.click();
	}

	public void lastNameData(String lastName) {
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
		submitButton.click();
	}

	public void processTextField(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
		submitButton.click();
	}
	
	public String processDropdownList(WebElement element) {
		String catagory = randomlySelectFromDropdownList(element);
		System.out.println( catagory );
		submitButton.click();
		return catagory;
	}

}
