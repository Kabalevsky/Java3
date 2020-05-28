package ru.geekbrains.main.site.at;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;


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

    // У нас получается три блока: 1 блок с условием "более" - это профессии, курсы и блоги
    public SearchPage checkSection(String nameTitle) {
        switch (nameTitle) {
            case "Профессии": {
                String[] token = titleProfessions.getText().split("・");
                int count = Integer.parseInt(token[1]);
                if (count >= 2) {
                    System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                } else {
                    System.out.println(ansi().fg(BLUE).a("Проверка раздела " + nameTitle + " провалилась").reset());
                }
                break;
            }
            case "Курсы": {
                String[] token = titleCourses.getText().split("・");
                int count = Integer.parseInt(token[1]);
                if (count > 200) {
                    System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                } else {
                    System.out.println(ansi().fg(BLUE).a("Проверка раздела " + nameTitle + " провалилась").reset());
                }
                break;
            }
            case "Блоги": {
                String[] token = titleBlog.getText().split("・");
                int count = Integer.parseInt(token[1]);
                if (count > 300) {
                    System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                } else {
                    System.out.println(ansi().fg(BLUE).a("Проверка раздела " + nameTitle + " провалилась").reset());
                }
                break;
            }
            default: {
                throw new NotFoundException("Не найден блок: " + nameTitle);
            }
        }
        return this;
    }

    // Второй блок с условием "больше" и "меньше" - вебинары
    public SearchPage checkWebinars(String nameTitle) {
        switch (nameTitle) {
            case ("Вебинары"): {
                String[] token = titleWebinars.getText().split("・");
                int count = Integer.parseInt(token[1]);
                if (count > 180 && count < 300) {
                    System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                } else {
                    System.out.println(ansi().fg(BLUE).a("Проверка раздела " + nameTitle + " провалилась").reset());
                }
                break;
            }
            default: {
                throw new NotFoundException("Не найден блок: " + nameTitle);
            }
        }
        return this;
    }

    // Третий блок с уловием "не равно" - тесты и форумы
    public SearchPage checkTests(String nameTitle) {
        switch (nameTitle) {
            case "Тесты": {
                String[] token = titleTests.getText().split("・");
                int count = Integer.parseInt(token[1]);
                if (count != 1) {
                    System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                } else {
                    System.out.println(ansi().fg(BLUE).a("Проверка раздела " + nameTitle + " провалилась").reset());
                }
                break;
            }
            case "Форумы": {
                String[] token = titleForum.getText().split("・");
                int count = Integer.parseInt(token[1]);
                if (count != 350) {
                    System.out.println(ansi().fg(GREEN).a("Проверка раздела " + nameTitle + " прошла успешно").reset());
                } else {
                    System.out.println(ansi().fg(BLUE).a("Проверка раздела " + nameTitle + " провалилась").reset());
                }
                break;
            }
            default: {
                throw new NotFoundException("Не найден блок: " + nameTitle);
            }
        }
        return this;
    }
}