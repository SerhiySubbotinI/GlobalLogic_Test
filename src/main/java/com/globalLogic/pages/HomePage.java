package com.globalLogic.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import static com.globalLogic.utils.Utils.getProperty;

public class HomePage extends BasicPage {

    @FindBy(xpath = "//span[text()='Shopping cart']")
    public WebElementFacade shoppingCartLink;

    public void openHomePage() {
        getDriver().get(getProperty("webdriver.base.url"));
        getDriver().manage().window().maximize();
    }

    public void waitUntilHomePageIsLoaded() {
        findBy(HEADER_MENU_XPATH).waitUntilVisible();
    }

    public void clickShoppingCart() {
        moveToElement(SHOPPING_CART_LINK_XPATH);
        findBy(SHOPPING_CART_LINK_XPATH).waitUntilClickable().click();
    }

    public void selectOptionFromMenu(String option, String menu) {
        moveToElement(String.format(MENU_OPTIONS_IN_HEADER_XPATH, menu));
        findBy(String.format(OPTION_IN_MENU_XPATH, menu, option)).click();
    }

    private static final String HEADER_MENU_XPATH = "//ul[@class='top-menu']";
    private static final String MENU_OPTIONS_IN_HEADER_XPATH = HEADER_MENU_XPATH + "//a[contains(text(),'%s')]";
    private static final String OPTION_IN_MENU_XPATH = MENU_OPTIONS_IN_HEADER_XPATH + "/..//a[contains(text(),'%s')]";
    private static final String SHOPPING_CART_LINK_XPATH = "//span[text()='Shopping cart']";

}

