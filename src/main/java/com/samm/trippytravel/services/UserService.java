package com.samm.trippytravel.services;

import com.samm.trippytravel.data.domain.User;
import com.samm.trippytravel.data.requests.user.CreateUserRequest;
import com.samm.trippytravel.data.requests.user.UpdateUserRequest;
import com.samm.trippytravel.data.response.UserResponse;
import com.samm.trippytravel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserRepository userRepository;

    public UserResponse addUser(CreateUserRequest createUserRequest) {
        return toUserResponse(userRepository.insert(User.builder()
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .build()));
    }

    public UserResponse updateUser(String userIdNumber, UpdateUserRequest updateUserRequest) {
        return toUserResponse(userRepository.save(User.builder()
                ._id(userIdNumber)
                .firstName(updateUserRequest.getFirstName())
                .lastName(updateUserRequest.getLastName())
                .email(updateUserRequest.getEmail())
                .password(updateUserRequest.getPassword())
                .build()));
    }

    private UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                ._id(user.get_id())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
