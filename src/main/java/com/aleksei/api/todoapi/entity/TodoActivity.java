package com.aleksei.api.todoapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Activity title", example = "Meeting")
    private String title;

    @Schema(description = "Activity description", example = "Meeting with team")
    private String description;

    @Column(name = "start_date")
    @Schema(description = "Activity start date", example = "2024-04-30")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Schema(description = "Activity end date", example = "2024-04-30")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private TodoUser todoUser;
}
