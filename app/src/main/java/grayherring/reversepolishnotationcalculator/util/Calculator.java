package grayherring.reversepolishnotationcalculator.util;

import android.util.Log;

import java.text.DecimalFormat;
import java.util.EmptyStackException;
import java.util.Stack;


/**
 * Created by David on 12/9/2015.
 */
public class Calculator {

   private static final String decimalFormatStr =  "0.##########";
    
   static public String calculate(String rawEquation) throws IllegalArgumentException,ArithmeticException  {
       String delimiter = "[ ]+";
       String[] tokens = rawEquation.split(delimiter);
       Stack<Double> stack = new Stack<>();
       String operators = "+-*/";
       try {
       for(String token : tokens){
           Log.i("calculate",token);
            if(operators.contains(token)){
                switch(token){
                    case "+":
                        stack.push(add(stack.pop() , stack.pop()));
                        break;
                    case "-":
                        stack.push(subtract(stack.pop(), stack.pop()));
                        break;
                    case "*":
                        stack.push(multiply(stack.pop() , stack.pop()));
                        break;
                    case "/":
                        stack.push(divide(stack.pop(), stack.pop()));
                        break;
                    default:
                        throw new IllegalArgumentException(" not a valid Argument in Equation");
                }
            }else {
                try{
                stack.push(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(token +" not a valid Argument in Equation");
                }
            }
       }
       DecimalFormat decimalFormat = new DecimalFormat(decimalFormatStr);
           String result = decimalFormat.format(stack.pop());
           Log.d("calculate",result);
           if(stack.isEmpty()){
               Log.d("calculate",result);
               return  result;
           }else {
               throw  new IllegalArgumentException(" Malformed Input");
           }
       }catch (EmptyStackException e){
           throw new IllegalArgumentException(" Malformed Input");
       }catch (ArithmeticException e){
            throw e;
       }

   }

    public static Double subtract(Double subtrahend,Double minuend) throws ArithmeticException {
        return minuend - subtrahend;
    }
    public static Double divide(Double Divisors,Double dividend){
        Double result =dividend / Divisors;
        if(result.isInfinite()){
            throw new ArithmeticException("Arithmetic results in dividing by 0");
        }
        return result;
    }

    public static Double add(Double num1,Double num2) throws ArithmeticException {
        return num1 + num2;
    }
    public static Double multiply(Double num1, Double num2) throws ArithmeticException {
        return num1 * num2;
    }

}
