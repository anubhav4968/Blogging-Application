package com.anubhav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anubhav.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
