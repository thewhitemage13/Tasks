package org.thewhitemage13.TaskThree;

import java.math.BigInteger;

public class SumFactorial {
    public void sumFactorialProcessor() {
        BigInteger factorial = BigInteger.ONE;

        // Calculate 100!
        for (int i = 2; i <= 100; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        // Initialize sum to store the sum of digits
        int sum = 0;

        // Convert the factorial to a string, iterate through each character (digit)
        for (char digit : factorial.toString().toCharArray()) {
            // Convert char to integer and add to sum
            sum += digit - '0';
        }
        // Print the result: sum of the digits of 100!
        System.out.println(sum);
    }
}
