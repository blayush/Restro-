package com.example.boomshiva.Models;

public class OrderPageModel {
    int orderImg;
    String orderItemName,price,orderNumber;

    public OrderPageModel(int orderImg, String orderItemName, String price, String orderNumber) {
        this.orderImg = orderImg;
        this.orderItemName = orderItemName;
        this.price = price;
        this.orderNumber = orderNumber;
    }

    public OrderPageModel() {
    }

    public int getOrderImg() {
        return orderImg;
    }

    public void setOrderImg(int orderImg) {
        this.orderImg = orderImg;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
