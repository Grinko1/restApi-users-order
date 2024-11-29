package com.example.service;

import com.example.model.ShopUser;
import com.example.repository.UserRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<ShopUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ShopUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public ShopUser createUser(ShopUser user) {
        return userRepository.save(user);
    }

    @Transactional
    public ShopUser updateUser(Long id, ShopUser userDetails) {
        ShopUser user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);

    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
