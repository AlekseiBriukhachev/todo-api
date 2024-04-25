package com.aleksei.api.todoapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class TodoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @OneToMany(mappedBy = "owner")
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<TodoActivity> activities;
}
