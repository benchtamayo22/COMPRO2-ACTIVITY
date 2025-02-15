package org.btamayo;

import java.util.Arrays;

    public class CoffeeObject {

        public String name;
        public String type;
        public String size;
        public double price;
        public String roastLevel;
        public String origin;
        public boolean isDecaf;
        public int stock;
        public String[] flavorNotes;
        public String brewMethod;

        public CoffeeObject(String name, String type, String size, double price, String roastLevel, String origin, boolean isDecaf, int stock, String[] flavorNotes, String brewMethod) {
            this.name = name;
            this.type = type;
            this.size = size;
            this.price = price;
            this.roastLevel = roastLevel;
            this.origin = origin;
            this.isDecaf = isDecaf;
            this.stock = stock;
            this.flavorNotes = flavorNotes;
            this.brewMethod = brewMethod;
        }

  
        public double calculatePrice(String size) {
         
            return 0.0;
        }

        public boolean checkStock() {
            return stock > 0;
        }

        public void addFlavor(String note) {
        
        }

        public void updateStock(int quantity) {
            stock += quantity;
        }

        public String describe() {
            return "A " + roastLevel + " roast coffee with " + Arrays.toString(flavorNotes) + " notes.";
        }

        public void setDecaf(boolean isDecaf) {
            this.isDecaf = isDecaf;
        }

        public void changeRoastLevel(String newRoastLevel) {
            roastLevel = newRoastLevel;
        }

        public void discount(int percentage) {
            price -= (price * percentage / 100);
        }
    }
