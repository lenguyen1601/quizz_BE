package com.example.quizz_backend.service.impl;

import com.example.quizz_backend.model.User;
import com.example.quizz_backend.model.UserRole;
import com.example.quizz_backend.repo.RoleRepository;
import com.example.quizz_backend.repo.UserRepository;
import com.example.quizz_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository reloRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local=this.userRepository.findByUsername(user.getUsername());
        if(local !=null){
            System.out.println("User already there!!!");
                throw new Exception("User already present");

        } else{
            //user create
    for (UserRole ur:userRoles)
    {
        reloRepository.save(ur.getRole());
    }
    user.getUserRoles().addAll(userRoles);
    local=this.userRepository.save(user);
        }
        return null;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}