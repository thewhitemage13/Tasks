package org.thewhitemage13.TaskOne.catalana;

import java.util.Scanner;

public class CatalanNumbers {
    private final Scanner scanner = new Scanner(System.in);

    public void catalanNumbersProcessor() {
        System.out.print("Enter the number: ");
        long number = scanner.nextInt();
        // If the input is negative, simply exit without processing
        if(number < 0) return;
        // Display the calculated Catalan number for the input value
        System.out.println("Number of correct parenthetical expressions for number = %s is "
                .formatted(number) + catalan(number));
    }

    // Calculate the nth Catalan number using the formula:
    // C(n) = (2n)! / ((n + 1)! * n!)
    private long catalan(long n){
        return ((factorial(2 * n)) / ((factorial(n + 1) * factorial(n))));
    }

    // Calculate factorial of a given number using iterative method
    private long factorial(long n){
        long f = 1;
        // Loop from 1 to n and multiply each value to compute the factorial
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
