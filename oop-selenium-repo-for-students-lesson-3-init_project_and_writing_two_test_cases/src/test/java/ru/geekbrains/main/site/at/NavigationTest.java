package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import java.util.stream.Stream;


// Задание №1
@DisplayName("Проверка навигации")
public class NavigationTest extends BaseTest {

    static Stream<String> stringProvider() {
        return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }

    @ParameterizedTest(name = "Проверка страницы {0}")
    @MethodSource("stringProvider")
    void checkNavigation(String namePage) {
        driver.get("https://geekbrains.ru/career");

        PageFactory.initElements(driver, Page.class)
                .getNavigation().clickButton(namePage)
                .checkNamePage(namePage).
                getHeader().
                CheckHeaderPresent().
                getFooter().
                CheckFooterPresent();
    }

}