package de.bhtb.lecture05.java8.exercise;

/**
 * Created by visenger on 09/12/16.
 */
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "traider=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }


}
