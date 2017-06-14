package de.bhtb.data.structures.stack.balanced;

import java.util.Stack;

/**
 * Created by visenger on 14.06.17.
 */
public class BalancedExpression {

    public static void main(String... args) {
        String s = "(())";
        System.out.println(s + " balanced? " + balanced(s));
        String s1 = "((1,b,c))";
        System.out.println(s1 + " balanced? " + balanced(s1));
        String s2 = "((1),(b,c))";
        System.out.println(s2 + " balanced? " + balanced(s2));
        String s3 = "((1)),(b,c))";
        System.out.println(s3 + " balanced? " + balanced(s3));
        String s4 = "((1,(b,c)))";
        System.out.println(s4 + " balanced? " + balanced(s4));
        String s5 = "((1),(b,c)))";
        System.out.println(s5 + " balanced? " + balanced(s5));
        System.out.println("" + " balanced? " + balanced(""));
        /*Your code should work also with these strings:*/
        /*For this one the condition is true*/
        String s6 = "(([]{}))";
        System.out.println(s6 + " balanced? " + balancedMulti(s6));
        String s7 = "(([]))";
        System.out.println(s7 + " balanced? " + balancedMulti(s7));
        /*For this one the condition is false*/
        String s8 = "(([]]{}}))";
        System.out.println(s8 + " balanced? " + balancedMulti(s8));
    }

    private static boolean balancedMulti(String input) {
        Stack<Character> roundParenthesis = new Stack<>();
        Stack<Character> squareParenthesis = new Stack<>();
        Stack<Character> curlyParenthesis = new Stack<>();


        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') roundParenthesis.push(c);
            if (c == '[') squareParenthesis.push(c);
            if (c == '{') curlyParenthesis.push(c);

            if (c == ')') {
                if (roundParenthesis.isEmpty()) return false;
                roundParenthesis.pop();
            }
            if (c == ']') {
                if (squareParenthesis.isEmpty()) return false;
                squareParenthesis.pop();
            }
            if (c == '}') {
                if (curlyParenthesis.isEmpty()) return false;
                curlyParenthesis.pop();
            }
        }
        return roundParenthesis.isEmpty() && squareParenthesis.isEmpty() && curlyParenthesis.isEmpty();
    }

    private static boolean balanced(String input) {
        Stack<Character> openParenthesis = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                openParenthesis.push(input.charAt(i));
            }
            if (input.charAt(i) == ')') {
                if (openParenthesis.empty()) return false;
                openParenthesis.pop();
            }
        }

        return openParenthesis.empty();
    }
}
