package org.thewhitemage13.TaskOne.recursive;

import java.util.Scanner;

public class Recursive {
    private final Scanner scanner = new Scanner(System.in);

    public void recursiveProcessor() {
        System.out.print("Enter the number: ");
        int number = scanner.nextInt();
        // If the input is negative, terminate without further processing
        if(number < 0) return;
        // Calculate and display the nth Catalan number using recursion
        System.out.println("Number of correct parenthetical expressions for number = %s is "
                .formatted(number) + calculateCatalan(number));
    }

    // Recursively calculate the nth Catalan number
    private long calculateCatalan(int n) {
        if (n == 0) return 1;

        long catalan = 0;

        // Calculate the Catalan number using the recursive formula:
        // C(n) = Σ (C(i) * C(n - i - 1)) for i = 0 to n - 1
        for (int i = 0; i < n; i++) {
            catalan += calculateCatalan(i) * calculateCatalan(n - 1 - i);
        }
        return catalan;
    }
}
