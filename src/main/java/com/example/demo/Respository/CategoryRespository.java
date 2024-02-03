package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Categories;
@Repository
public interface CategoryRespository extends JpaRepository<Categories,Long> {

}
