package com.permissions.demo.service;

import com.permissions.demo.dto.AuthSystemUserDTO;
import com.permissions.demo.model.User;
import com.permissions.demo.repository.UserRepository;
import com.permissions.demo.util.UserDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public AuthSystemUserDTO getUserById(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return UserDTOMapper.mapToDTO(user);
    }

}
