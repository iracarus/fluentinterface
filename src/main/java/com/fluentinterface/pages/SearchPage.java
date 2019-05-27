package com.fluentinterface.pages;

import com.fluentinterface.baseclass.DriverFactory;
import com.fluentinterface.enums.SkillLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.fluentinterface.utils.TestUtils.explicitWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

public class SearchPage {
    WebDriver driver = DriverFactory.getChromeDriver();
    WebDriverWait wait = DriverFactory.getWebDriverWait();

    private SearchPage()
    {
        // hide it
    }

    public static SearchPage getSearchPage()
    {
        return new SearchPage();
    }
    public SearchPage filterBySkillLevel(SkillLevel value){

        driver.findElement(By.xpath("//div[contains(@class, 'search-filter-header') and contains(.,'Skill Levels')]"))
                .click();

        By skillFilter = By.xpath("//span[contains(@class, 'search-filter-option-text') and contains(.,'" + value + "')]");
        wait.until(visibilityOfAllElementsLocatedBy(skillFilter));
        driver.findElement(skillFilter)
                .click();

        explicitWait();
        return this;
    }

    public SearchPage filterByRole(String role){
        driver.findElement(By.xpath("//div[contains(@class, 'search-filter-header') and contains(.,'Roles')]"))
                .click();

        By roleFilter = By.xpath("//span[contains(@class, 'search-filter-option-text') and contains(.,'" + role + "')]");
        wait.until(visibilityOfAllElementsLocatedBy(roleFilter));
        driver.findElement(roleFilter)
                .click();

        explicitWait();
        return this;
    }

    public SearchPage selectTabCourse(){
        driver.findElement(By.xpath("//a[contains(@class, 'tab') and contains(., 'Courses')]"))
                .click();

        return this;
    }

    public void selectCourse(String courseName){
        driver.findElement(By.xpath("//div[@id='search-results-category-target']" +
                "//div[@class='search-result columns' and contains(., '" + courseName + "')]" +
                "//div[@class='search-result__title']/a"))
                .click();
    }
}
