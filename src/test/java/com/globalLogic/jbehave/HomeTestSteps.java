package com.globalLogic.jbehave;

import com.globalLogic.steps.HomeSteps;
import com.globalLogic.steps.ShoppingCartSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class HomeTestSteps {

    @Steps
    HomeSteps home;

    @Steps
    ShoppingCartSteps shoppingCart;

    @Given("user is on the Home Page")
    public void userIsOnTheHomePage() {
        home.openHomePage();
    }

    @When("user selects $option from the $menu categories menu")
    public void userSelectsOptionFromTheMenu(String option, String menu) {
        home.selectOptionFromMenu(option, menu);
    }

    @Then("user opens Shopping cart page")
    public void userOpensShoppingCart() {
        home.clickShoppingCart();
        shoppingCart.assertThatShoppingCartPageIsOpened();
    }

}
