package com.example.quizz_backend.repo;

import com.example.quizz_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    public User findByUsername (String username);
}
