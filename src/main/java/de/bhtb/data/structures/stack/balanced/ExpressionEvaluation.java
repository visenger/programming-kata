package de.bhtb.data.structures.stack.balanced;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by visenger on 14.06.17.
 */
public class ExpressionEvaluation {

    public static void main(String... args) {
        String s1 = "( ( ( 2 + 5 ) * ( 4 * 5 ) ) + 1 )";
        System.out.println("expression: " + s1);
        System.out.println(s1 + "  =  " + eval(s1));

    }

    //TODO: implement arithmetic operations with Enums (see Effective Java)
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

            } else if (token.equals(")")) {
                String operator = operators.pop();
                if (operator.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (operator.equals("*")) vals.push(vals.pop() * vals.pop());
            } else {
                vals.push(Double.parseDouble(token));
            }
        }


        return vals.pop();
    }


    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("*");
    }
}
