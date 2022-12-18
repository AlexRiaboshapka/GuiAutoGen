package pages.cita.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import org.testng.Assert;
import pages.cita.locators.CitaPreviaLocators;

import static com.codeborne.selenide.Condition.visible;
import static helper.CommonSteps.getAndAttachScreenshot;

public class CitaPreviaActions extends CitaPreviaLocators {
    @Step
    public void selectCitaTypeAndAccept() {
        pageSelectCitaCity.scrollIntoView(true);
        if (pageSelectCitaCity.shouldBe(visible).exists()) {
            citaCitySelection.click();
            acceptButton.scrollIntoView(true);
            citaTypeSelection.click();
            acceptButton.scrollIntoView(true).click();
        }
    }

    @Step
    public void clickEnterButton() {
        if (enterButton.scrollIntoView(true).shouldBe(visible).exists()) {
            enterButton.scrollIntoView(true).click();
        }
    }

    @Step
    public void clickEnterButton2() {
        citaUserName.shouldBe(visible);
        getAndAttachScreenshot();
        if (acceptButton2.scrollIntoView(true).isDisplayed()) {
            acceptButton2.scrollIntoView(true).click();
        }
    }

    @Step
    public void inputNieAndClickAccept(String nie, String name) {
        if (citaNie.isDisplayed()) {
            citaNie.sendKeys(nie);
            citaName.sendKeys(name);
            acceptButton2.click();
            getAndAttachScreenshot();
        }
    }

    @Step
    public void getCitaInfo() {
        salirButton.shouldBe(visible);
        getAndAttachScreenshot();
        if (citaInfo.isDisplayed()) {
            String text = citaInfo.getText();
            Assert.assertTrue(text.contains("En este momento no hay citas disponibles"), "Expected text is not present but present text:\n" + text);
            CustomLogger.logger.info("Cita info: " + text);
        }
        salirButton.click();
    }

}
