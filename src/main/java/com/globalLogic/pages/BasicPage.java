package com.globalLogic.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.temporal.ChronoUnit;

public class BasicPage extends PageObject {

    public static Logger logger = LoggerFactory.getLogger(Serenity.class);

    public void waitForTimeout(int sec) {
        logger.info("Waiting for " + sec + " seconds");
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementNotPresent(String xpath, int implicitTimeoutInSeconds) {
        setImplicitTimeout(implicitTimeoutInSeconds, ChronoUnit.SECONDS);
        boolean isNotPresent = getDriver().findElements(By.xpath(xpath)).size() == 0;
        resetImplicitTimeout();
        return isNotPresent;
    }

    public void moveToElement(String xpath) {
        waitForTimeout(2);
        Actions actions = new Actions(getDriver());
        WebElementFacade element = findBy(xpath);
        actions.moveToElement(element).moveToElement(findBy(xpath)).build().perform();
    }

}
