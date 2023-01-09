package ui.common;

import logger.CustomLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BaseTest {

    private WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        BaseTest baseTest = new BaseTest();
        baseTest.setUp();
        baseTest.tearDown();
    }

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        CustomLogger.logger.info(driver.getTitle());
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(390, 844));
        WebElement shiftingContent = driver.findElement(By.xpath("//li/a[@href='/shifting_content']"));
        WebElement shiftingContentMenu = driver.findElement(By.xpath("//div/a[@href='/shifting_content/menu']"));
        List<WebElement> shiftingContentMenus = driver.findElements(By.xpath("//li"));
        Actions newAction = new Actions(driver);
        newAction.moveToElement(shiftingContent);
        newAction.perform();
        shiftingContent.click();
        shiftingContentMenu.click();

        CustomLogger.logger.info("Total elements: " + shiftingContentMenus.size());
        for (WebElement element : shiftingContentMenus) {
            CustomLogger.logger.info("Present elements" + element.getText());
            element.getText();
        }
    }

    public void tearDown() {
        driver.quit();
    }
}
