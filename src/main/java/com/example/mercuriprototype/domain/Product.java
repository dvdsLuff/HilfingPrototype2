package com.example.mercuriprototype.domain;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "stocknumber")
    private int stocknumber;

    public Product() {
    }

    public Product(int id, String name, int stocknumber, int price) {
        this.id=id;
        this.name=name;
        this.stocknumber=stocknumber;
        this.price=price;
    }

    public int getId() {
        return id;
    }

    public Product(String name, int price, int stocknumber) {
        this.name = name;
        this.price = price;
        this.stocknumber = stocknumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStocknumber() {
        return stocknumber;
    }

    public void setStocknumber(int stocknumber) {
        this.stocknumber = stocknumber;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stocknumber=" + stocknumber +
                '}';
    }

}

