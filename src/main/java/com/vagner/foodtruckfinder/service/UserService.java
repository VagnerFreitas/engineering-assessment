package com.vagner.foodtruckfinder.service;

import com.vagner.foodtruckfinder.exception.UserAlreadyExistsException;
import com.vagner.foodtruckfinder.model.User;
import com.vagner.foodtruckfinder.model.dto.UserNewDto;
import com.vagner.foodtruckfinder.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder encoder;
    public User fromDto(UserNewDto dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    public void insert(User user) throws UserAlreadyExistsException {
        if (findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists!");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
