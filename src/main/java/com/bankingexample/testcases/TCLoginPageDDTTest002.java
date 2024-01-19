package com.bankingexample.testcases;

import com.bankingexample.pageobject.LoginPage;
import com.bankingexample.pageobject.ManagerHomePage;
import com.bankingexample.utilities.MSOfficeUtil;
import com.bankingexample.utilities.ReadConfig;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TCLoginPageDDTTest002 extends BaseClass {
    LoginPage loginPage;
    ReadConfig readConfig = new ReadConfig();
    ManagerHomePage homePage;

    @Test(dataProvider = "guru99LoginData")
    public void loginDDT(Object userName, Object password) throws InterruptedException {

        logger.info("login credential: " + userName + " " + password);
        loginPage = new LoginPage(driver);
        loginPage.enterUserId(userName.toString());
        loginPage.enterPassword(password.toString());
        loginPage.clickLogin();
        Thread.sleep(2000);

        logger.info("alert popup shows:" + isAlertPresent());
        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            logger.warn("login failed");
            Assert.assertTrue(false);

            Thread.sleep(2000);

        } else {

            logger.info("login passed");
            homePage = new ManagerHomePage(driver);
            homePage.clickLogOut();
            wait.until(ExpectedConditions.alertIsPresent());
            if (wait.until(ExpectedConditions.alertIsPresent()) !=null){
                logger.info("alert dismissed");
                driver.switchTo().alert().accept();
                driver.switchTo().defaultContent();
            }
            //Thread.sleep(2000);
            Thread.sleep(1000);
            Assert.assertTrue(true);

        }

    }

    @DataProvider(name = "guru99LoginData")
    public Object[][] getLoginCredentialData() {
        Object[][] testObjArray = null;
        // String filePathTemp = System.getProperty("user.dir") + "/src/main/test_data/login_credentials.xlsx";
        String filePathTemp = readConfig.getLoginCredentialSheetPath();
        String sheetNameTemp = "Sheet1";


        logger.info("excelPath: " + filePathTemp);
        try {
            testObjArray = MSOfficeUtil.getTableArray(filePathTemp, sheetNameTemp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testObjArray;
    }

    public boolean isAlertPresent() {

        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
