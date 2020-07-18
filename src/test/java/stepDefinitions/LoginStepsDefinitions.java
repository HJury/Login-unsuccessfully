package stepDefinitions;

import Tasks.LoginTasks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.JsonReader;

/**
 * This class contains the step definitions use for the feature files
 */
public class LoginStepsDefinitions {
    private LoginTasks loginTasks;
    private String
            invalidCredential = "Invalid Credentials",
            url = "https://app.controlt.com.co/suite/#/login";

    @Given("a user opens a web browser and navigate towards login page")
    public void theUserOpensAWebBrowserAndNavigatesTowardsLoginPage() {
        loginTasks = new LoginTasks(Hook.driver);
        loginTasks.openANewBrowserOn(url);
    }

    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        loginTasks.theUserEntersInvalidCredentials(JsonReader.getInfoPackage(invalidCredential));
    }

    @Then("^a \"(.*?)\" message is shown$")
    public void aCredencialesInvalidasMessageIsShown(String message) {
        loginTasks.waitForTheMessageToShow();
        loginTasks.validateTheMessage(message);
    }
}
