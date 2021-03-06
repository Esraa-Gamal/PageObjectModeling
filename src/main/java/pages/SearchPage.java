package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy(css= "input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id="ui-id-1")
	List<WebElement> productList;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void productSearch(String prouductName)
	{
		setTextElementText(searchTxtBox, prouductName);
		clickBtn(searchBtn);
	}
	
	public void openProductDetailsPage()
	{
		clickBtn(productTitle);
	}
	
	public void productSearchUsingAutoTest(String searchTxt)
	{
		setTextElementText(searchTxtBox, searchTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productList.get(0).click();
	}
}
