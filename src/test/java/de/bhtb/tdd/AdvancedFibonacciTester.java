package de.bhtb.tdd;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AdvancedFibonacciTester {

    Fibonacci fibonacci;

    @Before
    public void setUp() throws Exception {
        fibonacci = new Fibonacci();
    }

    @After
    public void tearDown() throws Exception {
        fibonacci = null;
    }

    @Test
    public void testFibonacciAdv1() throws Exception {
        int cases[][] = {
                {6, 8},
                {7, 13},
                {8, 21}};
        for (int i = 0; i < cases.length; i++) {
            int n = cases[i][0];
            int expected = cases[i][1];
            assertEquals(expected, fibonacci.fib(n));
        }

    }

    @Test
    public void testFibonacciAdv2() throws Exception {
        int cases[][] = {
                {8, 21},
                {9, 34},
                {10, 55}};
        for (int i = 0; i < cases.length; i++) {
            int n = cases[i][0];
            int expected = cases[i][1];
            assertEquals(expected, fibonacci.fib(n));
        }

    }
}
