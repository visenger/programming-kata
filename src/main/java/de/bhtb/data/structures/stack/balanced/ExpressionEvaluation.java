package de.bhtb.data.structures.stack.balanced;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by visenger on 14.06.17.
 */
public class ExpressionEvaluation {

    public static void main(String... args) {
        String s1 = "( ( 1 + 1 ) * 10 )";
        System.out.println("expression: " + s1);
        System.out.println(s1 + "  =  " + eval(s1));

    }

    private static double eval(String input) {
        Stack<Double> vals = new Stack<>();
        Stack<String> operators = new Stack<>();

        Scanner scanner = new Scanner(input);

        while (scanner.hasNext()) {
            String token = scanner.next();
            //System.out.println("token = " + token);
            if (token.equals("(")) {
                //nothing happens
            } else if (isOperator(token)) {
                operators.push(token);
            } else if (isOperand(token)) {
                vals.push(Double.valueOf(token));
            } else if (token.equals(")")) {
                String operator = operators.pop();
                if (operator.equals("+")) vals.push(vals.pop() + vals.pop());
                if (operator.equals("*")) vals.push(vals.pop() * vals.pop());
            }
        }


        return vals.pop();
    }

    private static boolean isOperand(String token) {
        boolean isNumber = token.matches("(?:\\d*\\.)?\\d+");
       // System.out.println("token = " + token + " isOperand " + isNumber);
        return isNumber;
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("*");
    }
}
