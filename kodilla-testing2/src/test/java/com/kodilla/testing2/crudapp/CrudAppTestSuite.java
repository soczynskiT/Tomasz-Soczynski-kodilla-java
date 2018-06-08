package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://soczynskit.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTest() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        Objects.requireNonNull(driver).get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"tasks\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"tasks\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"tasks\")]/fieldset[3]/button";
        final String taskName = "Task number " + generator.nextInt(100000);
        final String taskContent = taskName + " content";

        final WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);
        final WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);
        final WebElement addbutton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addbutton.click();
        Thread.sleep(3000);

        return taskName;
    }

    private void sendTestTaskToTrello(final String taskname) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskname))
                .forEach(theForm -> {
                    final WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    final Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    final WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(3000);

        final Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    private void deleteCreatedTestTask(final String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(row -> row.findElements(By.xpath(".//button[@type=\"button\"]")).stream()
                        .filter(button -> button.getText().equals("Delete"))
                        .forEach(WebElement::click));

        Thread.sleep(2000);
    }

    private boolean checkTaskExistsInTrello(final String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        final WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        Objects.requireNonNull(driverTrello).get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("sokoeclipse@gmail.com");
        driverTrello.findElement(By.id("password")).sendKeys("102938trello");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driverTrello.findElement(By.xpath("//a[@href=\"/tomaszsoczynski/boards\"]")).click();
        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Application\"]"))
                        .size() > 0)
                .forEach(WebElement::click);

        Thread.sleep(2000);

        final boolean result = new ArrayList<>(driverTrello.findElements(By.xpath("//span[text()='" + taskName + "']")))
                .size() > 0;

        driverTrello.close();

        return result;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        final String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        deleteCreatedTestTask(taskName);
        Assert.assertTrue(checkTaskExistsInTrello(taskName));
    }
}
