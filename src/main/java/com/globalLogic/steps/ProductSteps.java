package com.globalLogic.steps;

import com.globalLogic.pages.ProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ProductSteps extends ScenarioSteps {

    private ProductPage product;

    @Step
    public void clickAddToCartButtonFromProductPage() {
        product.clickAddToCartButtonFromProductPage();
    }

    @Step
    public void openProductPage() {
        product.openProductPage();
    }

    @Step
    public void selectOptionInRadioButtonField(int field, String value) {
        product.selectOptionInRadioButtonField(field, value);
    }

    @Step
    public void selectSoftwareFromTheList(String software) {
        product.selectSoftwareFromTheList(software);
    }

    @Step
    public void assertMessage(String message) {
        product.assertMessage(message);
    }

}
