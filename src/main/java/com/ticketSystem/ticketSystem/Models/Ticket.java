package com.ticketSystem.ticketSystem.Models;

import com.ticketSystem.ticketSystem.BaseEntity.BaseEntity;
import com.ticketSystem.ticketSystem.Enum.Priority;
import com.ticketSystem.ticketSystem.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private String category;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Status status;
    @Column(nullable = true)
    private String notes;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
