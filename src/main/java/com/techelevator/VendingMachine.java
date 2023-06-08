package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private final int FULL_QUANTITY = 5;
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




    //feedmoney


}
