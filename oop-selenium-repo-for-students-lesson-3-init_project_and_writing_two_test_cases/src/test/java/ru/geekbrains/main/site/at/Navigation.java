package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.ansi;

public class Navigation {

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/courses\"]")
    public WebElement buttonCourses;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/events\"]")
    public WebElement buttonEvents;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/topics\"]")
    public WebElement buttonTopics;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/posts\"]")
    public WebElement buttonPosts;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/tests\"]")
    public WebElement buttonTests;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/career\"]")
    public WebElement buttonCareer;

    private final WebDriver driver;

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

@Step("Click on {nameButton} button")
    public Page clickButton(String nameButton) {
        switch (nameButton) {
            case "Курсы": {
                buttonCourses.click();
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameButton + " прошла успешно").reset());
                break;
            }
            case "Вебинары": {
                buttonEvents.click();
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameButton + " прошла успешно").reset());
                break;
            }
            case "Форум": {
                buttonTopics.click();
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameButton + " прошла успешно").reset());
                break;
            }
            case "Блог": {
                buttonPosts.click();
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameButton + " прошла успешно").reset());
                break;
            }
            case "Тесты": {
                buttonTests.click();
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameButton + " прошла успешно").reset());
                break;
            }
            case "Карьера": {
                buttonCareer.click();
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameButton + " прошла успешно").reset());
                break;
            }
            default: {
                throw new NotFoundException("Не найден раздел: " + nameButton);
            }
        }
        return PageFactory.initElements(driver, Page.class);
    }
}
