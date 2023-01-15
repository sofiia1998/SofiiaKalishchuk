package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BrowserTestBase;
import java.util.List;
import java.util.Objects;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ExerciseSecondTest extends BrowserTestBase {

    @Test
    public void testDifferentElements() throws InterruptedException {
        // 5. Open through the header menu Service -> Different Elements Page - Page is opened
        driver.findElement(By.className("menu-title")).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Different elements")));
        driver.findElement(By.linkText("Different elements")).click();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(driver.getTitle()).isEqualTo("Different Elements");

        // 6. Select checkboxes (Water and Wind)
        List<WebElement> checkBoxes = driver.findElements(By.className("label-checkbox"));

        for (WebElement checkB : checkBoxes) {
            if (Objects.equals(checkB.getText(), "Water") || Objects.equals(checkB.getText(), "Wind")) {
                checkB.click();
                softAssertions.assertThat(checkB.isEnabled()).isTrue();
            }
        }
        // 7. Select radio (Selen)
        driver.findElement(By.xpath("//*[text()[contains(., 'Selen')]]")).click();
        softAssertions.assertThat(driver.findElement(By.xpath("//*[text()[contains(., 'Selen')]]"))
                .isEnabled()).isTrue();

        // 8. Select in dropdown (Yellow)
        Select colours = new Select(driver.findElement(By.cssSelector("select[class='uui-form-element']")));
        colours.selectByVisibleText("Yellow");
        String option = colours.getFirstSelectedOption().getText();
        softAssertions.assertThat(option).isEqualTo("Yellow");

        // 9. Assert log rows
        List<WebElement> logs = driver.findElements(By.cssSelector("ul.panel-body-list.logs *"));
        softAssertions.assertThat(logs.get(0).getText()).contains("changed to Yellow");
        softAssertions.assertThat(logs.get(1).getText()).contains("changed to Selen");
        softAssertions.assertThat(logs.get(2).getText()).contains("Wind", "true");
        softAssertions.assertThat(logs.get(3).getText()).contains("Water", "true");

        softAssertions.assertAll();

        Thread.sleep(5000);

    }
}
