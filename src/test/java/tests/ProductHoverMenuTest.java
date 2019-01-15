package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase
{
	HomePage homeObject;
	
	@Test
	public void userCanselectSubGategoryFromMainMenu()
	{
		homeObject= new HomePage(driver);
		homeObject.OpenNoteBooksMenu();
		//Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/notebooks"));
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));

	}
}
