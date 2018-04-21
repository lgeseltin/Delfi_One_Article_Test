package FindFirstArticleDelfi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;
import pages.HomePage;

import java.util.List;

public class FindFirstArticle {
    private BaseFunc baseFunc = new BaseFunc();
    private static final Logger LOGGER = LogManager.getLogger(FindFirstArticle.class);

    @Test
    public void checkArticlePresent() {
        baseFunc.goToUrl(HomePage.URL);

        List<WebElement> titles = baseFunc.getElements(HomePage.TITLE);
        boolean isArticleFound = false;

        for (WebElement we : titles) {
            LOGGER.info("Founded Article " + titles.indexOf(we) + ": " + we.getText());
            if (we.getText().equals(HomePage.ARTICLE_TO_FIND)) {
                isArticleFound = true;
                break;
            }
        }

        Assert.assertTrue("No article found", isArticleFound);
        LOGGER.info("We found our Article");
        baseFunc.quitDriver();
    }
}
