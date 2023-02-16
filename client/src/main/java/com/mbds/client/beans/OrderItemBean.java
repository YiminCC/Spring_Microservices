package com.mbds.client.beans;

import java.util.List;

public class OrderItemBean {
    private long cartItemId;
    private String title;
    private String description;
    private String illustration;
    private Double price;
    private Integer quantity;

    public OrderItemBean(List<CartItemBean> items) {
    }

    public OrderItemBean(long cartItemId, String title, String description, String illustration, Double price, Integer quantity) {
        this.cartItemId = cartItemId;
        this.title = title;
        this.description = description;
        this.illustration = illustration;
        this.price = price;
        this.quantity = quantity;
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
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
