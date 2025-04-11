package tests.favorite;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tests.base.BaseTest;

import java.util.List;

import static constants.Constant.Urls.PRODUCTS_MAN_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckAddAndDeleteProductInFavoriteWishlistTest extends BaseTest {

    @Test
    public void checkAddFavorite() {
        basePage
                .goToUrl(PRODUCTS_MAN_URL);

        productsManPage
                .clickFirstProductWishlistButton()
                .clickSecondProductWishlistButton()
                .clickThirdProductWishlistButton()
                .clickFavoriteWishlistButton();

        basePage
                .clickAcceptButton();

        List<WebElement> productsCards = productsManPage.waitVisibleFavoriteWishlistElements();

        assertEquals(3, productsCards.size(), "Кількість елементів не дорівнює 3");

        productsManPage
                .clickThirdDeleteProductWishlist()
                .clickSecondDeleteProductWishlist()
                .clickFirstDeleteProductWishlist();

        assertTrue(productsManPage.waitMassageWishlistIsEmpty());
    }
}
