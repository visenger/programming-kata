package de.bhtb.lecture05.java8.exercise;

import java.util.*;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by visenger on 09/12/16.
 * Some minor changes;
 */
public class Workspace {

    public static void main(String... args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //todo: 1. Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> transactions2011 = transactions.stream()
                .filter(t -> 2011 == t.getYear())
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        transactions2011.forEach(System.out::println);

        //todo: 2. What are all the unique cities where the traders work?
        List<String> uniqueCities = transactions.stream()
                .map(t -> t.getTrader())
                .map(Trader::getCity)
                .distinct()
                .collect(toList());
        uniqueCities.forEach(System.out::println);

        //todo: 3.Find all traders from Cambridge and sort them by name.
        List<Trader> tradersCambridge = transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getTrader)
                .sorted(comparing(Trader::getName))
                .collect(toList());
        tradersCambridge.forEach(System.out::println);

        //todo: 4. Return a string of all traders’ names sorted alphabetically.
        List<Trader> allTraders = Arrays.asList(raoul, mario, alan, brian);

        String collectTraders = allTraders
                .stream()
                .map(Trader::getName)
                .sorted()
                .collect(joining(", "));
        System.out.println("all traders = " + collectTraders);


        //todo: 5.Are any traders based in Milan?
        Predicate<Transaction> onCondition
                = t -> t.getTrader().getCity().equals("Milan");
        boolean anyInMilan = transactions.stream()
                .anyMatch(onCondition);
        System.out.println("any trader in Milan? = " + anyInMilan);

        //todo: 6.Print all transactions’ values from the traders living in Cambridge.
        String transValsFromCambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sorted()
                .boxed()
                .map(String::valueOf)
                .collect(joining(" || ", "[", "]"));
        System.out.println("transactions vals from Cambridge = " + transValsFromCambridge);

        //todo: 7.What’s the highest value of all the transactions?

        Comparator<Transaction> transactionComparator
                = (t1, t2) -> Integer.compare(t1.getValue(), t2.getValue());

        int maxTransaction = transactions.stream()
                .max(transactionComparator)
                .get()
                .getValue();
        System.out.println("max transaction = " + maxTransaction);

        Optional<Integer> maxTransValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        int maxWithReduce = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t1 : t2)
                .get()
                .getValue();

        //playing around comparators
        Comparator<Transaction> compareTransacByTraderName
                = (Transaction t1, Transaction t2) -> t1.getTrader().getName().compareTo(t2.getTrader().getName());

        //todo: 8.Find the transaction with the smallest value.
        Transaction minTransaction = transactions.stream()
                //here we re-use the comparator used in the previous task
                .min(transactionComparator)
                .get();
        System.out.println("min transaction = " + minTransaction);

        Transaction minTransactionWithComparing = transactions.stream()
                .min(comparingInt(Transaction::getValue))
                .get();
        System.out.println("another min transaction = " + minTransactionWithComparing);

    }


}

