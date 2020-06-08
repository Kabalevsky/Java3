package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.ansi;

public class Footer {
    private final WebDriver driver;

    public Footer(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(css = "[class=\"site-footer__phone\"]")
    public WebElement buttonPhoneFooter;

    @FindBy(css = "[class=\"site-footer__copyright\"]")
    public WebElement buttonCopyrightFooter;

    @FindBy(css = "[href=\"/feedbacks\"]")
    public WebElement buttonFeedbackFooter;

    @FindBy(css = "[href=\"/company\"]")
    public WebElement buttonAboutProjectFooter;

    @FindBy(css = "[href=\"/license.pdf\"]")
    public WebElement buttonLicenseFooter;

    @Step("Check Footer on page")
    public Page CheckFooterPresent() {
        Assertions.assertNotNull(buttonPhoneFooter.getSize());
        Assertions.assertNotNull(buttonCopyrightFooter.getSize());
        Assertions.assertNotNull(buttonFeedbackFooter.getSize());
        Assertions.assertNotNull(buttonAboutProjectFooter.getSize());
        Assertions.assertNotNull(buttonLicenseFooter.getSize());
        System.out.println(ansi().fg(GREEN).a("Проверка Footers прошла успешно").reset());
        return PageFactory.initElements(driver, Page.class);
    }
}
