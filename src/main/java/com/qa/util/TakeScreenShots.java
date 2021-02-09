package com.qa.util;

import com.qa.factory.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShots {
    public static void takeScreenShot() {
        WebDriver driver = Driver.getDriver();
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path =System.getProperty("user.dir");
        try {
            FileUtils.copyFile(screen, new File(path + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
