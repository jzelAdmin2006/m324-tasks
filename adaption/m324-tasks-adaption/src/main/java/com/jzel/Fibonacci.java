package com.jzel;

/**
 * This is a Calculator for the Fibonacci sequence.
 */
public class Fibonacci {

    /**
     * Calculate the fibonacci sequence.
     *
     * @param n number of sequence entries to calculate
     * @return result according to nth number of sequence
     */
    public int calculate(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        if (n == 0) {
            return 0;
        }

        int prev = 0;
        int current = 1;

        for (int i = 2; i <= n; i++) {
            final int next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }
}
