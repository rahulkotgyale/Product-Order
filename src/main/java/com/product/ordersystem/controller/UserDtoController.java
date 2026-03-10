package com.product.ordersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.ordersystem.dto.UserDTO;
import com.product.ordersystem.service.UserDtoService;

@RestController
@RequestMapping("/api/users")
public class UserDtoController {

    @Autowired
    private UserDtoService userService;

    // CREATE USER
    @PostMapping
    public Object createUser(@RequestBody UserDTO userDTO) {

        try {
            return userService.createUser(userDTO);
        } catch (Exception e) {
            return "Error creating user: " + e.getMessage();
        }
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public Object getUserById(@PathVariable Long id) {

        try {
            return userService.getUserById(id);
        } catch (Exception e) {
            return "User not found: " + e.getMessage();
        }
    }

    // GET ALL USERS
    @GetMapping
    public Object getAllUsers() {

        try {
            List<UserDTO> users = userService.getAllUsers();
            return users;
        } catch (Exception e) {
            return "Error fetching users: " + e.getMessage();
        }
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public Object updateUser(@PathVariable Long id,
                             @RequestBody UserDTO userDTO) {

        try {
            return userService.updateUser(id, userDTO);
        } catch (Exception e) {
            return "Error updating user: " + e.getMessage();
        }
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public Object deleteUser(@PathVariable Long id) {

        try {
            userService.deleteUser(id);
            return "User deleted successfully";
        } catch (Exception e) {
            return "Error deleting user: " + e.getMessage();
        }
    }

}