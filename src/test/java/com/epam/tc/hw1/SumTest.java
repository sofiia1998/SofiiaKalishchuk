package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;


public class SumTest extends CalculatorTestBase {
    @Test(dataProviderClass = DataProviders.class, dataProvider = "sum long data")
    public void sumTestLong(long first, long second, long third) {

        long result = calculator.sum(first, second);

        assertThat(result).as("This test is failed").isEqualTo(third);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "sum double data")
    public void sumTestDouble(double first, double second, double third) {

        double result = calculator.sum(first, second);

        assertThat(result).as("This test is failed").isEqualTo(third);
    }
}
