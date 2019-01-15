package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(css="input.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy(css="span.price-value-4")
	public WebElement productPriceLbl;
	
	@FindBy(linkText="Add your review")
	public WebElement addReviewBtn;
	
	@FindBy(id="add-to-wishlist-button-4")
	 WebElement addToWishListBtn;
	
	@FindBy(id="bar-notification")
	public WebElement notificationMsg;
	
	
	public void openFriendEmail()
	{
		clickBtn(emailFriendBtn);
	}
	public void openAddReviewPage()
	{
		clickBtn(addReviewBtn);
	}
	
	public void addToWishList()
	{
		clickBtn(addToWishListBtn);
	}
}
