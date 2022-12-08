package ui.common;

import config.RunnerConfig;
import org.testng.annotations.BeforeClass;
import pages.google.actions.GoogleSearchPageActions;
import pages.google.actions.GoogleSearchResultPageActions;

public class AbstractBaseTest {
    public GoogleSearchPageActions googleSearchPage = new GoogleSearchPageActions();
    public GoogleSearchResultPageActions googleSearchResultPage = new GoogleSearchResultPageActions();
    public RunnerConfig config = new RunnerConfig();

    @BeforeClass
    public void setUp(){
        config.setUpConfig();
    }

}
