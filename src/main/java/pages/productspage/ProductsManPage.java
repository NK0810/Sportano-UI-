package pages.productspage;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;

public class ProductsManPage extends BasePage {
    private static final String FIRST_PRODUCT_WISHLIST_BUTTON = ("(//button[@class='product-wishlist action-to-wishlist product-card__image-wishlist'])[3]");
    private static final String Second_PRODUCT_WISHLIST_BUTTON = ("(//button[@class='product-wishlist action-to-wishlist product-card__image-wishlist'])[2]");
    private static final String THIRD_PRODUCT_WISHLIST_BUTTON = ("(//button[@class='product-wishlist action-to-wishlist product-card__image-wishlist'])[1]");
    private static final String FAVORITE_WISHLIST_BUTTON = "//li[@data-bind=\"scope: 'wishlist'\"]";
    private static final String ELEMENTS_IN_FAVORITE_WISHLIST = "//div[@class='product-card product-card--type-default']";
    private static final String FIRST_PRODUCT_DELETE_WISHLIST = "(//i[@class='icon-trash-2--before'])[1]";
    private static final String SECOND_PRODUCT_DELETE_WISHLIST = "(//i[@class='icon-trash-2--before'])[2]";
    private static final String THIRD_PRODUCT_DELETE_WISHLIST = "(//i[@class='icon-trash-2--before'])[3]";
    private static final String MASSAGE_WISHLIST_IS_EMPTY = "//div[@class='message info empty']";

    public ProductsManPage(WebDriver driver) {
        super(driver);
    }

    public ProductsManPage clickFirstProductWishlistButton() {
        waitElementIsClickable(By.xpath(FIRST_PRODUCT_WISHLIST_BUTTON)).click();
        return this;
    }

    public ProductsManPage clickSecondProductWishlistButton() {
        waitElementIsClickable(By.xpath(Second_PRODUCT_WISHLIST_BUTTON)).click();
        return this;
    }

    public ProductsManPage clickThirdProductWishlistButton() {
        waitElementIsClickable(By.xpath(THIRD_PRODUCT_WISHLIST_BUTTON)).click();
        return this;
    }

    public ProductsManPage clickFavoriteWishlistButton() {
        waitElementIsClickable(By.xpath(FAVORITE_WISHLIST_BUTTON)).click();
        return this;
    }

    public List<WebElement> waitVisibleFavoriteWishlistElements() {
        return waitElementsVisible(By.xpath(ELEMENTS_IN_FAVORITE_WISHLIST));
    }

    public ProductsManPage clickFirstDeleteProductWishlist(){
        waitElementIsClickable(By.xpath(FIRST_PRODUCT_DELETE_WISHLIST)).click();
        return  this;
    }

    public ProductsManPage clickSecondDeleteProductWishlist(){
        waitElementIsClickable(By.xpath(SECOND_PRODUCT_DELETE_WISHLIST)).click();
        return this;
    }

    public ProductsManPage clickThirdDeleteProductWishlist(){
        waitElementIsClickable(By.xpath(THIRD_PRODUCT_DELETE_WISHLIST)).click();
        return this;
    }

    public boolean waitMassageWishlistIsEmpty(){
        try {
            waitElementIsVisible(By.xpath(MASSAGE_WISHLIST_IS_EMPTY));
            return true;
        }catch (TimeoutException e){
            System.out.println("Елемент не зявився");
            return false;
        }
    }
}
