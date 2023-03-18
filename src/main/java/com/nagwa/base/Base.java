package com.nagwa.base;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static Properties prop = new Properties();

    public Base(){
        try {
            File file = new File("src/main/java/com/nagwa/properties/config.properties");
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lunchBrowser() {

        if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else
        {
            throw new Error("browser not supported");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(prop.getProperty("url"));
    }
}
