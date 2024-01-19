package com.bankingexample.testcases;

import com.bankingexample.utilities.CustomLogger;
import com.bankingexample.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    public ReadConfig readConfig = new ReadConfig();
    public String BASE_URL = readConfig.getApplicationURL();
    public String USER_NAME = readConfig.getUserName();
    public String PASSWORD = readConfig.getPassword();
    public WebDriver driver;
    private ChromeOptions options;
    private EdgeOptions edgeOptions;
    public Logger logger;
    public WebDriverWait wait;

    /**
     * This method will execute once developer execute testNG.xml file.
     */
    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {

        // String browser = "chrome";
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        // logger = Logger.getLogger("banking_example");
        logger = CustomLogger.getInstance();
        logger.info("userDir: " + System.getProperty("user.dir"));
        // PropertyConfigurator.configure("log4j.properties");

        logger.info("Browser option: " + browser);
        if (browser.equalsIgnoreCase("chrome")) {
            initializeChromeDriver();
        } else if (browser.equalsIgnoreCase("msedge")) {
            initializeEdgeDriver();
            // Maximize the browser window for Edge
            driver.manage().window().maximize();
        }

        // Maximize the browser window for Chrome as well
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        logger.info("url opened");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    /**
     * To initialize the chrome driver.
     * Check {@link #setUp(String)} method how to set Up browser initialization.
     */
    private void initializeChromeDriver() {

        // Derive Chrome driver destination path
        System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
        // System.setProperty("webdriver.chrome.logfile", "path/to/chromedriver.log");

        options = new ChromeOptions();
        // Allow system to access remotely to perform actions like opening Chrome browser programmatically
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
    }

    /**
     * To initialize the Microsoft Edge driver.
     * Check {@link #setUp(String)} method how to set Up browser initialization.
     */
    private void initializeEdgeDriver() {
        System.setProperty("webdriver.edge.driver", readConfig.getMSEdgePath());
        edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        edgeOptions.setCapability("ignore-certificate-errors", true);
        driver = new EdgeDriver();
    }

    /**
     * This method use to capture screenshot
     *
     * @param driver         WebDriver object required to identify the browser
     * @param screenShotName screenshot name e.g. loginPage,
     */
    public void captureScreen(WebDriver driver, String screenShotName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(readConfig.getScreenShotDirPath() + screenShotName + ".png");
        FileUtils.copyFile(source, target);
        logger.info("screenshot taken");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
