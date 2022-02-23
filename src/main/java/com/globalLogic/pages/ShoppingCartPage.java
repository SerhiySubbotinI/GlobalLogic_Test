package com.globalLogic.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShoppingCartPage extends BasicPage {

    @FindBy(xpath = "//input[@value='Update shopping cart']")
    public WebElementFacade updateShoppingCartButton;

    public void assertThatShoppingCartPageIsOpened() {
        assertFalse("Shopping cart page is not opened", isElementNotPresent(SHOPPING_CART_PAGE_XPATH, 5));
    }

    public void assertThatItemNameIsPresentInTheCart(String itemName) {
        assertTrue("Item '" + itemName + "' is not present in the Shopping cart", findBy(String.format(ITEM_NAME_IN_SHOPPING_CART_XPATH, itemName)).isCurrentlyVisible());
    }

    public void assertSubtotalAmount(String expectedSubTotalAmount) {
        String actualSubTotalAmount = findBy(SUB_TOTAL_AMOUNT_XPATH).waitUntilVisible().getText();
        assertTrue("The expected Sub-Total amount is: '" + expectedSubTotalAmount + "', but is '" + actualSubTotalAmount + "'", actualSubTotalAmount.contains(expectedSubTotalAmount));
    }

    public void removeItemFromShoppingCart(String itemName) {
        findBy(String.format(ITEM_CHECKBOX_XPATH, itemName)).click();
        updateShoppingCartButton.click();
        waitForTimeout(10);
    }

    public void assertThatShoppingCartIsEmpty() {
        assertFalse("Shopping cart page is not empty", isElementNotPresent(EMPTY_SHOPPING_CART_MESSAGE_XPATH, 3));
    }

    private static final String SHOPPING_CART_PAGE_XPATH = "//div[@class='page shopping-cart-page']";
    private static final String ITEM_NAME_IN_SHOPPING_CART_XPATH = "//td[@class='product']/a[text()='%s']";
    private static final String SUB_TOTAL_AMOUNT_XPATH = "//tr[.//span[text()='Sub-Total:']]/td[2]";
    private static final String ITEM_CHECKBOX_XPATH = "//tr[.//a[contains(text(),'%s')]]/td/input[@name='removefromcart']";
    private static final String EMPTY_SHOPPING_CART_MESSAGE_XPATH = "//div[contains(text(),'Your Shopping Cart is empty!')]";
}


