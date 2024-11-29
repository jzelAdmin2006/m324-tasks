package com.jzel;

public class Fibonacci {

    public int calculate(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev = 0, current = 1;

        for (int i = 2; i <= n; i++) {
            final int next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }
}
