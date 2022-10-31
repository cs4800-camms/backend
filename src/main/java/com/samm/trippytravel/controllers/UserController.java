package com.samm.trippytravel.controllers;

import com.samm.trippytravel.data.requests.user.CreateUserRequest;
import com.samm.trippytravel.data.requests.user.UpdateUserRequest;
import com.samm.trippytravel.data.response.UserResponse;
import com.samm.trippytravel.repository.UserRepository;
import com.samm.trippytravel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<UserResponse> createUser(
            @RequestBody CreateUserRequest createUserRequest) {
        return new ResponseEntity<>(userService.addUser(createUserRequest), HttpStatus.OK);
    }

    @PostMapping("{userIdNumber}/update")
    @ResponseBody
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable("userIdNumber") String userIdNumber,
            @RequestBody UpdateUserRequest updateUserRequest) {
        return new ResponseEntity<>(userService.updateUser(userIdNumber, updateUserRequest), HttpStatus.OK);
    }

    @DeleteMapping("{userIdNumber}")
    @ResponseBody
    public ResponseEntity<UserResponse> deleteUser(
            @PathVariable("userIdNumber") String userIdNumber) {
        return new ResponseEntity<>(userService.deleteUser(userIdNumber), HttpStatus.OK);
    }

    @DeleteMapping("/delete-all")
    public void delete() {
        userRepository.deleteAll();
    }
}
