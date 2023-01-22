package com.epam.tc.hw2.ex2;

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

    @Test
    public void testDifferentElements() {
        // 5. Open through the header menu Service -> Different Elements Page - Page is opened
        driver.findElement(By.className("menu-title")).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Different elements")));
        driver.findElement(By.linkText("Different elements")).click();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(driver.getTitle()).as("check the title").isEqualTo("Different Elements");

        // 6. Select checkboxes (Water and Wind)
        driver.findElement(By.xpath("//*[text()[contains(., 'Water')]]")).click();
        softAssertions.assertThat(driver.findElement(By.xpath("//*[text()[contains(., 'Water')]]"))
                .isEnabled()).as("check the checkbox Water is checked").isTrue();

        driver.findElement(By.xpath("//*[text()[contains(., 'Wind')]]")).click();
        softAssertions.assertThat(driver.findElement(By.xpath("//*[text()[contains(., 'Wind')]]"))
                .isEnabled()).as("check the checkbox Wind is checked").isTrue();

        // 7. Select radio (Selen)
        driver.findElement(By.xpath("//*[text()[contains(., 'Selen')]]")).click();
        softAssertions.assertThat(driver.findElement(By.xpath("//*[text()[contains(., 'Selen')]]"))
                .isEnabled()).as("check the radio Selen is selected").isTrue();

        // 8. Select in dropdown (Yellow)
        Select colours = new Select(driver.findElement(By.cssSelector("select[class='uui-form-element']")));
        colours.selectByVisibleText("Yellow");
        String option = colours.getFirstSelectedOption().getText();
        softAssertions.assertThat(option).as("check the option Yellow is selected").isEqualTo("Yellow");

        // 9. Assert log rows
        List<WebElement> logs = driver.findElements(By.cssSelector("ul.panel-body-list.logs *"));
        List<String> logsItems = List.of("changed to Yellow", "changed to Selen",
                "Wind: condition changed to true", "Water: condition changed to true");
        for (int i = 0; i < logs.size(); i++) {
            softAssertions.assertThat(logs.get(i).getText()).as("check the logs are correct")
                    .contains(logsItems.get(i));
        }

        softAssertions.assertAll();

    }

}
