package com.globalLogic.steps;

import com.globalLogic.pages.CategoryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CategorySteps extends ScenarioSteps {

    private CategoryPage category;

    @Step
    public void selectItemNumbers(int itemNumbers) {
        category.selectItemNumber(itemNumbers);
    }

    @Step
    public void assertItemNumbers(int itemNumbers) {
        category.assertItemNumbers(itemNumbers);
    }

    @Step
    public void selectSortBy(String sortCondition) {
        category.selectSortBy(sortCondition);
    }

    @Step
    public void clickAddToCartForTheMostExpensiveItemFromCategotyPage() {
        category.addToCartTheMostExpensiveItem();
    }

    @Step
    public String getProductName() {
        return category.getProductName();
    }

    @Step
    public String getProductPrice() {
        return category.getProductPrice();
    }

}
