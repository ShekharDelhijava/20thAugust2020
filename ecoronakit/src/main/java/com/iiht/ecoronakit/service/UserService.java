package com.iiht.ecoronakit.service;

import com.iiht.ecoronakit.dto.LoginDTO;
import com.iiht.ecoronakit.dto.UserDTO;
import com.iiht.ecoronakit.dto.UserResponseDTO;
import com.iiht.ecoronakit.exceptions.DataNotFoundException;
import com.iiht.ecoronakit.exceptions.DuplicateElementException;
import com.iiht.ecoronakit.models.User;

import org.springframework.http.ResponseEntity;


public interface UserService {

    String addUser(UserDTO dto) throws DuplicateElementException;

    String updateUser(UserDTO dto, Long userId) throws DataNotFoundException;

    UserResponseDTO findByUserId(Long userId);

    UserResponseDTO login(LoginDTO dto) throws DataNotFoundException;

    String deleteUser(Long userId);
}
