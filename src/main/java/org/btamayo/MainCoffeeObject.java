package org.btamayo;

public class MainCoffeeObject {
    public static void main(String[] args) {
        String[] flavorNotes1 = {"Chocolate", "Nutty"};
        CoffeeObject coffee1 = new CoffeeObject("Espresso", "Arabica", "Small", 3.99, "Dark", "Italy", false, 50, flavorNotes1, "Espresso");

        // Calling methods of the first coffee object
        System.out.println("Coffee Name: " + coffee1.name);
        System.out.println("Is in stock: " + coffee1.checkStock());
        coffee1.addFlavor("Citrus");
        System.out.println("Updated Description: " + coffee1.describe());

        // Creating and calling methods for the second coffee object
        String[] flavorNotes2 = {"Caramel", "Fruity"};
        CoffeeObject coffee2 = new CoffeeObject("Latte", "Robusta", "Large", 5.99, "Medium", "Brazil", true, 30, flavorNotes2, "Drip");
        System.out.println("Coffee Name: " + coffee2.name);
        coffee2.discount(10);
        System.out.println("Price after 10% discount: " + coffee2.price);
    }
}
