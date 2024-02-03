package com.example.demo.Respository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface userRepository extends JpaRepository<User,Long> {
  
//	Optional<User> findbyEmail(String email);
}
