package com.aleksei.api.todoapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo_user")
@Schema(description = "User entity")
public class TodoUser {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Schema(description = "User name", example = "John Doe")
    private String fullName;

    @Column(name = "email", nullable = false)
    @Schema(description = "User email", example = "john@email.com")
    private String email;

    @OneToMany(mappedBy = "todoUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<TodoActivity> activities;
}
