package com.example.model;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class ShopUser {
    public interface UserSummary {
    }
    public interface UserDetails extends UserSummary {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UserSummary.class,UserDetails.class})
    private Long id;

    @JsonView({UserSummary.class,UserDetails.class})
    @NotBlank(message = "Имя должно быть указано")
    private String name;

    @Email(message = "Неверный формат email")
    @JsonView({UserSummary.class, UserDetails.class})
    private String email;

    @OneToMany(mappedBy = "shopUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonView(UserDetails.class)
    private List<ShopOrder> orders;


    public ShopUser() {
    }

    public ShopUser(Long id, String name, String email, List<ShopOrder> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ShopOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ShopOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "ShopUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}