package com.fluentinterface.pages;

import com.fluentinterface.baseclass.BaseTestClass;
import com.fluentinterface.baseclass.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver = DriverFactory.getChromeDriver();

    private HomePage()
    {
        // hide it
    }

    public static HomePage getHomePage()
    {
        return new HomePage();
    }


    public void search(String value)
    {
        WebElement search = driver.findElement(By.className("header_search--input"));
        search.sendKeys(value);
        search.sendKeys(Keys.ENTER);
    }
}
