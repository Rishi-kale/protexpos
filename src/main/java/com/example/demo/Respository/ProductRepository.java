package com.example.demo.Respository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.*;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}
