package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunc {
    WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(BaseFunc.class);

    public BaseFunc() {
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("BROWSER is Started SUCCESSFULLY");
    }

    public void goToUrl(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
        LOGGER.info("Web page " + url + " was opened");
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void quitDriver() {
        driver.quit();
        LOGGER.info("Bye bye");
    }
}
