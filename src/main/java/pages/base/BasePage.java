package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static common.Config.CLOSE_POP_UP_BUTTON;
import static constants.Constant.TimeOutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUrl(String url) {
        driver.get(url);
        try {
            WebElement acceptButton = waitElementIsClickable(By.xpath(CLOSE_POP_UP_BUTTON));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Кукі-поп-ап не знайдено або не клікабельний: " + e.getMessage());
        }
    }

    public WebElement waitElementIsVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitElementIsClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickAcceptButton(){
        try {
            WebElement acceptButton = waitElementIsClickable(By.xpath(CLOSE_POP_UP_BUTTON));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Кукі-поп-ап не знайдено або не клікабельний: " + e.getMessage());
        }
    }

    public List<WebElement> waitElementsVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public List<WebElement> waitUntilElementsUpdated(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);

        List<WebElement> oldElements = driver.findElements(locator);
        wait.until(ExpectedConditions.stalenessOf(oldElements.get(0)));
        return driver.findElements(locator);
    }
}
