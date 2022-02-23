package com.globalLogic.jbehave;

import com.globalLogic.models.Product;
import com.globalLogic.steps.ProductSteps;
import com.globalLogic.steps.SetSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.ArrayList;
import java.util.List;

import static com.globalLogic.utils.Utils.basket;

public class ProductTestSteps {

    @Steps
    ProductSteps product;

    @Steps
    SetSteps set;

    @Given("user wants to use product with specific options")
    public void userWantsToUseProduct(@Named("itemName") String itemName,
                                      @Named("itemProcessor") String itemProcessor,
                                      @Named("itemRam") String itemRam,
                                      @Named("itemPrice") String itemPrice) {
        set.createBasket();
        Product product = new Product();
        product.setProductName(itemName);
        product.setProcessor(itemProcessor);
        product.setRam(itemRam);
        product.setProductPrice(itemPrice);
        set.assignProduct(product);
    }

    @Given("user wants to use software: $table")
    public void userWantsToUseSoftware(ExamplesTable table) {
        List<String> softwares = new ArrayList<>();
        for (int row = 0; row < table.getRowsAsParameters().size(); row++) {
            softwares.add(
                    table.getRowAsParameters(row, true).valueAs("software", String.class, null));
        }
        basket.getProduct().setSoftwares(softwares);
    }

    @Given("user is on the product page")
    public void userIsOnTheProductPage() {
        product.openProductPage();
    }

    @When("user selects processor")
    public void userSelectsProcessor() {
        product.selectOptionInRadioButtonField(1, basket.getProduct().getProcessor());
    }

    @When("user selects ram")
    public void userSelectsRam() {
        product.selectOptionInRadioButtonField(2, basket.getProduct().getRam());
    }

    @When("user selects software")
    public void userSelectsSoftware() {
        for (String software : basket.getProduct().getSoftwares()) {
            product.selectSoftwareFromTheList(software);
        }
    }

    @Then("user clicks Add to cart button from the product page")
    public void userClickAddToCartButtonFromProductPage() {
        product.clickAddToCartButtonFromProductPage();
    }

    @Then("user clicks Add to Cart button")
    public void userCLicksAddToCart() {
        product.clickAddToCartButtonFromProductPage();
    }

    @Then("user checks that message $message appears")
    public void userAddsToCartTheMostExpensiveItem(String message) {
        product.assertMessage(message);
    }

    @Then("sub-total amount is calculated")
    public void calculateTotalAmount() {
        double n1 = 0;
        double n2 = 0;
        double n3 = 0;
        double n4 = 0;
        double n5 = 0;

        if (basket.getProduct().getProcessor().equals("Medium")) {
            n1 = 15;
        }
        if (basket.getProduct().getProcessor().equals("Fast")) {
            n1 = 100;
        }
        if (basket.getProduct().getRam().equals("4GB")) {
            n2 = 20;
        }
        if (basket.getProduct().getRam().equals("8GB")) {
            n2 = 60;
        }

        for (String software : basket.getProduct().getSoftwares()) {
            if (software.equals("Image Viewer")) {
                n3 = 5;
            }
            if (software.equals("Office Suite")) {
                n4 = 100;
            }
            if (software.equals("Other Office Suite")) {
                n5 = 40;
            }
        }
        double sum = n1 + n2 + n3 + n4 + n5 + Double.parseDouble(basket.getProduct().getProductPrice());

        basket.setSubTotalAmount(sum);
        System.out.println(sum);
    }

}
