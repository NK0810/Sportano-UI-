package pages.productspage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;

public class ProductsManShoesForSport extends BasePage {
    private static final String SORTING_DROPDOWN_TRIGGER = "//span[@class='button-desktop']";
    private static final String SORTING_PRICE_LOWEST = "//li[@data-value='ua_products_price_default_asc']";
    private static final String PRICE_OF_PRODUCTS = "//div[@class='c-price__current']";

    public ProductsManShoesForSport(WebDriver driver) {
        super(driver);
    }

    public ProductsManShoesForSport clickSortingDropdown() {
        waitElementIsClickable(By.xpath(SORTING_DROPDOWN_TRIGGER)).click();
        return this;
    }

    public ProductsManShoesForSport clickSortingPriceLowest() {
        waitElementIsClickable(By.xpath(SORTING_PRICE_LOWEST)).click();
        return this;
    }

    public ProductsManShoesForSport scrollToPriceElement() {
        WebElement priceElement = waitElementIsVisible(By.xpath(PRICE_OF_PRODUCTS));
        scrollToElement(priceElement);
        return this;
    }

    public List<WebElement> getUpdatedPrices() {
        return waitUntilElementsUpdated(By.xpath(PRICE_OF_PRODUCTS));
    }
}
