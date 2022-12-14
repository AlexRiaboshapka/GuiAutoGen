package pages.cita.locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CitaPreviaLocators {
    public SelenideElement provinceSelection = $(byXpath("//select/option[text()='Alicante']"));
    public SelenideElement acceptButton = $(byXpath("//input[@id='btnAceptar']"));
    public SelenideElement acceptButton2 = $(byXpath("//input[@id='btnEnviar']"));
    public SelenideElement enterButton = $(byXpath("//input[@id='btnEntrar']"));
    public SelenideElement acceptButtonBefore = $(byXpath("//input[@id='btnSubmit']"));
    public SelenideElement citaTypeSelection = $(byXpath("//select//option[@value='4112']"));
    public SelenideElement citaRegionSelection = $(byXpath("//select//option[@value='11']"));
    public SelenideElement citaNie = $(byXpath("//input[@id='txtIdCitado']"));
    public SelenideElement citaName = $(byXpath("//input[@id='txtDesCitado']"));
    public SelenideElement citaInfo = $(byXpath("//p[@class='mf-msg__info']"));
    public SelenideElement salirButton = $(byXpath("//input[@id='btnSalir']"));
    public SelenideElement pageBody = $(byXpath("//body"));

}
