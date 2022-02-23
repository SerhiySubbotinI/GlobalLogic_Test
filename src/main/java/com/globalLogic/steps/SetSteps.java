package com.globalLogic.steps;
import com.globalLogic.models.Product;
import com.globalLogic.models.Basket;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import static com.globalLogic.utils.Utils.basket;


public class SetSteps extends ScenarioSteps {

    @Step
    public void createBasket() {
        basket = new Basket();
    }

    @Step
    public void assignProduct(Product product) {
        basket.setProduct(product);
    }

    @Step
    public void assignProduct(List <Product> products) {
        basket.setProduct(products);
    }

}