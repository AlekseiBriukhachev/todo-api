package com.aleksei.api.todoapi.controllers;

import com.aleksei.api.todoapi.dto.ActivityDto;
import com.aleksei.api.todoapi.service.ActivityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/activity")
@Tag(name = "Activity Controller", description = "To-Do API")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/{id}/create")
    public ResponseEntity<ActivityDto> createAndAssignActivity(@PathVariable(name = "id") Long userId,
                                                               @RequestBody ActivityDto activityDto) {
        return ResponseEntity.ok(activityService.createAndAssignActivity(userId, activityDto));
    }

    @PostMapping("/{id}/assign")
    public ResponseEntity<ActivityDto> assignActivity(@PathVariable(name = "id") Long activityId,
                                                      @RequestBody Long userId) {
        return ResponseEntity.ok(activityService.assign(activityId, userId));
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<ActivityDto> updateActivity(@PathVariable(name = "id") Long activityId,
                                                      @RequestBody ActivityDto activityDto) {
        var updatedActivity = activityService.update(activityId, activityDto);
        log.debug("Updated activity: {}", updatedActivity);
        return ResponseEntity.ok(updatedActivity);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteActivity(@PathVariable(name = "id") Long activityId) {
        activityService.delete(activityId);
        return ResponseEntity.ok("Activity deleted");
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<ActivityDto> completeActivity(@PathVariable(name = "id") Long activityId) {
        ActivityDto completedActivity = null;
        try {
            completedActivity = activityService.complete(activityId);
            log.debug("Completed activity: {}", completedActivity);
            return ResponseEntity.ok(completedActivity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(completedActivity);
        }
    }
}

