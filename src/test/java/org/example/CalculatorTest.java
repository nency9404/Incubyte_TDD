package org.example;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void testTrailingDelimiter() {
        assertEquals(6, calc.add("1,2,3,"));
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

    @Test
    public void testNegativeNumber() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            calc.add("5,-5");
        });
        assertTrue(ex.getMessage().contains("-5"));
    }

    @Test
    public void testMultipleNegativesInException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            calc.add("-10,-22,3");
        });
        assertTrue(ex.getMessage().contains("-10"));
        assertTrue(ex.getMessage().contains("-22"));
    }

    @Test
    public void testCustomDelimiterAnyLength() {
        assertEquals(16, calc.add("//[**]\n11**2**3"));
    }

    @Test
    public void testLargeInput() {
        StringBuilder input = new StringBuilder();
        for (int i = 1; i <= 1000; i++) {
            input.append(i).append(",");
        }
        input.setLength(input.length() - 1);
        assertEquals(500500, calc.add(input.toString()));
    }

    @Test
    public void testWhitespaceAroundNumbers() {
        assertEquals(6, calc.add(" 1  ,2 ,3"));
    }

    @Test
    public void testNegativeNumbersWithMultipleDelimiters() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            calc.add("//[*][%]\n-11*22%-35");
        });
        assertTrue(ex.getMessage().contains("-11"));
        assertTrue(ex.getMessage().contains("-35"));
    }
}
