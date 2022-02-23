package com.globalLogic.pages;

import static org.junit.Assert.assertEquals;

public class CategoryPage extends BasicPage {

    public void selectItemNumber(int itemNumbers) {
        findBy(EXPAND_DISPLAY_PER_PAGE_XPATH).click();
        findBy(String.format(INTEGER_OPTION_IN_DROPDOWN_XPATH, itemNumbers)).click();
    }

    public void assertItemNumbers(int expectedItemNumbers) {
        int actualItemsNumbers = findAll(ITEMS_ON_THE_PAGE_XPATH).size();
        assertEquals("Actual number of items is " + actualItemsNumbers, actualItemsNumbers, expectedItemNumbers);
    }

    public void selectSortBy(String sortCondition) {
        findBy(EXPAND_ORDER_BY_XPATH).click();
        findBy(String.format(TEXT_OPTION_IN_DROPDOWN_XPATH, sortCondition)).click();
    }

    public void addToCartTheMostExpensiveItem() {
        findBy(THE_FIRST_EXPENSIVE_ITEM_ON_THE_PAGE_XPATH).click();
    }

    public String getProductName() {
        return findBy(THE_FIRST_EXPENSIVE_ITEM_NAME_XPATH).getText();
    }

    public String getProductPrice() {
        return (findBy(THE_FIRST_EXPENSIVE_ITEM_PRICE_XPATH).getText());
    }

    private static final String EXPAND_DISPLAY_PER_PAGE_XPATH = "//select[@id='products-pagesize']";
    private static final String EXPAND_ORDER_BY_XPATH = "//select[@id='products-orderby']";
    private static final String INTEGER_OPTION_IN_DROPDOWN_XPATH = "//option[text()='%d']";
    private static final String TEXT_OPTION_IN_DROPDOWN_XPATH = "//option[text()='%s']";
    private static final String ITEMS_ON_THE_PAGE_XPATH = "//div[@class='product-grid']/div[@class='item-box']";
    private static final String THE_FIRST_EXPENSIVE_ITEM_ON_THE_PAGE_XPATH = "(//input[@value='Add to cart'])[1]";
    private static final String THE_FIRST_EXPENSIVE_ITEM_NAME_XPATH = "//h2[@class='product-title']";
    private static final String THE_FIRST_EXPENSIVE_ITEM_PRICE_XPATH = "//div[@class='prices']";

}


