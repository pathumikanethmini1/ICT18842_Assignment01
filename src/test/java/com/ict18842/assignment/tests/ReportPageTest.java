package com.ict18842.assignment.tests;

import com.ict18842.assignment.base.TestBase;
import com.ict18842.assignment.pages.HomePage;
import com.ict18842.assignment.pages.LoginPage;
import com.ict18842.assignment.pages.ReportsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ReportsPage reportsPage;

    public ReportPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        reportsPage = homePage.ClickReports();
    }

    @Test(priority = 1)
    public void validateReportPageDashboardTextTest() {
        boolean isVisible = reportsPage.validateReportPageDashboardText();
        Assert.assertTrue(isVisible, "The Dashboard Text is not visible");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
