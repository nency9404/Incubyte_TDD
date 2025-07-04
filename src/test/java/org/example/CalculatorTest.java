package org.example;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorTest {

    String_Calculator calc=new String_Calculator();
    @Test
    public void testEmptyString(){
        assertEquals(0, calc.add(""));
    }
}
