package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private final int FULL_QUANTITY = 5;
    private double balance = 0.0;
    private List<Product> inventory = new ArrayList<>();

     //Constructor
    public VendingMachine() {
        loadVendingMachine("vendingmachine.csv");
    }
    private void loadVendingMachine(String filename) {


        try(Scanner inventoryScanner = new Scanner(new File(filename))) {

            while(inventoryScanner.hasNextLine()){
                String line = inventoryScanner.nextLine();
                String[] productInfo = line.split("\\|");
                String slotCode= productInfo[0];
                String productName= productInfo[1];
                BigDecimal productPrice= new BigDecimal(productInfo[2]);
                String productType= productInfo[3];
                Product product = new Product(slotCode, productName,productPrice,productType,FULL_QUANTITY);
                inventory.add(product);
                //TODO put into a

            }
        }catch(IOException ex){
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
            System.out.println("Current Money Provided: " + balance);
            System.out.println("(1) Feed Money\n(2) Select Product \n(3) Finish Transaction");

            Scanner consoleInput = new Scanner(System.in);
            String choice = consoleInput.nextLine();
            int intChoice = Integer.parseInt(choice);
            if (intChoice == 1) {
                feedMoney();
            } if (intChoice == 2) {
                displayInventory();
                System.out.println("Please Enter the Product Code:");
                String codeInput = consoleInput.nextLine();

            } if (intChoice == 3) {
                feedMoney();
            }
        }

    }


public void feedMoney() {

    System.out.println("How much money(whole dollars) do you want to feed into the machine?");

    Scanner consoleInput = new Scanner(System.in);
    try {
        String choice = consoleInput.nextLine();
        int amount = Integer.parseInt(choice);

        balance += amount;
    } catch (NumberFormatException e) {
        System.out.println("Please Enter a Whole Dollar Amount!");
    }


}

public void displayInventory() {
    //TODO implement clear screen before menu
    for( Product product : inventory) {
        System.out.print("Slot Code: " + product.getSlotCode() + " Product Name: " + product.getProductName() +
                " Price: " + product.getProductPrice() + " Type: " + product.getProductType() + " Qantity: " +
                product.getProductQuantity());
        System.out.println("");

    }

    System.out.println("");
}


}
