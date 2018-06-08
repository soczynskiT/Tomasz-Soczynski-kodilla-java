package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    private static final String XPATH_DAY_FIELD = "//select[@id=\"day\" and contains(@class, \"_5dba\")]";
    private static final String XPATH_MONTH_FIELD = "//select[@id=\"month\" and contains(@class, \"_5dba\")]";
    private static final String XPATH_YEAR_FIELD = "//select[@id=\"year\" and contains(@class, \"_5dba\")]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_DAY_FIELD)).isDisplayed() &&
                !driver.findElement(By.xpath(XPATH_MONTH_FIELD)).isDisplayed() &&
                !driver.findElement(By.xpath(XPATH_YEAR_FIELD)).isDisplayed()) ;

        final WebElement daySelectField = driver.findElement(By.xpath(XPATH_DAY_FIELD));
        final Select daySelect = new Select(daySelectField);
        daySelect.selectByVisibleText("15");

        final WebElement monthSelectField = driver.findElement(By.xpath(XPATH_MONTH_FIELD));
        final Select monthSelect = new Select(monthSelectField);
        monthSelect.selectByVisibleText("cze");

        final WebElement yearSelectField = driver.findElement(By.xpath(XPATH_YEAR_FIELD));
        final Select yearSelect = new Select(yearSelectField);
        yearSelect.selectByValue("1986");
    }
}
