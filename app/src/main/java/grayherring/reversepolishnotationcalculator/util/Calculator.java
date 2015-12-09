package grayherring.reversepolishnotationcalculator.util;

import android.util.Log;
import android.widget.Switch;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by David on 12/9/2015.
 */
public class Calculator {

    private static final String decimalFormatStr =  "0.##########";
   static public String calculate(String rawEquation) throws Exception {
       String delimiter = "[ ]+";
       String[] tokens = rawEquation.split(delimiter);
       Stack<Double> stack = new Stack<>();
       String operators = "+-*/";
       for(String token : tokens){
           Log.i("calculate",token);
            if(operators.contains(token)){
                switch(token){
                    case "+":
                        stack.add(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.add(subtract(stack.pop(), stack.pop()));
                        break;
                    case "*":
                        stack.add(stack.pop() * stack.pop());
                        break;
                    case "/":
                        stack.add(divide(stack.pop(), stack.pop()));
                        break;
                    default:
                        throw new Exception(" not a valid Argument in Equation");
                }
            }else {
                try{
                stack.add(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(token +" not a valid Argument in Equation");
                }
            }
       }
       DecimalFormat decimalFormat = new DecimalFormat(decimalFormatStr);
       return decimalFormat.format(stack.pop());
   }

    public static Double subtract(Double val1,Double val2){
        return val2 - val1;
    }
    public static Double divide(Double val1,Double val2){
        return val2 / val1;
    }

}
