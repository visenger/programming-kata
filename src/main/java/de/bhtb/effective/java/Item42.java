package de.bhtb.effective.java;

import java.util.function.DoubleBinaryOperator;

//Enums with lambdas: Java 8 Features
public class Item42 {

    public static void main(String... args) {
        System.out.println("plus result = " + Operation.PLUS.apply(2.4, 1.6));
    }
}


enum Operation {
    PLUS("+", (x, y) -> x + y),

    MINUS("-", (x, y) -> x - y),

    TIMES("*", (x, y) -> x * y),

    DIVIDE("/", (x, y) -> x / y);


    private final String symbol;

    private final DoubleBinaryOperator op;


    Operation(String symbol, DoubleBinaryOperator op) {

        this.symbol = symbol;

        this.op = op;

    }


    @Override
    public String toString() {
        return symbol;
    }


    public double apply(double x, double y) {

        return op.applyAsDouble(x, y);

    }


}
