package pages.google.actions;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import pages.google.locators.GoogleSearchPageLocators;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Slf4j
public class GoogleSearchPageActions extends GoogleSearchPageLocators {
    @Step
    public void setValueForInputSearch(String text) {
        inputSearch.sendKeys(text);
        log.info(text);
    }

    @Step
    public void clickSearchButton() {
        for (int i = 0; i < 4; i++) {
            if ($(byXpath(buttonSearch)).isDisplayed()) {
                $(byXpath(buttonSearch)).click();
                break;
            } else if ($(byXpath(buttonSearch + "[2]")).isDisplayed()) {
                $(byXpath(buttonSearch + "[2]")).click();
                break;
            } else {
                sleep(1000);
            }
        }
    }

    @Step
    public void clickAcceptCookies() {
        acceptCookies.click();
    }
}
