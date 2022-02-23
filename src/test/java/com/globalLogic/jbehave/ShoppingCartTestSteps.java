package com.globalLogic.jbehave;

import com.globalLogic.steps.ShoppingCartSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;

import static com.globalLogic.utils.Utils.basket;

public class ShoppingCartTestSteps {

    @Steps
    ShoppingCartSteps shoppingCart;

    @Then("check that item is added to the cart")
    public void checkItemIsAddedToTheCart() {
        shoppingCart.assertThatItemNameIsPresentInTheCart(basket.getProducts().get(0).getProductName());
    }

    @Then("check that actual sub-total amount is correct")
    public void checkSubtotalAmount() {
        shoppingCart.assertSubtotalAmount(String.valueOf(basket.getSubTotalAmount()));
    }

    @Then("user removes item from the shopping cart")
    public void removeItemFromShoppingCart() {
        shoppingCart.removeItemFromShoppingCart(basket.getProduct().getProductName());
    }

    @Then("user checks that shopping cart is empty")
    public void checkShoppingCartIsEmpty() {
        shoppingCart.assertThatShoppingCartIsEmpty();
    }
}
