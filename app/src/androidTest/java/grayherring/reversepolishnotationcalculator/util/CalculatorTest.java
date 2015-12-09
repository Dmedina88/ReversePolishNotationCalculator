package grayherring.reversepolishnotationcalculator.util;

import junit.framework.TestCase;

/**
 * Created by David on 12/9/2015.
 */
public class CalculatorTest extends TestCase {


    public void testCalculate() throws Exception {
        assertEquals("subtract 1","5",Calculator.calculate("10 5 -"));
        assertEquals("subtract 2","-5",Calculator.calculate("5 10 -"));
        assertEquals("test 1","0",Calculator.calculate("2 3 + 5 + 10 -"));
        assertEquals("test 2", "11",Calculator.calculate("2 2 2 * * 3 +"));
        assertEquals("test 3","-8",Calculator.calculate("2 3 + 2.5 / 10 -"));
        assertEquals("test 4", "-0.05",Calculator.calculate("10 200 400  -  /"));
        assertEquals("test 5","1",Calculator.calculate("-2 3 +"));
        assertEquals("test 6", "2.6666666667",Calculator.calculate("2 2 2 * * 3 /"));
    }



    public void testCalculateException() throws Exception {
        try {
            Calculator.calculate("2 3 + 5 + 10 - -");
            fail( "Missing exception" );
        } catch( IllegalArgumentException e ) {
        }
        try {
            Calculator.calculate("2 2");
            fail( "Missing exception" );
        } catch( IllegalArgumentException e ) {
        }
        try {
            Calculator.calculate("1 1 2 0 * / +");
           fail( "Missing exception" );
        } catch( ArithmeticException e ) {
        }
        try {
            Calculator.calculate("2 + 2  +");
            fail( "Missing exception" );
        } catch( IllegalArgumentException e ) {
        }

    }
}