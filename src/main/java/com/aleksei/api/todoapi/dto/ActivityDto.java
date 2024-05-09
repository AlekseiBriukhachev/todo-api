package com.aleksei.api.todoapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Activity DTO")
public class ActivityDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Activity title", example = "Meeting")
    private String title;

    @Schema(description = "Activity description", example = "Meeting with team")
    private String description;

    @Schema(description = "Activity start date", example = "2024-04-30")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startDate;

    @Schema(description = "Activity end date", example = "2024-04-30")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date endDate;

    @Schema(description = "Activity status", example = "true")
    private Boolean isCompleted;
}
