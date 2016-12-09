package de.bhtb.tdd;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FibonacciTester.class,
        AdvancedFibonacciTester.class
})


public class FibonacciTestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
