package com.example.assess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assess.entity.Address;

@Repository
public interface Addressrepository extends JpaRepository<Address,Integer>{
	List<Address> findByStudentId(int studentId);
}
