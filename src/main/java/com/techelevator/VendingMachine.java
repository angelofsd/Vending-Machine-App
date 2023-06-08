package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {
    private int productQuantity=5;
    private List<Product> inventory = new ArrayList<>();

    private void loadVendingMachine(String filename) {


        try(Scanner inventoryScanner = new Scanner(new File(filename))) {

            while(inventoryScanner.hasNextLine()){
                String line = inventoryScanner.nextLine();
                String[] productInfo = line.split("\\|");
                String slotCode= productInfo[0];
                String productName= productInfo[1];
                BigDecimal productPrice= new BigDecimal(productInfo[2]);
                String productType= productInfo[3];
                Product product = new Product(slotCode, productName,productPrice,productType,productQuantity);
                inventory.add(product);
                //TODO put into a

            }
        }catch(IOException ex){
            System.out.println("Sorry an error occurred while loading the inventory");
        }



    }

    public VendingMachine() {
        loadVendingMachine("vendingmachine.csv");
    }

    //displayitems

    //feedmoney


}
