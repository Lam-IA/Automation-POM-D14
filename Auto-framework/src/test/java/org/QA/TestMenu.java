package org.QA;

import org.QA.base.CommonAPI;
import org.QA.page.HomePage;
import org.QA.page.LoginPage;
import org.QA.page.SLCommunityPage;
import org.QA.page.SLHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMenu extends CommonAPI {
    @Test
    public void about(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SLHomePage slHomePage = new SLHomePage(driver);
        SLCommunityPage slCommunityPage = new SLCommunityPage(driver);

        //login
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());

        //click on hamburger menu
        homePage.clickOnHamburgerMenu();

        //validate hamburger menu options
        Assert.assertTrue(homePage.validateAllItemsOptionIsDisplayed());
        Assert.assertTrue(homePage.validateAboutOptionsIsDisplayed());
        Assert.assertTrue(homePage.validateLogoutOptionsIsDisplayed());
        Assert.assertTrue(homePage.validateResetAppStateOptionsIsDisplayed());

        //click on about
        homePage.clickAboutLink();

        //click on saucelab community
        System.out.println(getPageUrl());
        Assert.assertEquals("https://saucelabs.com/", getPageUrl());
        slHomePage.hoverOverContact(driver);
        slHomePage.clickOnSauceCommunity();

        //validate user land on community page
        Assert.assertEquals("Our secret sauce is our people", slCommunityPage.getMainHeaderText());

    }
}
