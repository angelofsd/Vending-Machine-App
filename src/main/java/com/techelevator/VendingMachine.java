package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachine {
    private String slotCode;
    private String productName;
    private BigDecimal productPrice;
    private String productType;
    private int productQuantity=5;

    //Getters and Setters
    public String getSlotCode() {
        return slotCode;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setSlotCode(String slotCode) {
        this.slotCode = slotCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    private void loadVendingMachine(String filename) {


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
