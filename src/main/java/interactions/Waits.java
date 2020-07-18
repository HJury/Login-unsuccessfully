package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class will contain all the different waits that will be needed
 */
public class Waits {
    /**
     * An explicit wait that waits for a webElement to get displayed
     * @param xpath The xpath of the web Element that is being waited
     * @param driver  The actual webDriver in which the wait will be perform
     */
    public static void waitUltilIsDisplayedXpath(String xpath, WebDriver driver) {
        try {
            WebDriverWait wait;
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
        } catch (TimeoutException e) {
            System.out.println("The short wait ended and the element: " + xpath + "  didn't get displayed");
        }
    }

}
