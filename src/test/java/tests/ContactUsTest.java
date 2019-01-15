package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase 
{
	HomePage home;
	ContactUsPage contactPage;

	String fullName="Test User";
	String email="test@test.com";
	String enquiry="Hello, this is for testing";

	@Test
	public void userCanContactUs()
	{
		home= new HomePage(driver);
		home.openConatcUsPage();
		contactPage= new ContactUsPage(driver);
		contactPage.contactUS(fullName, email, enquiry);
		Assert.assertTrue(contactPage.successMsg.getText()
				.contains("Your enquiry has been successfully sent to the store owner"));

	}
}
