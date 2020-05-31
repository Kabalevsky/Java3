package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.ansi;

public class Header {
    private final WebDriver driver;
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    public WebElement buttonSearchHeader;

    public Page CheckHeaderPresent() {
        Assertions.assertNotNull(buttonSearchHeader.getSize());
        System.out.println(ansi().fg(GREEN).a("Проверка Header прошла успешно").reset());
        return PageFactory.initElements(driver, Page.class);
    }
}
