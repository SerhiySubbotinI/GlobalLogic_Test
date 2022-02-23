package com.globalLogic.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import static com.globalLogic.utils.Utils.getProperty;
import static org.junit.Assert.assertTrue;

public class ProductPage extends BasicPage {

    @FindBy(xpath = "//div[@class='add-to-cart']//input[@value='Add to cart']")
    public WebElementFacade addToCartButton;

    public void openProductPage() {
        getDriver().get(getProperty("webdriver.base.url") + "/build-your-own-expensive-computer-2");
        getDriver().manage().window().maximize();
    }

    public void clickAddToCartButtonFromProductPage() {
        addToCartButton.click();
    }

    public void selectOptionInRadioButtonField(int field, String value) {
        findBy(String.format(VALUE_IN_RADIO_BUTTON_XPATH, field, value)).click();
        waitForTimeout(2);
    }

    public void selectSoftwareFromTheList(String software) {
        findBy(String.format(SOFTWARE_CHECKBOX_XPATH, software)).click();
        waitForTimeout(2);
    }

    public void assertMessage(String expectedMessage) {
        String actualMessage = findBy(MESSAGE_XPATH).waitUntilVisible().getText();
        assertTrue("The message must be '" + expectedMessage + "', but is '" + actualMessage + "'", actualMessage.contains(expectedMessage));
    }

    private static final String VALUE_IN_RADIO_BUTTON_XPATH = "(//div[@class='attributes']/dl//ul)[%d]/li[contains(string(),'%s')]/input";
    private static final String SOFTWARE_CHECKBOX_XPATH = "//li[./label[contains(text(),'%s')]]/input";
    private static final String MESSAGE_XPATH = "//div[@id='bar-notification']/p";

}
