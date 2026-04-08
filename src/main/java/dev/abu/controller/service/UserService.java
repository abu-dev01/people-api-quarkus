package dev.abu.controller.service;

import dev.abu.controller.domain.User;
import dev.abu.controller.exception.UserNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    public User createUser(User user){
        User.persist(user);
        return user;
    }

    public List<User> findAllUsers(Integer page, Integer pageSize){
        return User.findAll().page(page, pageSize).list();
    }

    public User findUserById(UUID id){
        return (User) User.findByIdOptional(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User updateUser(UUID id, User user){
        var existingUser = findUserById(id);

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        //User.persist(existingUser);
        return existingUser;
    }

    public void deleteUser(UUID id){
        var existingUser = findUserById(id);
        User.deleteById(existingUser.getId());
    }
}
