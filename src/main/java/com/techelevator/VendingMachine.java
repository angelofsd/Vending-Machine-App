package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {
    private double balance = 0.0;
    private final int FULL_QUANTITY = 5;
    private List<Product> inventory = new ArrayList<>();
    private final int QUARTER = 25;
    private final int DIME = 10;
    private final int NICKEL = 5;
    private final int PENNY = 1;

    //Constructor
    public VendingMachine() {
        loadVendingMachine("vendingmachine.csv");
    }

    //Getters and Setters
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

    private void loadVendingMachine(String filename) {
        try {
            PrintWriter fileWriter = new PrintWriter(new File("log.txt"));
        } catch (Exception e) {
            System.out.println("Something went wrong writing to file.");
        }


        try (Scanner inventoryScanner = new Scanner(new File(filename))) {

            while (inventoryScanner.hasNextLine()) {
                String line = inventoryScanner.nextLine();
                String[] productInfo = line.split("\\|");
                String slotCode = productInfo[0];
                String productName = productInfo[1];
                double productPrice = Double.parseDouble(productInfo[2]);
                String productType = productInfo[3];
                Product product = new Product(slotCode, productName, productPrice, productType, FULL_QUANTITY);
                inventory.add(product);
                //TODO put into a

            }
        } catch (IOException ex) {
            System.out.println("Sorry an error occurred while loading the inventory");
        }

    }

    public void displayItems() {
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    public void purchaseMenu() {
        Logger logger = new Logger(this);
        while (true) {
            Transaction currentTransaction = new Transaction(this);
            System.out.println("Current Money Provided: " + balance);
            System.out.println("(1) Feed Money\n(2) Select Product \n(3) Finish Transaction");

            Scanner consoleInput = new Scanner(System.in);

            //TODO: surround with try catch block for NumberFormatException
            try{
                String choice = consoleInput.nextLine();
                int intChoice = Integer.parseInt(choice);
                if (intChoice == 1) {
                    logger.log(currentTransaction.feedMoney(),balance, "FEED MONEY");
                }else if (intChoice == 2) {
                    displayInventory();
                    Product selectedProduct = currentTransaction.productPurchase();
                    if(selectedProduct != null){
                        logger.log(selectedProduct.getProductPrice(),balance,selectedProduct.getProductName());;
                    }
                }else if (intChoice == 3) {
                    displayCoins();
                    logger.log(balance,0,"GIVE CHANGE");
                    balance = 0;
                    break;
                }
            }catch(NumberFormatException ex){
                System.out.println("You did not enter a number. Please try again.");
            }

        }

    }

    private void displayCoinsLeft(){
        int remainingPennies = (int)Math.round(balance * 100);
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        if(remainingPennies >= QUARTER) {
            quarters = remainingPennies / QUARTER;
            remainingPennies %= QUARTER;
        }
        if(remainingPennies >= DIME){
            dimes = remainingPennies / DIME;
            remainingPennies %= DIME;
        }
        if(remainingPennies >=NICKEL){
            nickels = remainingPennies / NICKEL;
        }

        System.out.println("Thank you for choosing Vendo-Matic 800. Your CHANGE is: " + balance);
        System.out.println();
        System.out.println("Quarters: " + quarters);
        System.out.println("--------------------------");
        System.out.println("Dimes: " + dimes);
        System.out.println("--------------------------");
        System.out.println("Nickels: " + nickels);
        System.out.println("--------------------------");

    }
    private void displayCoins(){
        String[] balanceStrArr = String.valueOf(balance).split("\\.");
        String penniesAfterDollarsStr = balanceStrArr[1].length() == 1 ? balanceStrArr[1]+="0" : balanceStrArr[1];
        int penniesAfterDollarAmount = Integer.parseInt(penniesAfterDollarsStr);
        int dollars = (int)balance;
        int quarters = penniesAfterDollarAmount / QUARTER;
        penniesAfterDollarAmount %= QUARTER;
        int dimes = penniesAfterDollarAmount / DIME;
        penniesAfterDollarAmount %= DIME;
        int nickels = penniesAfterDollarAmount / NICKEL;
        penniesAfterDollarAmount %= NICKEL;
        int pennies = penniesAfterDollarAmount / PENNY;

        System.out.println("Thank you for choosing Vendo-Matic 800. Your CHANGE is: " + balance);
        System.out.println();
        System.out.println("Dollars: " + dollars);
        System.out.println("--------------------------");
        System.out.println("Quarters: " + quarters);
        System.out.println("--------------------------");
        System.out.println("Dimes: " + dimes);
        System.out.println("--------------------------");
        System.out.println("Nickels: " + nickels);
        System.out.println("--------------------------");
        System.out.println("Pennies: " + pennies);
        System.out.println("--------------------------");

    }



    public Product getProductByCode(String code) {

        for (Product product : inventory) {
            if (product.getSlotCode().equalsIgnoreCase(code)) {
                return product;
            }
        }

        return null;
    }

    public void displayInventory() {
        //TODO implement clear screen before menu
        for (Product product : inventory) {
            System.out.print("Slot Code: " + product.getSlotCode() + " Product Name: " + product.getProductName() +
                    " Price: " + product.getProductPrice() + " Type: " + product.getProductType() + " Qantity: " +
                    product.getProductQuantity());
            System.out.println("");

        }

        System.out.println("");
    }


}
