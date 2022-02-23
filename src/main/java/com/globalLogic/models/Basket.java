package com.globalLogic.models;

import java.util.Collections;
import java.util.List;

public class Basket {

    private List<Product> products;
    private double subTotalAmount;

    public Basket() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProduct (List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return products.get(0);
    }

    public void setProduct (Product product) {
        this.products = Collections.singletonList(product);
    }

    public double getSubTotalAmount() {
        return subTotalAmount;
    }

    public void setSubTotalAmount(double subTotalAmount) {
        this.subTotalAmount = subTotalAmount;
    }
}
