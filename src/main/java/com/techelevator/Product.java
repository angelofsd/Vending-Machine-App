package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Product {
    private String slotCode;
    private String productName;
    private double productPrice;
    private String productType;
    private Integer productQuantity;

    //Constructor
    public Product(String slotCode, String productName, double productPrice, String productType, Integer productQuantity) {
        this.slotCode = slotCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productQuantity = productQuantity;
    }


    //Getters and Setters
    public String getSlotCode() {
        return slotCode;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setSlotCode(String slotCode) {
        this.slotCode = slotCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
    @Override
    public String toString() {
        return "\nProduct: " + this.productName + " Quantity: " + this.productQuantity;
    }

    public String getSound(){
        switch (productType){
            case "Chip":
                return "Crunch Crunch, Yum!";
            case "Candy":
                return "Munch Munch, Yum!";
            case "Drink":
                return "Glug Glug, Yum!";
            case "Gum":
                return "Chew Chew, Yum!";
        }
        return null;
    }

}
