package calculator;
import java.text.DecimalFormat;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map;

public class Main {


        public static class Product {
            private String name;
            private double earnedAmount;

            public Product(String name, double earnedAmount) {
                this.name = name;
                this.earnedAmount = earnedAmount;
            }

            public String getName() {
                return name;
            }

            public double getEarnedAmount() {
                return earnedAmount;
            }

            public void setEarnedAmount(double earnedAmount) {
                this.earnedAmount = earnedAmount;
            }

            @Override
            public String toString() {
                DecimalFormat df = new DecimalFormat("0.#");
                return this.name + ": $" + df.format(this.earnedAmount);
            }
        }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> productsInfo = new LinkedHashMap<>();
        productsInfo.putIfAbsent("Bubblegum", new Product("Bubblegum", 202));
        productsInfo.putIfAbsent("Toffee", new Product("Toffee", 118));
        productsInfo.putIfAbsent("Ice cream", new Product("Ice cream", 2250));
        productsInfo.putIfAbsent("Milk chocolate", new Product("Milk chocolate", 1680));
        productsInfo.putIfAbsent("Doughnut", new Product("Doughnut", 1075));
        productsInfo.putIfAbsent("Pancake", new Product("Pancake", 80));

        double totalIncome = getTotalAmount(productsInfo);
        System.out.println("Earned amount:");
        for (String name : productsInfo.keySet()) {
            Product product = productsInfo.get(name);
            System.out.println(product.toString());
        }
        System.out.println();
        System.out.println("Income: $" + totalIncome);
        System.out.println("Staff expenses:");
        String staffExpense = scanner.nextLine();
        double staffExpenses = Double.parseDouble(staffExpense);
        System.out.println("Other expenses:");
        String otherExpense = scanner.nextLine();
        double otherExpenses = Double.parseDouble(otherExpense);
        double netIncome = totalIncome - staffExpenses - otherExpenses;
        System.out.println("Net income: $" + netIncome);
    }

    private static double getTotalAmount(Map<String, Product> productsInfo) {
        double totalIncome = 0;
        for (String name : productsInfo.keySet()) {
            Product product = productsInfo.get(name);
            totalIncome += product.getEarnedAmount();
        }
        return totalIncome;
    }
}