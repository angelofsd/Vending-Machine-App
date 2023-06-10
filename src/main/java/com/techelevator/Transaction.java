package com.techelevator;

import java.util.Scanner;

public class Transaction {


    VendingMachine vendingMachine;

    //Constructor
    public Transaction(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public Product productPurchase() {
        while (true) {
            Scanner consoleInput = new Scanner(System.in);
            System.out.println("Please Enter the Product Code:");
            String codeInput = consoleInput.nextLine();
            Product chosenProduct = vendingMachine.getProductByCode(codeInput);
            if (chosenProduct == null) {
                System.out.println("Please retry with a valid Product Code");
            }else if (chosenProduct.getProductQuantity() < 1) {
                System.out.println("We're sorry but the chosen product is currently OUT OF STOCK");
            }else if(vendingMachine.getBalance() < chosenProduct.getProductPrice()){
                System.out.println("You did not enter enough money to buy " + chosenProduct.getProductName());
                return null;
            } else{
                vendingMachine.setBalance((vendingMachine.getBalance() - chosenProduct.getProductPrice()));
                vendingMachine.setBalance(Double.parseDouble(String.format("%.2f",vendingMachine.getBalance()))); //makes sure the balance is always at 2 decimal places no matter what
                chosenProduct.setProductQuantity(chosenProduct.getProductQuantity() - 1);
                System.out.println("Enjoy your " + chosenProduct.getProductName() + "! " + chosenProduct.getSound());
                return chosenProduct;
            }
        }
    }

    public int feedMoney() {

        //TODO surround with while(true) loop

        while(true){
            System.out.println("How much money(whole dollars) do you want to feed into the machine?");

            Scanner consoleInput = new Scanner(System.in);
            try {
                String choice = consoleInput.nextLine();
                int amount = Integer.parseInt(choice);
                if(amount<=0){
                    throw new IllegalArgumentException ("Amount must be a positive number");
                }
                vendingMachine.setBalance(vendingMachine.getBalance() + amount);
                vendingMachine.setBalance(Double.parseDouble(String.format("%.2f",vendingMachine.getBalance()))); //makes sure the balance is always at 2 decimal places no matter what
                return amount;
            } catch (IllegalArgumentException ex){
                System.out.println("That is not a valid input.");
            }
        }


    }

}
