package com.product.ordersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.ordersystem.dto.UserDTO;

@Service
public interface UserDtoService {

	UserDTO createUser(UserDTO userDTO);

	UserDTO getUserById(Long id);

	List<UserDTO> getAllUsers();

	UserDTO updateUser(Long id, UserDTO userDTO);

	void deleteUser(Long id);

}
