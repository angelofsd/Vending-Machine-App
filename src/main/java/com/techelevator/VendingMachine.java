package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachine {

    private void loadVendingMachine(String filename) {
        String slotCode;
        String productName;
        BigDecimal productPrice;
        String productType;

        try(Scanner inventoryScanner = new Scanner(new File(filename))) {
            while(inventoryScanner.hasNextLine()){
                String line = inventoryScanner.nextLine();
                String[] productInfo = line.split("\\|");
                slotCode= productInfo[0];
                productName= productInfo[1];
                productPrice= new BigDecimal(productInfo[2]);
                productType= productInfo[3];

            }
        }catch(Exception ex){

        }


    }

    public VendingMachine {
        loadVendingMachine("vendingmachine.csv");
    }

    //displayitems

    //feedmoney


}
