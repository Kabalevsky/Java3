package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.ansi;

public class Header<T> extends PageObject {
    private Class<T> ownerPageClass;

    @FindBy(css = "[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    public WebElement buttonSearchHeader;

    @FindBy(css = "[class=\"gb-header__title\"]")
    protected WebElement labelHeader;

    @FindBy(css = "[class*=\"gb-header\"] a[class=\"show-search-form\"]")
    protected WebElement buttonSearch;

    public Header(WebDriver driver) {
        super(driver);
    }

    public T checkTitle(String expectedTitle){
        checkText(labelHeader, expectedTitle);
        return PageFactory.initElements(driver, ownerPageClass);
    }

@Step("Check Header on page")
    public Page CheckHeaderPresent() {
        Assertions.assertNotNull(buttonSearchHeader.getSize());
        System.out.println(ansi().fg(GREEN).a("Проверка Header прошла успешно").reset());
        return PageFactory.initElements(driver, Page.class);
    }
}

