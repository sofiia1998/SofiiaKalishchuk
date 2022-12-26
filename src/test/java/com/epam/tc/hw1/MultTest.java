package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;


public class MultTest extends CalculatorTestBase {
    @Test(dataProviderClass = DataProviders.class, dataProvider = "mult long data")
    public void multTestLong(long first, long second, long third) {

        long result = calculator.mult(first, second);

        assertThat(result).as("This test is failed")
                .isEqualTo(third);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "mult double data")
    public void multTestDouble(double first, double second, double third) {

        double result = calculator.mult(first, second);

        assertThat(result).as("This test is failed")
                .isEqualTo(third);
    }
}
