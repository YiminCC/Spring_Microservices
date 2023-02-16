package com.mbds.client.beans;

public class CartItemBean {

    private  long productId;
    private  String title;
    private  String description;
    private  String illustration;
    private  Double price;
    private  Integer quantity;

    public CartItemBean() {
    }

    public CartItemBean(long productId, String title, String description, String illustration, Double price, Integer quantity) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.illustration = illustration;
        this.price = price;
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId() {
        this.productId = productId;
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

    public String getIllustration() {
        return illustration;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
