package com.aleksei.api.todoapi.service;

import com.aleksei.api.todoapi.dto.ActivityDto;
import com.aleksei.api.todoapi.entity.TodoActivity;
import com.aleksei.api.todoapi.mapper.TodoActivityMapper;
import com.aleksei.api.todoapi.repository.ActivityRepository;
import com.aleksei.api.todoapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    private final TodoActivityMapper activityMapper;

    @Transactional
    public ActivityDto createActivity(ActivityDto activityDto) {
        var activity = new TodoActivity();
        activity.setTitle(activityDto.getTitle());
        activity.setDescription(activityDto.getDescription());
        activity.setStartDate(new Date());
        activityRepository.save(activity);
        return activityMapper.toDto(activity);
    }

    @Transactional
    public ActivityDto assign(Long activityId, Long userId) {
        var activity = activityRepository.findById(activityId).orElseThrow(RuntimeException::new);
        var userTodo = userRepository.findById(userId).orElseThrow(RuntimeException::new);
        if (userTodo != null && activity != null) {
            userTodo.getActivities().add(activity);
            activity.setTodoUser(userTodo);
            activityRepository.save(activity);
        }
        return activityMapper.toDto(activity);
    }

    @Transactional
    public ActivityDto update(Long activityId, ActivityDto activityDto) {
        var activity = activityRepository.findById(activityId).orElseThrow(RuntimeException::new);
        if (activity != null) {
            activity.setTitle(activityDto.getTitle());
            activity.setDescription(activityDto.getDescription());
            if (activityDto.getEndDate() != null) {
                activity.setEndDate(activityDto.getEndDate());
            }
            activityRepository.save(activity);
        }
        return activityMapper.toDto(activity);
    }

    @Transactional
    public void delete(Long activityId) {
        var activity = activityRepository.findById(activityId).orElseThrow(RuntimeException::new);
        if (activity != null) {
            activityRepository.deleteById(activityId);
        }
    }

    @Transactional
    public ActivityDto complete(Long activityId) {
        var activity = activityRepository.findById(activityId).orElseThrow(RuntimeException::new);
        if (activity != null && activity.getEndDate() == null) {
            activity.setEndDate(new Date());
            activityRepository.save(activity);
        }
        return activityMapper.toDto(activity);
    }
}
