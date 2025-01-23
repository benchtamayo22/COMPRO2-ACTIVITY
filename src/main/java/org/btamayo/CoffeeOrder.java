package org.btamayo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CoffeeOrder {

    static final Scanner scan = new Scanner(System.in);
    static final String[] coffee = {"Espresso", "Latte", "Cappuccino", "Mocha"};
    static final double[] coffeePrice = {50.0, 70.0, 65.0, 80.0};
    static final int[] quantity = new int[coffee.length]; // Initialize quantity array

    public static void main(String[] args) {
        double total = 0;

        String menu = """
                --- Menu ---
                1. Espresso - 50.0 PHP
                2. Latte - 70.0 PHP
                3. Cappuccino - 65.0 PHP
                4. Mocha - 80.0 PHP
                0. Finish Order
                """;

        while (true) {
            System.out.println(menu);
            int choice = getChoice(scan);

            if (choice == 0) {
                break;
            } else if (choice < 1 || choice > coffee.length) {
                System.out.print("Invalid input. Enter choice: ");
                scan.nextInt(); // Skip to the next iteration
            }

            int qty = getQuantity(scan);
            quantity[choice - 1] += qty; // Update the quantity array
            total += calculateTotal(choice, qty);
        }

        displayTotal(total);
        scan.close();
    }

    public static int getChoice(Scanner scan) {
        System.out.print("Choose your coffee (1-4, or 0 to finish): ");
        return scan.nextInt();
    }

    public static int getQuantity(Scanner scan) {
        System.out.print("Enter quantity: ");
        return scan.nextInt();
    }

    public static double calculateTotal(int choice, int quantity) {
        return coffeePrice[choice - 1] * quantity;
    }

    public static void displayTotal(double total) {
        double subtotal = 0;

        for (int i = 0; i < coffee.length; i++) {
            subtotal += quantity[i] * coffeePrice[i];
        }

        double vat = subtotal * 0.12;
        double grandTotal = subtotal + vat;

        receipt(coffee, coffeePrice, quantity);

        System.out.printf("Subtotal: %.2f\n", subtotal);
        System.out.printf("VAT (12%%): %.2f\n", vat);
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        System.out.println("-------------------------------");

        saveReceipt(subtotal, vat, grandTotal);

        System.out.println("Receipt saved to CoffeeReceipt.txt");
    }

    public static void receipt(String[] name, double[] price, int[] quantities) {
        System.out.println("----- RECEIPT -----");
        for (int i = 0; i < coffee.length; i++) {
            if (quantities[i] > 0) {
                System.out.printf("%d x %s @ %.2f each = %.2f\n", quantities[i], name[i], price[i], quantities[i] * price[i]);
            }
        }
        System.out.println("--------------------");
    }

    public static void saveReceipt(double subtotal, double vat, double grandTotal) {
        try (FileWriter writer = new FileWriter("CoffeeReceipt.txt")) {
            writer.write("----- Coffee Receipt -----\n");
            for (int i = 0; i < coffee.length; i++) {
                if (quantity[i] > 0) {
                    writer.write(String.format("%d x %s @ %.2f each = %.2f\n", quantity[i], coffee[i], coffeePrice[i], quantity[i] * coffeePrice[i]));
                }
            }
            writer.write("--------------------\n");
            writer.write(String.format("Subtotal: %.2f\n", subtotal));
            writer.write(String.format("VAT (12%%): %.2f\n", vat));
            writer.write(String.format("Grand Total: %.2f\n", grandTotal));
            writer.write("--------------------\n");
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}