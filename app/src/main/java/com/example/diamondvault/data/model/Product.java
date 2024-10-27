package com.example.diamondvault.data.model;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("name")
    private String title;
    @SerializedName("sku")
    private String sku;
    @SerializedName("category")
    private String category;
    @SerializedName("metal_type")
    private String metalType;
    @SerializedName("wholesale_price")
    private String price;
    @SerializedName("size")
    private String size;
    @SerializedName("description")
    private String description;
    @SerializedName("quantity")
    private String quantity;
    @SerializedName("current_silver_price")
    private String addedSilverPrice;
    @SerializedName("current_gold_price")
    private String addedGoldPrice;
    @SerializedName("retail_price")
    private String retailPrice;

    // Add getters and setters as needed


    public Product(String title, String sku, String category, String metalType, String price, String size, String description, String quantity, String addedSilverPrice, String addedGoldPrice, String retailPrice) {
        this.title = title;
        this.sku = sku;
        this.category = category;
        this.metalType = metalType;
        this.price = price;
        this.size = size;
        this.description = description;
        this.quantity = quantity;
        this.addedSilverPrice = addedSilverPrice;
        this.addedGoldPrice = addedGoldPrice;
        this.retailPrice = retailPrice;
    }

    public String getAddedSilverPrice() {
        return addedSilverPrice;
    }

    public void setAddedSilverPrice(String addedSilverPrice) {
        this.addedSilverPrice = addedSilverPrice;
    }

    public String getAddedGoldPrice() {
        return addedGoldPrice;
    }

    public void setAddedGoldPrice(String addedGoldPrice) {
        this.addedGoldPrice = addedGoldPrice;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Product(String title,String sku, String category, String metalType, String price, String size, String description, String quantity) {
        this.title = title;
        this.sku = sku;
        this.category = category;
        this.metalType = metalType;
        this.price = price;
        this.size = size;
        this.description = description;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMetalType() {
        return metalType;
    }

    public void setMetalType(String metalType) {
        this.metalType = metalType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


}
