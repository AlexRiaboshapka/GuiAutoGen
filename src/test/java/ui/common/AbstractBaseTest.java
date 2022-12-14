package ui.common;

import config.RunnerConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.cita.actions.CitaPreviaActions;
import pages.google.actions.GoogleSearchPageActions;
import pages.google.actions.GoogleSearchResultPageActions;
import pages.wikipedia.actions.WikipediaMainPageActions;

public class AbstractBaseTest {
    public RunnerConfig config = new RunnerConfig();
    public GoogleSearchPageActions googleSearchPage = new GoogleSearchPageActions();
    public GoogleSearchResultPageActions googleSearchResultPage = new GoogleSearchResultPageActions();
    public WikipediaMainPageActions wikipediaMainPage = new WikipediaMainPageActions();

    public CitaPreviaActions citaPrevia = new CitaPreviaActions();
    @BeforeClass
    @Parameters({"projectId", "Browser", "browserVersion"})
    public void setUp(@Optional("2") String projectId,
                      @Optional("Chrome") String Browser,
                      @Optional("108") String browserVersion) {
        config.setUpConfig(projectId, Browser, browserVersion);
    }
}
