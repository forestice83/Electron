package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestSigninPage extends TestBase {
	@BeforeClass
	public void classSetUp () {
		menuBar.signinLink.click();
	}
	@Test
	public void testWithValidCredintial() {
		// signin.singin("shakil_ipe@yahoo.com", "365827");
		signin.singin(getProperty("employerEmail"), getProperty("employerPassword") );
		Assert.assertTrue(signin.getCurrentUrl().contains("/profile"));
		
		menuBar.logoutLink.click();
		menuBar.signinLink.click();
	}
	@Test
	public void testWithInvalidEmailAndValidPassword() {
		// signin.singin("Invalidshakil_ipe@yahoo.com", "365827");
		signin.singin("Invalidshakil_ipe@yahoo.com", getProperty("employerPassword") );
		Assert.assertTrue(signin.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signin.errorList.get(0).getText(), "* Email or Password is incorrect.");
		menuBar.signinLink.click();
	}
	@Test
	public void testWithValidEmailAndInvalidPassword() {
		// signin.singin("shakil_ipe@yahoo.com", "Invalid365827");
		signin.singin(getProperty("employerEmail"), "InvalidPassword"  );
		Assert.assertTrue(signin.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signin.errorList.get(0).getText(), "* Email or Password is incorrect.");
		menuBar.signinLink.click();
	}
	@Test
	public void testWithInvalidEmailAndInvalidPassword() {
		// signin.singin("Invalidshakil_ipe@yahoo.com", "Invalid365827");
		signin.singin("Invalidshakil_ipe@yahoo.com", "InvalidPassword"  );
		Assert.assertTrue(signin.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signin.errorList.get(0).getText(), "* Email or Password is incorrect.");
		menuBar.signinLink.click();
	}
	@Test
	public void testWithEmptyEmailAndValidPassword() {
		// signin.singin(" ", "365827");
		signin.singin("", getProperty("employerPassword") ) ;
		Assert.assertTrue(signin.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signin.errorList.get(0).getText(), "* Email can not be empty.");

		menuBar.signinLink.click();
	}
	@Test
	public void testWithValidEmailAndEmptyPassword() {
		// signin.singin("shakil_ipe@yahoo.com", " ");
		signin.singin( getProperty("employerEmail"), "") ;
		Assert.assertTrue(signin.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signin.errorList.get(0).getText(), "* Email or Password is incorrect.");
		Assert.assertEquals(signin.errorList.get(1).getText(), "* Password can not be empty.");

		menuBar.signinLink.click();
	}
	@Test
	public void testWithEmptyEmailAndEmptyPassword() {
		// signin.singin(" ", " ");
		signin.singin( "", "") ;
		Assert.assertTrue(signin.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signin.errorList.get(0).getText(), "* Email can not be empty.");
		Assert.assertEquals(signin.errorList.get(1).getText(), "* Password can not be empty.");

		menuBar.signinLink.click();
	}
	@AfterClass
	public void classTearDown() {
		menuBar.jobSearchLink.click();
		
	}
}
