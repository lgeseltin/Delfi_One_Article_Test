package FindFirstArticleDelfi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;
import pages.HomePage;

import java.util.List;

public class FindFirstArticle {
    private BaseFunc baseFunc = new BaseFunc();
    private static final Logger LOGGER = LogManager.getLogger(FindFirstArticle.class);
    public static final String URL = "www.delfi.lv";
    public static final String ARTICLE_TO_FIND = "Sevastova un Ostapenko ieved Latvijas komandu Federāciju kausa pasaules grupā";

    @Test
    public void checkArticlePresent() {
        baseFunc.goToUrl(URL);

        //Konstruktor
        HomePage homePage = new HomePage(baseFunc);

        List<WebElement> titles = homePage.getArticles();

        boolean isArticleFound = false;

        for (WebElement we : titles) {
            LOGGER.info("Founded Article " + titles.indexOf(we) + ": " + we.getText());
            if (we.getText().equals(ARTICLE_TO_FIND)) {
                isArticleFound = true;
                break;
            }
        }

        Assert.assertTrue("No article found", isArticleFound);
        LOGGER.info("We found our Article");
    }

    @After
    public void closeBrowser() {
        baseFunc.quitDriver();
    }

}
