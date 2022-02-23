package com.globalLogic.steps;

import com.globalLogic.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomeSteps extends ScenarioSteps {

    private HomePage home;

    @Step
    public void openHomePage() {
        home.openHomePage();
        home.waitUntilHomePageIsLoaded();
    }

    @Step
    public void selectOptionFromMenu(String option, String menu) {
        home.selectOptionFromMenu(option, menu);
    }

    @Step
    public void clickShoppingCart() {
        home.clickShoppingCart();
    }
}
