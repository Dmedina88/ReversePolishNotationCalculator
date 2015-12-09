package grayherring.reversepolishnotationcalculator.util;

import android.util.Log;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by David on 12/9/2015.
 */
public class Calculator {


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
                        stack.add(stack.pop() +stack.pop());
                        break;
                    case "-":
                        stack.add(stack.pop() -stack.pop());
                        break;
                    case "*":
                        stack.add(stack.pop() *stack.pop());
                        break;
                    case "/":
                        stack.add(stack.pop() /stack.pop());
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


       return stack.pop().toString();
   }




}
