package com.aleksei.api.todoapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activity")
@Schema(description = "Activity entity")
public class TodoActivity {

    public static final int START_SEQ = 100000;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "title", nullable = false)
    @Schema(description = "Activity title", example = "Meeting")
    private String title;

    @Column(name = "description", nullable = false)
    @Schema(description = "Activity description", example = "Meeting with team")
    private String description;

    @Column(name = "start_date")
    @Schema(description = "Activity start date", example = "2021-12-31")
    private Date startDate;

    @Column(name = "end_date")
    @Schema(description = "Activity end date", example = "2021-12-31")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private TodoUser todoUser;
}
