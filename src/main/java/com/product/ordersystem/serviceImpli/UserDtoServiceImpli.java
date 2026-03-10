package com.product.ordersystem.serviceImpli;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.product.ordersystem.dto.UserDTO;
import com.product.ordersystem.exception.ResourceNotFoundException;
import com.product.ordersystem.service.UserDtoService;

@Service
public class UserDtoServiceImpli implements UserDtoService {

    private List<UserDTO> users = new ArrayList<>();

    // CREATE USER
    @Override
    public UserDTO createUser(UserDTO userDTO) {

        userDTO.setId((long) (users.size() + 1));
        users.add(userDTO);

        return userDTO;
    }

    // GET USER BY ID
    @Override
    public UserDTO getUserById(Long id) {

        for (UserDTO user : users) {

            if (user.getId().equals(id)) {
                return user;
            }
        }

        throw new ResourceNotFoundException("User not found with id: " + id);
    }

    // GET ALL USERS
    @Override
    public List<UserDTO> getAllUsers() {

        return users;
    }

    // UPDATE USER
    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {

        for (UserDTO user : users) {

            if (user.getId().equals(id)) {

                user.setName(userDTO.getName());
                user.setEmail(userDTO.getEmail());
                user.setPassword(userDTO.getPassword());
                user.setRole(userDTO.getRole());

                return user;
            }
        }

        throw new ResourceNotFoundException("User not found with id: " + id);
    }

    // DELETE USER
    @Override
    public void deleteUser(Long id) {

        boolean removed = users.removeIf(user -> user.getId().equals(id));

        if (!removed) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }

    }

}