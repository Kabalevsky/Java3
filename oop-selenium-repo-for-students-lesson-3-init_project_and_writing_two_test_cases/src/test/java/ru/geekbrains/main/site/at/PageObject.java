package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    protected boolean elementDisplayed(WebElement element){
        boolean displayed;
        try {
            displayed = element.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            displayed = false;
        }
        return displayed;
    }

    protected void checkElementsDisplayed(WebElement[] elements){
        for (WebElement element : elements) {
            assertThat(elementDisplayed(element),is(true));
        }
    }

    protected boolean waitElementDisplayed(WebElement element){
        boolean displayed = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (org.openqa.selenium.TimeoutException e) {
            displayed = false;
        }
        return displayed;
    }

    protected void buttonClick(WebElement button){
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }

    protected void checkBoxClick(WebElement checkBox){
        boolean initialState = checkBox.isSelected();
        checkBox.click();
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkBox, !initialState));
    }

    protected String getElementText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    protected void checkText(WebElement element, String expectedText){
        assertThat(getElementText(element), equalToCompressingWhiteSpace(expectedText));
    }

    protected int getElementTextToInt(WebElement element){
        return Integer.valueOf(getElementText(element));
    }

    protected void enterText(WebElement element, String text){
        waitElementDisplayed(element);
        element.sendKeys(text);
    }
}

