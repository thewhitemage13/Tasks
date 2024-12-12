package org.thewhitemage13;

import org.thewhitemage13.TaskOne.catalana.CatalanNumbers;
import org.thewhitemage13.TaskOne.recursive.Recursive;
import org.thewhitemage13.TaskThree.SumFactorial;
import org.thewhitemage13.TaskTwo.DijkstraAlgorithm;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // Instances of the task classes
    private static final CatalanNumbers catalanNumbers = new CatalanNumbers();
    private static final Recursive recursive = new Recursive();
    private static final SumFactorial sumFactorial = new SumFactorial();
    private static final DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

    public static void main(String[] args) throws IOException {
        boolean operation = true; // Flag to control the loop

        while (operation) {
            // Display menu options
            printProcessor();
            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    // Process and print Catalan numbers using non-recursive method
                    catalanNumbers.catalanNumbersProcessor();
                    break; // Missing break in the original code
                case 2:
                    // Process and print Catalan numbers using recursive method
                    recursive.recursiveProcessor();
                    break; // Missing break in the original code
                case 3:
                    // Calculate and print the sum of digits in 100!
                    sumFactorial.sumFactorialProcessor();
                    break; // Missing break in the original code
                case 4:
                    // Compute and display shortest paths using Dijkstra's algorithm
                    dijkstraAlgorithm.dijkstraProcessor();
                    break; // Missing break in the original code
                case 5:
                    // Exit the program
                    operation = false;
                    break;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Print the menu options for the user
    private static void printProcessor() {
        System.out.println("Menu: ");
        System.out.println("1) -> Catalan Numbers <- ");
        System.out.println("2) -> Recursive <- ");
        System.out.println("3) -> Sum Factorial <- ");
        System.out.println("4) -> Dijkstra <- ");
        System.out.println("5) -> Exit <- ");
        System.out.println();
    }
}