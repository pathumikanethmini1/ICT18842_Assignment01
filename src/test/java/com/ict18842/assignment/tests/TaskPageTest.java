package com.ict18842.assignment.tests;

import com.ict18842.assignment.base.TestBase;
import com.ict18842.assignment.pages.HomePage;
import com.ict18842.assignment.pages.LoginPage;
import com.ict18842.assignment.pages.TasksPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TasksPage tasksPage;

    public TaskPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        tasksPage = homePage.ClickTasks();
    }

    @Test(priority = 1)
    public void validateAllcustomersTitleTest() {
        boolean isVisible = tasksPage.validateAllcustomersTitle();
        Assert.assertTrue(isVisible, "Title not visible");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
