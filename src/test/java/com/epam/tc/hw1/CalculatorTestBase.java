package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CalculatorTestBase {

    protected Calculator calculator;

    @BeforeClass
    public void before() {
        calculator = new Calculator();
    }

    @AfterClass
    public void after() {
        calculator = null;
    }
}
