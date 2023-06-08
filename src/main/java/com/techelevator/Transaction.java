package com.techelevator;

import java.util.Scanner;

public class Transaction {
    private final double NICKEL = 0.05;
    private final double DIME = 0.10;
    private final double QUARTER = 0.25;

    public void productPurchase(VendingMachine vendingMachine) {
        while (true) {
            Scanner consoleInput = new Scanner(System.in);
            System.out.println("Please Enter the Product Code:");
            String codeInput = "";
            codeInput = consoleInput.nextLine();

            Product chosenProduct = vendingMachine.getProductByCode(codeInput);
            if (chosenProduct == null) {
                System.out.println("Please retry with a valid Product Code");
            }
            if (chosenProduct.getProductQuantity() > 0) {
                vendingMachine.setBalance(vendingMachine.getBalance()- chosenProduct.getProductPrice());
                chosenProduct.setProductQuantity(chosenProduct.getProductQuantity() - 1);
                System.out.println("Enjoy your " + chosenProduct.getProductName() + "! " + chosenProduct.getSound());
                break;
            } else {
                System.out.println("We're sorry but the chosen product is currently OUT OF STOCK");
            }
        }
    }

    public void feedMoney() {

        System.out.println("How much money(whole dollars) do you want to feed into the machine?");

        Scanner consoleInput = new Scanner(System.in);
        try {
            String choice = consoleInput.nextLine();
            int amount = Integer.parseInt(choice);

            vendingMachine.setBalance += amount;
        } catch (NumberFormatException e) {
            System.out.println("Please Enter a Whole Dollar Amount!");
        }


    }
}
