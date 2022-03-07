package com.example.reactblogbe.login.repository;

import com.example.reactblogbe.login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
