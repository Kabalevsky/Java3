package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

// Задание №2
@DisplayName("Пороверка поисковой выдачи")
public class SearchTest extends BaseTest {

    @DisplayName("Пороверка результатов поисковой выдачи ")
    @Test
    void SearchJavaTest() {
        driver.get("https://geekbrains.ru/career");

        PageFactory.initElements(driver, Page.class).
                startSearch("JAVA").
                checkSection("Профессии").
                checkSection("Курсы").
                checkSection("Блоги").
                checkWebinars("Вебинары").
                checkTests("Форумы").
                checkTests("Тесты");
    }
}
