package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Address;
@Repository
public interface addressRepository extends JpaRepository<Address, Long>{

}
