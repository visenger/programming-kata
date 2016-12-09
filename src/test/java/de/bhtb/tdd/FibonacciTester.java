package de.bhtb.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class FibonacciTester {

    private static Fibonacci fibonacci;

    @BeforeClass
    public static void setUp() throws Exception {
        fibonacci = new Fibonacci();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        fibonacci = null;
    }

    @Test
    public void testFibonacci() {
        int cases[][] = {
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8}};
        for (int i = 0; i < cases.length; i++) {
            int n = cases[i][0];
            int expected = cases[i][1];
            assertEquals(expected, fibonacci.fib(n));
        }
    }
}
