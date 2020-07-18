package pageObjects;

import interactions.UserActions;
import interactions.Waits;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public class LoginPage {
    WebDriver driver;
    UserActions userActions;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.userActions = new UserActions(driver);
    }

    /**
     * An Enum class to gather all the webElement and its xpaths in order to call them when ever and element is needed
     */
    private enum EnumWebElement {
        INPUT_NOT_FOUND("not found", "WebElement not found"),
        INPUT_USER("User", "//input[@name = 'email']"),
        INPUT_PASSWORD("Password", "//input[@name = 'pass']"),
        LABEL_ERROR_MESSAGE("Message", "//div[contains(@class, 'alert alert')]"),
        BUTTON_ENTER("Enter", "//button[@class = 'login100-form-btn']");

        private String name, xpath;

        /**
         * Enum constructor
         * @param name  The ID used to identify which element is being called
         * @param xpath The string value that is returned when a search is done
         */
        EnumWebElement(String name, String xpath) {
            this.name = name;
            this.xpath = xpath;
        }

        private String getXpath() {
            return this.xpath;
        }

        private String getName() {
            return this.name;
        }

        /**
         * A search of a webElement using the name of the element through a Functional Programming function
         * @param name  The ID used to identify which element is being called
         * @return  an string value corresponding to the @param name or a "Not Found" if the name doesn't exist
         */
        static private String getXpathByWebElementName(String name) {
            return Stream.of(LoginPage.EnumWebElement.values())
                    .filter(x -> x.getName().equals(name))
                    .findFirst()
                    .orElse(INPUT_NOT_FOUND)
                    .getXpath();
        }
    }

    /**
     * Looks for an element using the name and turn it into an webElement
     * @param name The ID used to identify which element is being searched
     * @return A webElement instance
     */
    public WebElement getWebElementByName(String name) {
        return userActions.findElementByXpath(LoginPage.EnumWebElement.getXpathByWebElementName(name));
    }

    /**
     * Search for an element using the name
     * @param name The ID used to identify which element is being searched
     * @return The xpath value of the element corresponding to the name
     */
    public String getWebElementXpathByName(String name) {
        return LoginPage.EnumWebElement.getXpathByWebElementName(name);
    }

    /**
     * It sends a value to a webelement that is got using its name
     * @param value Data that is being sending towards the web element
     * @param field Name of the webElement to which should be sent
     */
    public void sendInformationToTheField(String value, String field) {
        userActions.sendKeys(value, getWebElementByName(field));
    }

    /**
     * Search for a webElement and click it.
     * @param button The name of the webElement that should be search
     */
    public void clickOnButton(String button) {
        getWebElementByName(button).click();
    }

    /**
     * It waits for a webElement that contains the error message to get displayed
     * @param field The name of the element expected to get displayed
     */
    public void waitForTheMessageToShow(String field) {
        Waits.waitUltilIsDisplayedXpath(getWebElementXpathByName(field), driver);
    }

    /**
     * It validates if the message that is shown by the webElement match with the expected
     * @param field  Name of the webElement that contains the message
     * @param message  Expected message
     */
    public void validateTheMessage(String field, String message) {
        Assert.assertTrue(getWebElementByName(field).getText().equals(message));
    }

}
