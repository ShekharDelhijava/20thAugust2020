package com.iiht.ecoronakit.service.serviceimpl;

import com.iiht.ecoronakit.dto.AddressDTO;
import com.iiht.ecoronakit.dto.LoginDTO;
import com.iiht.ecoronakit.dto.UserDTO;
import com.iiht.ecoronakit.dto.UserResponseDTO;
import com.iiht.ecoronakit.enums.Role;
import com.iiht.ecoronakit.exceptions.DataNotFoundException;
import com.iiht.ecoronakit.exceptions.DuplicateElementException;
import com.iiht.ecoronakit.models.Address;
import com.iiht.ecoronakit.models.User;
import com.iiht.ecoronakit.repositories.UserRepository;
import com.iiht.ecoronakit.service.UserService;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Override
	public String addUser(UserDTO dto) throws DuplicateElementException {

		return "SUCCESS";

	}

	@Override
	public String updateUser(UserDTO dto, Long userId) throws DataNotFoundException {

		return "SUCCESS";

	}

	@Override
	public UserResponseDTO findByUserId(Long userId) {
		return userResponseDTO;
	}

	@Override
	public UserResponseDTO login(LoginDTO dto) throws DataNotFoundException {

		User user = userRepository.findByUsername(dto.getUsername());

		UserResponseDTO userResponseDTO = dozerBeanMapper.map(user, UserResponseDTO.class);
		return userResponseDTO;

	}

	@Override
	public String deleteUser(Long userId) {

		userRepository.delete(userId);
		return "SUCCESS";
	}

}
