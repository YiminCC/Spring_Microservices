package com.mbds.client.beans;

import java.util.List;

public class OrderBean {

    private long id;
    private double priceTotal;
    private List<OrderItemBean> items;

    public OrderBean() {
    }

    public OrderBean(long id, double priceTotal, List<OrderItemBean> items) {
        this.id = id;
        this.priceTotal = priceTotal;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public List<OrderItemBean> getItems() {
        return items;
    }

    public void setItems(List<OrderItemBean> items) {
        this.items = items;
    }
}
