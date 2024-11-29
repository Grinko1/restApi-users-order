package com.example.controller;
import com.example.model.ShopUser;
import com.example.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @JsonView(ShopUser.UserSummary.class)
    public List<ShopUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @JsonView(ShopUser.UserDetails.class)
    public ResponseEntity<ShopUser> getUserById(@PathVariable Long id) {
       ShopUser user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    @JsonView(ShopUser.UserSummary.class)
    public ResponseEntity<ShopUser> createUser(@Valid @RequestBody ShopUser user) {
        ShopUser createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @JsonView(ShopUser.UserSummary.class)
    public ResponseEntity<ShopUser> updateUser(@PathVariable Long id, @Valid @RequestBody ShopUser user) {
        ShopUser updatedUser = userService.updateUser(id, user);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
