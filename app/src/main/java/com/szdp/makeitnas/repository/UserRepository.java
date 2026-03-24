package com.szdp.makeitnas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.szdp.makeitnas.model.User;

public interface UserRepository extends JpaRepository <User, Long> {
    
    Optional<User> findById(final long id);

}