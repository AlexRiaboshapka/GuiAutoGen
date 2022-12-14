package pages.cita.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import pages.cita.locators.CitaPreviaLocators;
import java.util.Random;

import static com.codeborne.selenide.Selenide.sleep;
import static helper.CommonSteps.getAndAttachScreenshot;

public class CitaPreviaActions extends CitaPreviaLocators {
    int sleepResult;

    @BeforeMethod
    public void createRandomSleep() {
        Random r = new Random();
        int low = 2000;
        int high = 3000;
        sleepResult = r.nextInt(high - low) + low;
        if(pageBody.getText().contains("The requested URL was rejected. Please consult with your administrador")); {
            Assert.assertFalse(true,"Test failed because page is not loaded");
        }
    }

    @Step
    public void clickAccept() {
        sleep(sleepResult);
        acceptButtonBefore.click();
    }

    @Step
    public void selectRegionAndAccept() {
        sleep(sleepResult);
        provinceSelection.click();
        acceptButton.click();
    }

    @Step
    public void selectCitaTypeAndAccept() {
        sleep(sleepResult);
        if (citaRegionSelection.isDisplayed()) {
            citaRegionSelection.click();
            citaTypeSelection.click();
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
            citaName.sendKeys(name);
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
            Assert.assertTrue(text.contains("En este momento no hay citas disponibles"),
                    "Expected text is not present but present text:\n" + text);
            CustomLogger.logger.info("Cita info: " + text);
        }
        salirButton.click();
    }

}
