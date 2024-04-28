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

    public static final int START_SEQ = 100000;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Schema(description = "User name", example = "John")
    private String name;

    @Column(name = "surname", nullable = false)
    @Schema(description = "User surname", example = "Doe")
    private String surname;

    @Column(name = "email", nullable = false)
    @Schema(description = "User email", example = "john@email.com")
    private String email;

    @OneToMany(mappedBy = "todoUser", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<TodoActivity> activities;
}
