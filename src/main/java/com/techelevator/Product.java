package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Product {
    private String slotCode;
    private String productName;
    private BigDecimal productPrice;
    private String productType;
    private Integer productQuantity;

    //Constructor
    public Product(String slotCode, String productName, BigDecimal productPrice, String productType, Integer productQuantity) {
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

    public BigDecimal getProductPrice() {
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

    public void setProductPrice(BigDecimal productPrice) {
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

}
