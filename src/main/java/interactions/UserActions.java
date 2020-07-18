package interactions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class will contain all the repetitive actions that should be performance on different pages
 */
public class UserActions {
    WebDriver driver;

    public UserActions(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeys(String text, WebElement element) {
        element.sendKeys(text);
    }

    public WebElement findElementByXpath(String xpath) {
        return this.driver.findElement(By.xpath(xpath));
    }
}
