package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestRegistrationPage extends TestBase {

	@BeforeClass
	public void classSetUp() {

		menuBar.registerLink.click();
		// http://elitecareer.net/profile
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testFirstNameWithOneChar() {
		registrationPage.processTextField(registrationPage.firstNameField, "A");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(0).getText(),
				"* FirstName can not be less than 2 character.");
	}

	@Test
	public void testFirstNameWithTwoChar() {
		registrationPage.processTextField(registrationPage.firstNameField, "AB");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(0).getText(), "*");

	}

	@Test
	public void testFirstNameWithThirtyChar() {
		registrationPage.processTextField(registrationPage.firstNameField, "MdNizamulHayderChowdhuryTushar");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(0).getText(), "*");

	}

	@Test
	public void testFirstNameWithThirtyOneChar() {
		registrationPage.processTextField(registrationPage.firstNameField, "MdNizamulHayderChowdhuryTushar+1");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(0).getText(),
				"* FirstName can not be greater than 30 character.");

	}

	@Test
	public void testFirstNameWithEmptyField() {
		registrationPage.processTextField(registrationPage.firstNameField, "");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(0).getText(), "* FirstName can not be empty.");

	}

	@Test
	public void testFirstNameWithNumericData() {
		registrationPage.processTextField(registrationPage.firstNameField, "12345");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(0).getText(), "* FirstName can not be Numeric");
		// Test Should be Passed. But found [*]. This Is Bug.
	}

	@Test
	public void testlastNameWithOneChar() {
		registrationPage.processTextField(registrationPage.lastNameField, "A");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(1).getText(),
				"* LastName can not be less than 2 character.");
	}

	@Test
	public void testlastNameWithTwoChar() {
		registrationPage.processTextField(registrationPage.lastNameField, "AB");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(1).getText(), "*");

	}

	@Test
	public void testlastNameWithThirtyChar() {
		registrationPage.processTextField(registrationPage.lastNameField, "MdNizamulHayderChowdhuryTushar");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(1).getText(), "*");

	}

	@Test
	public void testlastNameWithThirtyOneChar() {
		registrationPage.processTextField(registrationPage.lastNameField, "MdNizamulHayderChowdhuryTushar+1");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(1).getText(),
				"* LastName can not be greater than 30 character.");

	}

	@Test
	public void testlastNameWithEmptyField() {
		registrationPage.processTextField(registrationPage.lastNameField, "");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(1).getText(), "* LastName can not be empty.");

	}

	@Test
	public void testlastNameWithNumericData() {
		registrationPage.processTextField(registrationPage.lastNameField, "12345");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(1).getText(), "* LastName can not be Numeric");
		// Test Should be Passed. But found [*]. This Is Bug.

	}

	@Test

	public void testGenderWithRandomOption() {
		registrationPage.processDropdownList(registrationPage.genderDropdownList);
		Assert.assertEquals(registrationPage.errorMessage.get(2).getText(), "*");

	}

	@Test

	public void testGenderWithoutRandomOption() {
		menuBar.registerLink.click();
		registrationPage.submitButton.click();
		Assert.assertEquals(registrationPage.errorMessage.get(2).getText(), "* Gender can not be empty.");
	}

	@Test
	public void testDateOfBirthwithValidCradential() {
		registrationPage.processTextField(registrationPage.dateOfBirth, "1971-03-26");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(3).getText(), "*");
		// Test Should be passed .if you check on chrome it faild. But its found
		// [* Invalid DateOfBirth]. This Is Bug.
	}

	@Test
	public void testDateOfBirthwithInValidCredential() {
		registrationPage.dateOfBirth.sendKeys("2020-03-26");
		registrationPage.submitButton.click();

		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(3).getText(), "* Invalid DateOfBirth");
	}

	@Test
	public void testDateOfBirthWithEmptyField() {
		menuBar.registerLink.click();
		registrationPage.dateOfBirth.sendKeys("");
		registrationPage.submitButton.click();
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(3).getText(), "* DateOfBirth can not be empty.");
	}

	@Test
	public void testPhoneNoWithThreeDigit() {
		registrationPage.processTextField(registrationPage.phoneNoFiled, "347");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(4).getText(), "*");

	}

	@Test
	public void testPhoneNoWithTwoDigit() {
		registrationPage.processTextField(registrationPage.phoneNoFiled, "34");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(4).getText(),
				"* PhoneNo can not be less than 3 character.");

	}

	@Test
	public void testPhoneNoWithThirtyDigit() {
		registrationPage.processTextField(registrationPage.phoneNoFiled, "347123456789012345678901234567");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(4).getText(), "*");

	}

	@Test
	public void testPhoneNoWithThirtyOneDigit() {
		registrationPage.processTextField(registrationPage.phoneNoFiled, "347123456789012345678901234567+");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(4).getText(),
				"* PhoneNo can not be greater than 30 character.");

	}

	@Test
	public void testPhoneNowithEmptyField() {
		registrationPage.processTextField(registrationPage.phoneNoFiled, "");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(4).getText(), "* PhoneNo can not be empty.");

	}

	@Test

	public void testUserTypeWithRandomOption() {
		registrationPage.processDropdownList(registrationPage.userTypeDropdownList);
		Assert.assertEquals(registrationPage.errorMessage.get(5).getText(), "*");
	}

	@Test

	public void testUserTypeWithoutRandomOption() {
		menuBar.registerLink.click();
		registrationPage.submitButton.click();
		Assert.assertEquals(registrationPage.errorMessage.get(5).getText(), "* UserType can not be empty.");
	}

	@Test
	public void testEmailFieldWithValidCredential() {
		registrationPage.processTextField(registrationPage.emailField, "tttushar_831@yahoo.com");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(6).getText(), "*");
	}

	@Test
	public void testEmailFieldWithValidCredentialSameUsedEmail() {
		registrationPage.processTextField(registrationPage.emailField, "shakil_ipe@yahoo.com");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(6).getText(), "* This Email is already registered.");
	}

	@Test
	public void testEmailFieldWithInvalidCredential() {
		registrationPage.processTextField(registrationPage.emailField, "Invalidtushar_831@yahoo");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(6).getText(), "* Invalid Email");
	}

	@Test
	public void testEmailFieldWithEmptyField() {
		registrationPage.processTextField(registrationPage.emailField, "");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(6).getText(), "* Email can not be empty.");
	}

	@Test
	public void testPasswordFieldWithvalidCredential() {
		registrationPage.processTextField(registrationPage.passwordField, "12345678");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(7).getText(), "*");
	}

	@Test
	public void testPasswordFieldWithSixChar() {
		registrationPage.processTextField(registrationPage.passwordField, "123456");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(7).getText(), "*");
	}

	@Test
	public void testPasswordFieldWithFive() {
		registrationPage.processTextField(registrationPage.passwordField, "12345");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(7).getText(),
				"* Password can not be less than 6 character.");
	}

	@Test
	public void testPasswordFieldWithTwentyChar() {
		registrationPage.processTextField(registrationPage.passwordField, "1234567890ABCDEFGHIJ");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(7).getText(), "*");
	}

	@Test
	public void testPasswordFieldWithTwentyONEChar() {
		registrationPage.processTextField(registrationPage.passwordField, "1234567890ABCDEFGHIJ+1");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(7).getText(),
				"* Password can not be greater than 20 character.");
	}

	@Test
	public void testPasswordFieldWithEmpty() {
		registrationPage.processTextField(registrationPage.passwordField, "");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(7).getText(), "* Password can not be empty.");
	}

	@Test
	public void testConfirmPasswordFieldSimilerWithPasswordFieldAndSixChar() {
		registrationPage.passwordField.clear();
		registrationPage.passwordField.sendKeys("123456");
		registrationPage.processTextField(registrationPage.confirmPasswordField, "123456");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(8).getText(), "*");
	}

	@Test
	public void testConfirmPasswordFieldDissimilarWithPasswordField() {
		registrationPage.passwordField.clear();
		registrationPage.passwordField.sendKeys("123456");
		registrationPage.processTextField(registrationPage.confirmPasswordField, "12345");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(8).getText(), "* ConfirmPassword did not match.");
	}

	@Test
	public void testConfirmPasswordWithEmptyField() {
		registrationPage.passwordField.clear();
		registrationPage.passwordField.sendKeys("");
		registrationPage.processTextField(registrationPage.confirmPasswordField, "");
		Assert.assertTrue(registrationPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registrationPage.errorMessage.get(8).getText(), "* ConfirmPassword can not be empty.");
	}

	@AfterClass
	public void classTearDown() {
		menuBar.jobSearchLink.click();

	}
}