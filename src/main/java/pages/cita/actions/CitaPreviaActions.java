package pages.cita.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import org.testng.Assert;
import pages.cita.locators.CitaPreviaLocators;

import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static helper.CommonSteps.getAndAttachScreenshot;

public class CitaPreviaActions extends CitaPreviaLocators {
    public static int sleepResult;

    public void createRandomSleep() {
        Random r = new Random();
        int low = 2000;
        int high = 3000;
        sleepResult = r.nextInt(high - low) + low;
        CustomLogger.logger.info("sleepResult: " + sleepResult);
    }

    @Step
    public void clickAccept() {
        createRandomSleep();
        sleep(sleepResult);
        if (acceptButtonBefore.shouldBe(visible).exists()) {
            acceptButtonBefore.click();
        }
    }

    @Step
    public void selectRegionAndAccept() {
        sleep(sleepResult);
        provinceSelection.shouldBe(visible).click();
        sleep(sleepResult);
        acceptButton.click();
    }

    @Step
    public void selectCitaTypeAndAccept() {
        sleep(sleepResult);
        if (citaRegionSelection.shouldBe(visible).exists()) {
            citaRegionSelection.click();
            sleep(sleepResult);
            citaTypeSelection.click();
            sleep(sleepResult);
            acceptButton.scrollIntoView(true).click();
        }
    }

    @Step
    public void clickEnterButton() {
        sleep(sleepResult);
        if (enterButton.scrollIntoView(true).isDisplayed()) {
            enterButton.scrollIntoView(true).click();
        }
    }

    @Step
    public void clickEnterButton2() {
        sleep(sleepResult);
        getAndAttachScreenshot();
        if (acceptButton2.scrollIntoView(true).isDisplayed()) {
            acceptButton2.scrollIntoView(true).click();
        }
    }

    @Step
    public void inputNieAndClickAccept(String nie, String name) {
        sleep(sleepResult);
        if (citaNie.isDisplayed()) {
            citaNie.sendKeys(nie);
            sleep(sleepResult);
            citaName.sendKeys(name);
            sleep(sleepResult);
            acceptButton2.click();
            getAndAttachScreenshot();
        }
    }

    @Step
    public void getCitaInfo() {
        sleep(sleepResult);
        getAndAttachScreenshot();
        if (citaInfo.isDisplayed()) {
            String text = citaInfo.getText();
            Assert.assertTrue(text.contains("En este momento no hay citas disponibles"), "Expected text is not present but present text:\n" + text);
            CustomLogger.logger.info("Cita info: " + text);
        }
        salirButton.click();
    }

}
