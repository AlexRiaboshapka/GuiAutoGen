package pages.wikipedia.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.wikipedia.locators.WikipediaMainPageLocators;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WikipediaMainPageActions extends WikipediaMainPageLocators {

    @Step
    public void openWikiLanguagePage(String language){
        $(byXpath(languageLocatorTemplate + language + "']")).click();
        CustomLogger.logger.info("Lang code: " + language);
    }
}
