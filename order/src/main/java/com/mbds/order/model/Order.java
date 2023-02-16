package com.mbds.order.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.TypeAlias;

import java.util.List;

@Entity
@Table(name = "Commande")
public class Order {
    @Id
    @GeneratedValue
    private long id;
    private  double priceTotal;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Order() {
    }

    public Order(long id,double priceTotal, List<OrderItem> items) {
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

    public List<OrderItem> getItems() {
        return items;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public void addItems(OrderItem item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", priceTotal=" + priceTotal +
                ", items=" + items +
                '}';
    }
}
