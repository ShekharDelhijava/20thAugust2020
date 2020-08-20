package com.iiht.ecoronakit.controllers;

import com.iiht.ecoronakit.dto.*;
import com.iiht.ecoronakit.exceptions.DataNotFoundException;
import com.iiht.ecoronakit.exceptions.DuplicateElementException;
import com.iiht.ecoronakit.service.UserCartService;
import com.iiht.ecoronakit.service.UserService;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@Api("user")
@ApiModel("All User related operations")
public class UserController {


    @Autowired
    private UserService userService;

    @ApiOperation(value = "User Sign Up", notes = "This api is used to sign up user", httpMethod = "POST")
    @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
            @ApiResponse(code = 401, message = "UnAuthorized") })
    @PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addProduct(@RequestBody UserDTO dto) throws DuplicateElementException {
        return new ResponseEntity<SuccessResponseDTO>(new SuccessResponseDTO(userService.addUser(dto)), HttpStatus.CREATED);
    }



//    @ApiOperation(value = "User Login", notes = "This api is used login", httpMethod = "POST")
//    @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
//            @ApiResponse(code = 401, message = "UnAuthorized") })
//    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<?> login(@RequestBody LoginDTO dto) throws DuplicateElementException, DataNotFoundException {
//        return new ResponseEntity<UserResponseDTO>(userService.login(dto), HttpStatus.CREATED);
//    }





}
