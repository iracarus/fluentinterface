package com.fluentinterface.baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTestClass {
    public WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void startUpBrowser()
    {
        driver = DriverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        wait = new WebDriverWait(driver, 5);
    }

    @BeforeMethod
    public void goToHome() {
        driver.get("C:\\Java\\Selenium\\fluent\\website\\HomePage.html");
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser()
    {
        driver.close();
    }
}
