package com.raj.medicall.repository;

import com.raj.medicall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByName(String username);
    boolean existsByUsername(String username);
}
