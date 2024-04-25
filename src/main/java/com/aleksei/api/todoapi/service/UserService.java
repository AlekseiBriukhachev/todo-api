package com.aleksei.api.todoapi.service;

import com.aleksei.api.todoapi.entity.TodoUser;
import com.aleksei.api.todoapi.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for managing users.
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructs a new UserService with the given repository.
     *
     * @param userRepository the repository to use
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users from the database.
     *
     * @return a list of all users
     */
    public List<TodoUser> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a users by its ID.
     *
     * @param id the ID of the user to retrieve
     * @return the user with the given ID, or null if no such user exists
     */
    public TodoUser getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new user in the database.
     *
     * @param user the client to create
     */
    @Transactional
    public void create(TodoUser user) {
        userRepository.save(user);
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id the ID of the user to delete
     */
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    /**
     * Updates a user in the database.
     *
     * @param id the ID of the user to update
     * @param updatedUser the user with updated information
     * @throws EntityNotFoundException if no user with the given ID exists
     */
    @Transactional
    public void update(Long id, TodoUser updatedUser) {
        var existingClient = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client with id " + id + " not found"));
        existingClient.setName(updatedUser.getName());
        existingClient.setSurname(updatedUser.getSurname());
        existingClient.setEmail(updatedUser.getEmail());
    }
}
