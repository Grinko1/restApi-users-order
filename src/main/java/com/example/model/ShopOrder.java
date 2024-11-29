package com.example.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ShopOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @JsonView(ShopUser.UserDetails.class)
    private Double totalAmount;
    @JsonView(ShopUser.UserDetails.class)
    private String status;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonView(ShopUser.UserDetails.class)
    private List<OrderItem> products;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private ShopUser shopUser;

    public ShopOrder() {
    }

    public ShopOrder(Long id,String status, List<OrderItem> items, ShopUser shopUser) {
        this.id = id;

        this.status = status;
        this.products = items;
        this.shopUser = shopUser;
        this.totalAmount = calcTotalAmount(products);
    }

    private Double calcTotalAmount (List<OrderItem> items){
        return  items.stream()
                .mapToDouble(OrderItem::getPrice)
                .sum();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShopUser getShopUser() {
        return shopUser;
    }

    public void setShopUser(ShopUser shopUser) {
        this.shopUser = shopUser;
    }

}
