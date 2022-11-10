package com.anubhav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anubhav.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
