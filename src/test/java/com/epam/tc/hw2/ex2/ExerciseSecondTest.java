package com.epam.tc.hw2.ex2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw2.BrowserTestBase;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ExerciseSecondTest extends BrowserTestBase {
    SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void testDifferentElements() {
        // 1. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();

        // 2. Assert Browser title
        assertThat(driver.getTitle()).as("check the title").isEqualTo("Home Page");

        // 3. Perform login
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.className("uui-profile-menu")));

        driver.findElement(By.className("uui-profile-menu")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined
        assertThat(driver.findElement(By.id("user-name")).getText()).as("check the username")
                .isEqualTo("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page - Page is opened
        driver.findElement(By.className("menu-title")).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Different elements")));
        driver.findElement(By.linkText("Different elements")).click();
        softAssertions.assertThat(driver.getTitle()).as("check the title").isEqualTo("Different Elements");

        // 6. Select checkboxes (Water and Wind)
        driver.findElement(By.xpath("//*[text()[contains(., 'Water')]]")).click();
        driver.findElement(By.xpath("//*[text()[contains(., 'Wind')]]")).click();

        // 7. Select radio (Selen)
        driver.findElement(By.xpath("//*[text()[contains(., 'Selen')]]")).click();

        // 8. Select in dropdown (Yellow)
        Select colours = new Select(driver.findElement(By.cssSelector("select[class='uui-form-element']")));
        colours.selectByVisibleText("Yellow");

        // 9. Assert log rows
        List<WebElement> logs = driver.findElements(By.cssSelector("ul.panel-body-list.logs *"));
        List<String> expectedLogsItems = List.of("changed to Yellow", "changed to Selen",
                "Wind: condition changed to true", "Water: condition changed to true");
        for (int i = 0; i < logs.size(); i++) {
            softAssertions.assertThat(logs.get(i).getText()).as("check the logs are correct")
                    .contains(expectedLogsItems.get(i));
        }

        softAssertions.assertAll();

    }

}
