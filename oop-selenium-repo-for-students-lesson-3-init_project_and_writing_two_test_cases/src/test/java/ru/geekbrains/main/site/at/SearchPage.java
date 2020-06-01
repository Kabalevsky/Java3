package ru.geekbrains.main.site.at;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class SearchPage {

    public final WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[2]/a")
    public WebElement titleProfessions;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[3]/a")
    public WebElement titleCourses;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[4]/a")
    public WebElement titleWebinars;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[5]/a")
    public WebElement titleBlog;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[6]/a")
    public WebElement titleForum;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div/div[1]/div/ul/li[7]/a")
    public WebElement titleTests;

    public SearchPage checkSection(String nameTitle) {
        switch (nameTitle) {
            case "Профессии": {
                String[] token = titleProfessions.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(2));
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                break;
            }
            case "Курсы": {
                String[] token = titleCourses.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThanOrEqualTo(15));
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                break;
            }
            case "Блоги": {
                String[] token = titleBlog.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThan(300));
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                break;
            }
            case ("Вебинары"): {
                String[] token = titleWebinars.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertThat(count, greaterThan(180));
                assertThat(count, lessThan(300));
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                break;
            }
            case "Тесты": {
                String[] token = titleTests.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertNotEquals(count, 0);
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                break;
            }
            case "Форумы": {
                String[] token = titleForum.getText().split("・");
                int count = Integer.parseInt(token[1]);
                assertNotEquals(count, 350);
                System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                break;
            }
            default: {
                throw new NotFoundException("Не найден блок: " + nameTitle);
            }
        }
        return this;
    }
}