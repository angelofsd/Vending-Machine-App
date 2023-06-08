package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {
    private double balance = 0.0;
    private final int FULL_QUANTITY = 5;
    private List<Product> inventory = new ArrayList<>();

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
        while (true) {
            Transaction currentTransaction = new Transaction(this);
            System.out.println("Current Money Provided: " + balance);
            System.out.println("(1) Feed Money\n(2) Select Product \n(3) Finish Transaction");

            Scanner consoleInput = new Scanner(System.in);
            String choice = consoleInput.nextLine();
            int intChoice = Integer.parseInt(choice);
            if (intChoice == 1) {
                currentTransaction.feedMoney();
            }
            if (intChoice == 2) {
                displayInventory();
                currentTransaction.productPurchase();

            }
            if (intChoice == 3) {
                System.out.println("Thank you for choosing Vendo-Matic 800. Your CHANGE is: " + balance);
                break;
            }
        }

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
