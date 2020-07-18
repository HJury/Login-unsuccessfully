package Tasks;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import util.JsonReader;


public class LoginTasks {
    private WebDriver driver;
    private LoginPage loginPage;
    private String
            user = "User",
            pass = "Password",
            enter = "Enter",
            message = "Message";

    /**
     *  Constructor
     * @param driver The webDriver instance that comes from the Hook class
     */
    public LoginTasks(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    /**
     * Navigates towards the url that's sent as a parameter
     * @param url   The url to which the browser must navigate
     */
    public void openANewBrowserOn(String url){
        driver.get(url);
    }

    /**
     * Send the credential information that goes into the User and Password field
     * @param jsonObject a JSONObject that contains invalid credential information from dataDrive.json
     */
    public void theUserEntersInvalidCredentials(JSONObject jsonObject){
        loginPage.sendInformationToTheField(JsonReader.getValueFromPackage(jsonObject, user), user);
        loginPage.sendInformationToTheField(JsonReader.getValueFromPackage(jsonObject, pass), pass);
        loginPage.clickOnButton(enter);
    }

    /**
     * It calls the wait for the message about the unsuccessful login to be shown
     */
    public void waitForTheMessageToShow(){
        loginPage.waitForTheMessageToShow(message);
    }

    /**
     * It calls a validation method for the expected message
     * @param message
     */
    public void validateTheMessage(String message){
        loginPage.validateTheMessage(this.message, message);
    }
}
