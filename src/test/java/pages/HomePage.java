package pages;

import org.openqa.selenium.By;

public class HomePage {
    public static final String ARTICLE_TO_FIND = "Latvijas hokeja izlase zaudē Slovākijai arī otrajā pārbaudes spēlē";
    public static final By TITLE = By.xpath("//a[contains(@class, 'top2012-title')]");
    public static final String URL = "www.delfi.lv";
}
