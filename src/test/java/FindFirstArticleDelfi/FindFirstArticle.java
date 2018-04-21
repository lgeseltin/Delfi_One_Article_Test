package FindFirstArticleDelfi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;

import java.util.List;

public class FindFirstArticle {
    private static final String ARTICLE_TO_FIND = "Latvijas hokeja izlase zaudē Slovākijai arī otrajā pārbaudes spēlē";
    private static final By TITLE = By.xpath("//a[contains(@class, 'top2012-title')]");
    private static final String URL = "www.delfi.lv";
    private BaseFunc baseFunc = new BaseFunc();
    private static final Logger LOGGER = LogManager.getLogger(FindFirstArticle.class);

    @Test
    public void checkArticlePresent() {
        LOGGER.info("BROWSER is Started SUCCESSFULLY");
        baseFunc.goToUrl(URL);
        LOGGER.info("Web page www.delfi.lv was opened");

        List<WebElement> titles = baseFunc.getElements(TITLE);
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
        baseFunc.quitDriver();
        LOGGER.info("Bye bye");
    }
}
