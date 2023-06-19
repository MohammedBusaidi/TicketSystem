package com.ticketSystem.ticketSystem.Services;

import com.ticketSystem.ticketSystem.Models.User;
import com.ticketSystem.ticketSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
