package com.ticketSystem.ticketSystem.Services;

import com.ticketSystem.ticketSystem.Models.User;
import com.ticketSystem.ticketSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Long createUser(User user) {
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedDate(now);
        user.setActive(true);
        userRepository.save(user);
        return user.getId();
    }
}
