package com.ticketSystem.ticketSystem.Models;

import com.ticketSystem.ticketSystem.BaseEntity.BaseEntity;
import com.ticketSystem.ticketSystem.Enum.Role;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets;
}