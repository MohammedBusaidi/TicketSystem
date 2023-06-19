package com.ticketSystem.ticketSystem.Repositories;

import com.ticketSystem.ticketSystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
