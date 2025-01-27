package com.vinay.foodorder.Models;

public class OrderDetail {
    int id,image,price,quantity;
    String fooadname,fooddescription,name,mobile;

    public OrderDetail(int id, int image, int price, int quantity, String fooadname, String fooddescription, String name, String mobile) {
        this.id = id;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.fooadname = fooadname;
        this.fooddescription = fooddescription;
        this.name = name;
        this.mobile = mobile;
    }
    public  OrderDetail(String foodname)
    {
        this.fooadname=foodname;
    }
    public OrderDetail() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFooadname() {
        return fooadname;
    }

    public void setFooadname(String fooadname) {
        this.fooadname = fooadname;
    }

    public String getFooddescription() {
        return fooddescription;
    }

    public void setFooddescription(String fooddescription) {
        this.fooddescription = fooddescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
