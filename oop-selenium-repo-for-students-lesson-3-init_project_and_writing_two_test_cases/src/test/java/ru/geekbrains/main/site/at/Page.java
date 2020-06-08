package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

public class Page {
    public Page(WebDriver driver) {
        navigation = PageFactory.initElements(driver, Navigation.class);
        header = PageFactory.initElements(driver, Header.class);
        footer = PageFactory.initElements(driver, Footer.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    private final Navigation navigation;
    private final Header header;
    private final Footer footer;
    private final SearchPage searchPage;

    @FindBy(css = "[class=\"gb-header__title\"]")
    public WebElement headerPage;

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    public WebElement buttonPopUpClosed;

    @FindBy(css = "[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    public WebElement buttonSearch;

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    public WebElement inputSearch;


    public Page checkNamePage(String exampleNamePage) {
        String headerPageText = headerPage.getText();
        assertThat(headerPageText, equalToIgnoringWhiteSpace(exampleNamePage));
        return this;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public SearchPage startSearch(String wordSearch) {
        buttonSearch.click();
        inputSearch.sendKeys(wordSearch);
        return searchPage;
    }
}
