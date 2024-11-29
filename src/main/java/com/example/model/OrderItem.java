package com.example.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private ShopOrder order;
    @JsonView(ShopUser.UserDetails.class)
    private String productName;
    @JsonView(ShopUser.UserDetails.class)
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Long id, ShopOrder order, String productName, Double price) {
        this.id = id;
        this.order = order;
        this.productName = productName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShopOrder getOrder() {
        return order;
    }

    public void setOrder(ShopOrder order) {
        this.order = order;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}