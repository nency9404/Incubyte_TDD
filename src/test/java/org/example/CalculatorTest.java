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

    @Test
    public void testMultipleNumbers() {
        assertEquals(1100000, calc.add("200000,200000,300000,400000"));
    }

    @Test
    public void testNewlineAsDelimiter() {
        assertEquals(16, calc.add("11\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals(34, calc.add("//;\n12;22"));
    }
}
