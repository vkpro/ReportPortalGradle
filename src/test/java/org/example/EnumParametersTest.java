package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class EnumParametersTest extends TestBase {

    public enum TestParams {
        ONE,
        TWO
    }

    @ParameterizedTest
    @EnumSource(TestParams.class)
    public void testParameters(TestParams param) {
        System.out.println("Test: " + param.name());
    }
}