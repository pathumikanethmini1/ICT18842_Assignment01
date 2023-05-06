package com.ict18842.assignment.tests;

import com.ict18842.assignment.base.TestBase;
import com.ict18842.assignment.pages.ApproveTTPage;
import com.ict18842.assignment.pages.HomePage;
import com.ict18842.assignment.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApproveTimeTrackerPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
   ApproveTimeTrackerPage ApproveTimeTrackerPage;

    public ApproveTTPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        approveTTPage = homePage.ClickApproveTimeTrack();
    }

    @Test(priority = 1)
    public void validateTitleTest() {
        String title = approveTimeTrackerPage.validateTitle();
        Assert.assertEquals(title, "actiTIME - Approve Time-Track", "title mis-matched");
    }

    @Test(priority = 2)
    public void acceptTtTest() {
        Assert.assertTrue(approveTimeTrackerPage.acceptTt());
    }

    @Test(priority = 3)
    public void rejectTtTest() {
        Assert.assertTrue(approveTimeTrackerPage.rejectTt());
    }

    /**
     * this method will accept all the tt in the list. so temporarily this method is disabled
     **/
    @Test(enabled = false)
    public void acceptAllttTest() {
        Assert.assertTrue(approveTimeTrackerPage.acceptAlltt());
    }

    /**
     * once acceptAllttTest trigger all the tt data will be deleted.
     * so there is no point to trigger rejectAllttTest() test
     **/
    @Test(enabled = false)
    public void rejectAllttTest() {
        Assert.assertTrue(approveTimeTrackerPage.rejectAlltt());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
