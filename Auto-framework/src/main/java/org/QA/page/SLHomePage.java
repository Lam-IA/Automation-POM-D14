package org.QA.page;

import org.QA.base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SLHomePage extends CommonAPI {
    public SLHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='nav-menu']//a[@class='link'][normalize-space()='Contact']")
    WebElement contact;
    @FindBy (xpath = "//div[@class='nav-menu-link-group-row-list-wrapper']//span[contains(text(),'Sauce Community')]")
    WebElement sauceCommunity;

    public String getSLHomePageUrl(WebDriver driver){ //on mets get pour savoir que c'est une récupération qu'on doit faire (return)
        return getPageUrl();
    }
    public void hoverOverContact(WebDriver driver){
        hoverOver(driver,contact);
    }
    public void clickOnSauceCommunity(){
        clickOn(sauceCommunity);
    }
}
