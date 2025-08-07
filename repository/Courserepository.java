package com.example.assess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assess.entity.Course;

@Repository
public interface Courserepository extends JpaRepository<Course,Integer> {
 List<Course>findByStudentId(int studentId);
}
