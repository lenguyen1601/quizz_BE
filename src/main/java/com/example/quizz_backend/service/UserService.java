package com.example.quizz_backend.service;

import com.example.quizz_backend.model.User;
import com.example.quizz_backend.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface UserService {

    //creting user

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by uername
    public User getUser(String username);

    // delete user by user id
    public void deleteUser(Long userId);
}
