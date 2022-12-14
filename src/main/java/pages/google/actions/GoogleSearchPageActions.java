package pages.google.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.google.locators.GoogleSearchPageLocators;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class GoogleSearchPageActions extends GoogleSearchPageLocators {
    @Step
    public void setValueForInputSearch(String text) {
        inputSearch.sendKeys(text);
        sleep(500);
        CustomLogger.logger.info(text);
    }

    @Step
    public void clickSearchButton() {
        for (int i = 0; i < 8; i++) {
            if ($(byXpath(buttonSearch)).isDisplayed()) {
                $(byXpath(buttonSearch + "[1]")).click();
                CustomLogger.logger.info("- ok");
                break;
            } else if ($(byXpath(buttonSearch + "[2]")).isDisplayed()) {
                $(byXpath(buttonSearch + "[2]")).click();
                CustomLogger.logger.info("- ok");
                break;
            } else {
                sleep(1000);
            }
        }
    }

    @Step
    public void clickAcceptCookies() {
        if (acceptCookies.isDisplayed()) {
            acceptCookies.click();
        }
    }

}

