package grayherring.reversepolishnotationcalculator.util;

import junit.framework.TestCase;

/**
 * Created by David on 12/9/2015.
 */
public class CalculatorTest extends TestCase {

    public void testCalculat() throws Exception {
        assertEquals("test 1","0.0",Calculator.calculate("2 3 + 5 + 10 -"));
        assertEquals("test 2", "11.0",Calculator.calculate("2 2 2 * * 3 +"));

        assertEquals("test 3","-9.0",Calculator.calculate("2 3 + 5 / 10 -"));
        assertEquals("test 4", "11.0",Calculator.calculate("2 2 2 * * 3 +"));
        assertEquals("test 5","0.0",Calculator.calculate("2 3 + 5 + 10 -"));
        assertEquals("test 6", "11.0",Calculator.calculate("2 2 2 * * 3 +"));

    }
}