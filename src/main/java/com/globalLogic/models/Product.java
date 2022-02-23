package com.globalLogic.models;

import java.util.List;

public class Product {

    private String productName;
    private String productPrice;
    private String processor;
    private String ram;
    private List<String> softwares;

    public Product() {
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public List<String> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(List<String> softwares) {
        this.softwares = softwares;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

}
