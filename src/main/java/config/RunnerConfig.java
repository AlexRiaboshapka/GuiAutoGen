package config;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

public class RunnerConfig {
    @Step
    public void setUpConfig(){
        Configuration.timeout = 20000;
        Configuration.downloadsFolder = "target/downloads";
        Configuration.reportsFolder = "target/screenshots";
    }
}
