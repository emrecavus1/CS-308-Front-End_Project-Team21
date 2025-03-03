package com.team21.backend.services;

import com.team21.backend.models.User;
import com.team21.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}