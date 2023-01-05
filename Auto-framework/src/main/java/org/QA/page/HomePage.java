package org.QA.page;

import org.QA.base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonAPI {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css =".title")
    WebElement productsHeader; //locator
    @FindBy(css=".product_sort_container")
    WebElement filterDropdown; // menu des roulants

    @FindBy(xpath="//div[@class='inventory_item_price']")
    List<WebElement> itemsPrice; // on a utilisé List car ça correspond à 6WebElemets

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement hamburgerMenu;

    @FindBy(xpath = "//a[@id='about_sidebar_link']")
    WebElement aboutLink;

    @FindBy(xpath = "//a[@id='inventory_sidebar_link']")
    WebElement allItemsLink;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement logoutLink;

    @FindBy(xpath = "//a[@id='reset_sidebar_link']")
    WebElement resetAppStateLink;

    public boolean productsHeaderIsDisplayed(){
        System.out.println("products header is displayed");
        return isDisplayed(productsHeader);
    }
    public void selectLowerToHigherFromFilter(){ //cette méthode n'est pas général elle est pour trier les prix  en mode croissant
        selectFromDropdown(filterDropdown, "Price (low to high)");
        System.out.println("price low to high select success");
    }
    public void selectFromFilter(String option){ //on peut donner l'option qu'on veut
        selectFromDropdown(filterDropdown, option);
        System.out.println(option + "select success");
    }
    public List<String> getItemsPrice() {
        List<String> prices = new ArrayList<String>();
        for (WebElement itemPrice : itemsPrice) {
            prices.add(itemPrice.getText().replace("$", ""));
        }
        return prices;
    }
    public boolean validateAllItemsOptionIsDisplayed(){
        boolean flag = isDisplayed (allItemsLink);
        System.out.println("all items link display success");
        return flag;
    }
    public boolean validateAboutOptionsIsDisplayed(){
        boolean flag = isDisplayed (aboutLink);
        System.out.println("about link display success");
        return flag;
    }
    public boolean validateLogoutOptionsIsDisplayed(){
        boolean flag = isDisplayed (logoutLink);
        System.out.println("logout link display success");
        return flag;
    }
    public boolean validateResetAppStateOptionsIsDisplayed(){
        boolean flag = isDisplayed (resetAppStateLink);
        System.out.println("reset app state link display success");
        return flag;
    }

    public void clickOnHamburgerMenu (){
        clickOn(hamburgerMenu);
        System.out.println("click on hamburger menu success");
    }
    public void clickAboutLink (){
        clickOn(aboutLink);
        System.out.println("click on about link success");
    }
}
//pom est un concept incontournable

