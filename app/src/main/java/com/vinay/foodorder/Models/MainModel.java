package com.vinay.foodorder.Models;

public class MainModel {
    int foodimage;
    String foodname,foodPrice,fooddescription;

    public MainModel(int foodimage, String foodname, String foodPrice, String fooddescription) {
        this.foodimage = foodimage;
        this.foodname = foodname;
        this.foodPrice = foodPrice;
        this.fooddescription = fooddescription;
    }

    public int getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(int foodimage) {
        this.foodimage = foodimage;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFooddescription() {
        return fooddescription;
    }

    public void setFooddescription(String fooddescription) {
        this.fooddescription = fooddescription;
    }
}
