package com.example.controller;

import static org.mockito.Mockito.*;

import com.example.service.UserService;
import com.example.model.ShopUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testGetAllUsers() throws Exception {
        ShopUser user = new ShopUser();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        when(userService.getAllUsers()).thenReturn(List.of(user));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("john.doe@example.com"));

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testCreateUser() throws Exception {
        ShopUser user = new ShopUser();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        when(userService.createUser(any(ShopUser.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john.doe@example.com"));

        verify(userService, times(1)).createUser(any(ShopUser.class));
    }
}