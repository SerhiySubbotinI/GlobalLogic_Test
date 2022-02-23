package com.globalLogic.steps;

import com.globalLogic.pages.ShoppingCartPage;
import net.thucydides.core.annotations.Step;

public class ShoppingCartSteps {

    private ShoppingCartPage shoppingCart;

    @Step
    public void assertThatShoppingCartPageIsOpened() {
        shoppingCart.assertThatShoppingCartPageIsOpened();
    }

    @Step
    public void assertThatItemNameIsPresentInTheCart(String itemName) {
        shoppingCart.assertThatItemNameIsPresentInTheCart(itemName);
    }

    @Step
    public void assertSubtotalAmount(String expectedSubTotalAmount) {
        shoppingCart.assertSubtotalAmount(expectedSubTotalAmount);
    }

    @Step
    public void removeItemFromShoppingCart(String itemName) {
        shoppingCart.removeItemFromShoppingCart(itemName);
    }

    @Step
    public void assertThatShoppingCartIsEmpty() {
        shoppingCart.assertThatShoppingCartIsEmpty();
    }
}
