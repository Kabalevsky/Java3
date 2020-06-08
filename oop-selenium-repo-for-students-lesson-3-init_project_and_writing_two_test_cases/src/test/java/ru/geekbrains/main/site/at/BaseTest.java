package ru.geekbrains.main.site.at;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected static final String BASE_URL = "https://geekbrains.ru";

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        // options.setExperimentalOption("excludeSwitches", Collections.singletonList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1200));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// ожидание 10 секунд
    }
    public String getUrl(String path) {
        return BASE_URL + path;
    }

    @AfterEach
    void DriverDown() {
        driver.quit();
    }
}
