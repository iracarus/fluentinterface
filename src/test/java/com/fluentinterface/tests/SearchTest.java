package com.fluentinterface.tests;

import com.fluentinterface.baseclass.BaseTestClass;
import com.fluentinterface.enums.SkillLevel;
import com.fluentinterface.pages.CoursePage;
import com.fluentinterface.pages.HomePage;
import com.fluentinterface.pages.SearchPage;
import org.testng.annotations.Test;

public class SearchTest extends BaseTestClass {
    HomePage homePage = HomePage.getHomePage();
    SearchPage searchPage = SearchPage.getSearchPage();
    CoursePage coursePage = CoursePage.getCoursePage();

    @Test
    public void basicFilterByTest()
    {
        homePage.search("Java");

        searchPage.filterBySkillLevel(SkillLevel.BEGINNER)
                .filterByRole("Software Development")
                .selectTabCourse()
                .selectCourse("Java Fundamentals: The Java Language");

        coursePage.verifyCoursePreviewIsDisplayed()
                .verifyFreeTrialIsDisplayed();
    }

}
