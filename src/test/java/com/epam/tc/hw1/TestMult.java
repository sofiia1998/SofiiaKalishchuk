package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestMult {

    @DataProvider
    public static Object[][] longData() {
        return new Object[][]{
                {10, 20, 200},
                {5, 5, 25},
                {10, 15, 150}
        };
    }

    @DataProvider
    public static Object[][] doubleData() {
        return new Object[][]{
                {5.7, 5.3, 30},
                {5.5, 4.8, 26},
                {4.7, 3.3, 15}
        };
    }

    @Test(dataProvider = "longData")

    public void multTestLong(long first, long second, long third) {

        Calculator calculator = new Calculator();
        long result = calculator.mult(first, second);

        assertThat(result).as("This test is failed")
                .isEqualTo(third);
    }

    @Test(dataProvider = "doubleData")

    public void multTestDouble(double first, double second, double third) {

        Calculator calculator = new Calculator();
        double result = calculator.mult(first, second);

        assertThat(result).as("This test is failed")
                .isEqualTo(third);
    }
}
