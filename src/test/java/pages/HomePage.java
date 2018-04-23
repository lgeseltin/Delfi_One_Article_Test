package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    BaseFunc baseFunc;
    public static final By TITLE = By.xpath("//a[contains(@class, 'top2012-title')]");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<WebElement> getArticles() {
        return baseFunc.getElements(TITLE);
    }
}
