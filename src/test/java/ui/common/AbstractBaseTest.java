package ui.common;

import config.RunnerConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.google.actions.GoogleSearchPageActions;
import pages.google.actions.GoogleSearchResultPageActions;

public class AbstractBaseTest {
    public GoogleSearchPageActions googleSearchPage = new GoogleSearchPageActions();
    public GoogleSearchResultPageActions googleSearchResultPage = new GoogleSearchResultPageActions();
    public RunnerConfig config = new RunnerConfig();

    @BeforeClass
    @Parameters({"projectId", "Browser", "browserVersion"})
    public void setUp(@Optional("2") String projectId,
                      @Optional("FireFox") String Browser,
                      @Optional("107") String browserVersion) {
        config.setUpConfig(projectId, Browser, browserVersion);
    }
}
