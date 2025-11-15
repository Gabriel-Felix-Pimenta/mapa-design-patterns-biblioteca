package com.example.libmanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.libmanager.model.User;
public interface UserRepository extends JpaRepository<User, Long> {}