package com.aleksei.api.todoapi.service;

import com.aleksei.api.todoapi.entity.TodoActivity;
import com.aleksei.api.todoapi.repository.ActivityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ActivityService is a service class that provides methods for managing activities in the system.
 * It uses ActivityRepository to perform database operations.
 */
@Service
@Transactional(readOnly = true)
public class ActivityService {
    private final ActivityRepository activityRepository;

    /**
     * Constructs a new ActivityService with the given ActivityRepository.
     *
     * @param repository the ActivityRepository to use for database operations
     */
    @Autowired
    public ActivityService(ActivityRepository repository) {
        this.activityRepository = repository;
    }

    /**
     * Retrieves all activities from the database.
     *
     * @return a list of all activities
     */
    public List<TodoActivity> getAllActivities() {
        return activityRepository.findAll();
    }

    /**
     * Retrieves an activity by its ID.
     *
     * @param id the ID of the activity to retrieve
     * @return the activity with the given ID, or null if no such activity exists
     */
    public TodoActivity getActivity(Long id) {
        var activity = activityRepository.findById(id);
        return activity.orElse(null);
    }

    /**
     * Creates a new activity in the database.
     *
     * @param activity the activity to create
     */
    @Transactional
    public void create(TodoActivity activity) {
        activityRepository.save(activity);
    }

    /**
     * Deletes an activity from the database.
     *
     * @param id the ID of the activity to delete
     */
    @Transactional
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }

    /**
     * Updates an activity in the database.
     *
     * @param id the ID of the activity to update
     * @param updatedActivity the updated activity
     * @throws EntityNotFoundException if no activity with the given ID exists
     */
    @Transactional
    public void update(Long id, TodoActivity updatedActivity) {
        var existingActivity = activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity with id " + id + " not found"));
        existingActivity.setTitle(updatedActivity.getTitle());
        existingActivity.setDescription(updatedActivity.getDescription());
        existingActivity.setStartDate(updatedActivity.getStartDate());
        existingActivity.setEndDate(updatedActivity.getEndDate());
    }
}
