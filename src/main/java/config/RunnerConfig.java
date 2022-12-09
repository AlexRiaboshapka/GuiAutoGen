package config;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

public class RunnerConfig {
    @Step
    public void setUpConfig(String projectId, String browser, String browserVersion) {
        Configuration.timeout = 20000;
        Configuration.downloadsFolder = "target/downloads";
        Configuration.reportsFolder = "target/screenshots";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
    }
}
