package com.ilCarro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class BasePage {

    public static WebDriver driver;//objawlaem driver tolko w roditelskom klasse

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void launchBrowser() {
        System.err.close();//skrili wse sistemnie predupreschedenij

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void openURL() {
        driver.get("https://ilcarro.web.app");
    }

    public void quit() {
        driver.quit();
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void select(WebElement element, String options) {
        Select select = new Select(element);
        select.selectByValue(options);
    }
}
