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


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public String addUser(UserDTO dto) throws DuplicateElementException {



        User userEsist = userRepository.findByUsername(dto.getUsername());
        if(userEsist == null) {
            User user  = new User();
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setRole(Role.valueOf(dto.getRole()));
            // Embedded Object
            Address address = new Address();
            AddressDTO addressDTO = dto.getAddresses();
            address.setCity(addressDTO.getCity());
            address.setLandmark(addressDTO.getLandmark());
            address.setPhoneNumber(addressDTO.getPhoneNumber());
            address.setPostboxNo(addressDTO.getPostboxNo());
            address.setZipcode(addressDTO.getZipcode());
            user.setAddress(address);
            user.setEmail(dto.getEmail());
            user.setUsername(dto.getUsername());
            user.setPassword(dto.getPassword());
            userRepository.save(user);
            return "SUCCESS";
        } else {
            throw new DuplicateElementException("User with username "+ dto.getUsername()+ " already present");
        }




    }

    @Override
    public String updateUser(UserDTO dto, Long userId) throws DataNotFoundException {

        User user = userRepository.findOne(userId);

        if(user != null) {
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setRole(Role.valueOf(dto.getRole()));
            Address address = user.getAddress();
            AddressDTO addressDTO = dto.getAddresses();
            address.setCity(addressDTO.getCity());
            address.setLandmark(addressDTO.getLandmark());
            address.setPhoneNumber(addressDTO.getPhoneNumber());
            address.setPostboxNo(addressDTO.getPostboxNo());
            address.setZipcode(addressDTO.getZipcode());
            user.setAddress(address);
            user.setEmail(dto.getEmail());
            user.setUsername(dto.getUsername());
            user.setPassword(dto.getPassword());
            userRepository.flush();
            return "SUCCESS";

        } else {
            throw new DataNotFoundException("User Not Found");
        }

    }

    @Override
    public UserResponseDTO findByUserId(Long userId) {

        User user = userRepository.findById(userId);
        return dozerBeanMapper.map(user, UserResponseDTO.class);
    }



    @Override
    public UserResponseDTO login(LoginDTO dto) throws DataNotFoundException {

        User user = userRepository.findByUsername(dto.getUsername());
        System.out.println("USER ----------------------------------------------------------------->"+user);
        if(user != null) {
            UserResponseDTO userResponseDTO = dozerBeanMapper.map(user, UserResponseDTO.class);
            return  userResponseDTO;

        } else {
            throw new DataNotFoundException("User Not Found");
        }
    }

    @Override
    public String deleteUser(Long userId) {

        userRepository.delete(userId);
        return "SUCCESS";
    }

}
