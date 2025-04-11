package tests.filter;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tests.base.BaseTest;

import java.util.List;
import java.util.stream.Collectors;

import static constants.Constant.Urls.PRODUCTS_MAN_SHOES_SPORT_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckSortPriceProductFromLowestToHighestTest extends BaseTest {
    @Test
    public void checkFilterPrice() {
        basePage.
                goToUrl(PRODUCTS_MAN_SHOES_SPORT_URL);

        productsManShoesForSport
                .clickSortingDropdown()
                .clickSortingPriceLowest()
                .scrollToPriceElement();

        List<WebElement> updatedList = productsManShoesForSport.getUpdatedPrices();

        List<String> priceTexts = updatedList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        System.out.println("Ціни: " + priceTexts);

        boolean isSorted = checkSortedPrice(priceTexts);
        System.out.println("Ціни відсортовані: " + isSorted);

        System.out.println("Ціни: " + priceTexts);

        assertTrue(isSorted);

    }

    public boolean checkSortedPrice(List<String> priceTexts) {
        List<Double> prices = priceTexts.stream()
                .map(text -> text.replaceAll("[^0-9,]", ""))
                .map(text -> text.replace(",", "."))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
