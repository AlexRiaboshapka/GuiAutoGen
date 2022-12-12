package pages.google.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GoogleSearchPageLocators {
    public final SelenideElement inputSearch = $(byXpath("//input[@name='q']"));
    public final SelenideElement acceptCookies = $(byXpath("//button[@id='L2AGLb']"));
    public final String buttonSearch = "(//input[@name='btnK'])";
}
