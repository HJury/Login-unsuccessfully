package stepDefinitions;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import testRunner.TestRunner;
import util.PropertiesReader;

import java.io.IOException;


public class Hook {
    static public WebDriver driver;

    @Before
    static public void setUp() throws IOException {

        if (TestRunner.browser.equals("chrome")) {
            String path = "";

            //validates if the current machine is a windows machine
            if (System.getProperty("os.name").contains("Windows"))
                path = System.getProperty("user.dir") + new PropertiesReader().getPropoValues("chromeDriverWin");

            //validates if the current machine is a linux machine
            else if (System.getProperty("os.name").contains("Linux"))
                path = System.getProperty("user.dir") + new PropertiesReader().getPropoValues("chromeDriverLin");
            System.setProperty("webdriver.chrome.driver", path);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless",
                    "--disable-gpu",
                    "--window-size=1920,1200",
                    "--ignore-certificate-errors",
                    "--disable-dev-shm-usage",
                    "--no-sandbox",
                    "--remote-debugging-port=9922");

            //In order to make it run headless the parameter "options" should be add exap: new ChromeDriver(options);
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } else if (TestRunner.browser.equals("firefox")) {
            String path = System.getProperty("user.dir") + new PropertiesReader().getPropoValues("firefoxDriver");
            System.setProperty("webdriver.gecko.driver", path);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless",
                    "--disable-gpu",
                    "--window-size=1920,1200",
                    "--ignore-certificate-errors",
                    "--disable-dev-shm-usage",
                    "--no-sandbox",
                    "--remote-debugging-port=9922");

            //In order to make it run headless the parameter "options" should be add exap: new FirefoxDriver()(options);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }


    @After
    static public void quit() {
        driver.quit();
    } //Close the WebDriver instance

}
