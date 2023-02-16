package com.mbds.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;
    private String illustration;
    private Double price;

    public Product(){

    }
    public Product(long id, String title, String description, String illustration, Double price){
         this.id = id;
         this.title = title;
         this.description = description;
         this.illustration = illustration;
         this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
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

    @Override
    public  String toString(){
        return  "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", illustration=" + illustration + '\'' +
                ", price=" + price +
                '}';
    }


}
