package org.example;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorTest {

    String_Calculator calc=new String_Calculator();

    @Test
    public void testEmptyString(){
        assertEquals(0, calc.add(""));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(51, calc.add("51"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(11, calc.add("5,6"));
    }
}
