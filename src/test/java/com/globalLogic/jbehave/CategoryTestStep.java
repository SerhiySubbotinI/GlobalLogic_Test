package com.globalLogic.jbehave;

import com.globalLogic.models.Product;
import com.globalLogic.steps.CategorySteps;
import com.globalLogic.steps.SetSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CategoryTestStep {

    @Steps
    CategorySteps category;

    @Steps
    SetSteps set;

    @When("user sets Display $itemNumbers per page")
    public void userSelectsOptionFromTheMenu(int itemNumbers) {
        category.selectItemNumbers(itemNumbers);
    }

    @When("user checks that only $itemNumbers items are displayed on the page")
    public void userChecksItemsOnThePge(int itemNumbers) {
        category.assertItemNumbers(itemNumbers);
    }

    @Then("user selects Sort by $sortCondition")
    public void userSortsByCondition(String sortCondition) {
        category.selectSortBy(sortCondition);
    }

    @Then("user clicks Add to cart for the most expensive product from the category page")
    public void userAddsToCartTheMostExpensiveItem() {
        set.createBasket();
        Product product = new Product();
        String productName = category.getProductName();
        System.out.println("Product name is: " + productName);
        String productPrice = category.getProductPrice();
        System.out.println("Product price is: " + productPrice);
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        set.assignProduct(product);
        category.clickAddToCartForTheMostExpensiveItemFromCategotyPage();
    }

}
