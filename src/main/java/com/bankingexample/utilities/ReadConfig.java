package com.bankingexample.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class use to read static information from the properties file
 */
public class ReadConfig {

    private Properties properties;

    public ReadConfig() {

        File src = new File("./configuration/config.properties");

        try {
            FileInputStream inputStream = new FileInputStream(src);
            properties = new Properties();
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    public String getApplicationURL() {
        return properties.getProperty("base_url");
    }

    public String getUserName() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getChromePath() {
        return properties.getProperty("chrome_path");
    }

    public String getMSEdgePath() {
        return properties.getProperty("msedge_path");
    }

    public String getLoginCredentialSheetPath() {
        return properties.getProperty("login_credential_sheet_path");
    }

    public String getScreenShotDirPath() {
        return properties.getProperty("screenshot_dir_path");
    }

    public String getCustomerName() {
        return properties.getProperty("customerName");
    }

    public String getAddress() {
        return properties.getProperty("address");
    }

    public String getCity() {
        return properties.getProperty("city");
    }

    public String getState() {
        return properties.getProperty("state");
    }

    public String getPIN() {
        return properties.getProperty("pin");
    }

    public String getMobileNo() {
        return properties.getProperty("mobile_no");
    }

    public String getEmailAddress() {
        return properties.getProperty("login_credential_sheet_path");
    }

    public String getCommonPassword() {
        return properties.getProperty("common_password");
    }

    public String getYear() {
        return properties.getProperty("year");
    }

    public String getMonth() {
        return properties.getProperty("month");
    }

    public String getDay() {
        return properties.getProperty("day");
    }

}
