package com.example.assess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.assess.dto.AllDTO;
import com.example.assess.entity.Student;

@Repository
public interface Studentrepository extends JpaRepository<Student,Integer>{
	@Query("SELECT s.studentId as studentId, s.studentAge as studentAge, s.studentName as studentName, " +
		       "s.studentMail as studentMail, a.addressState as addressState, a.addressId as addressId, a.addressPinCode as addressPinCode, " +
		       "c.courseName as courseName, c.coursePercentage as coursePercentage, c.yearOfPassOut as yearOfPassOut,c.courseId as courseId, c.universityName as universityName " +
		       "FROM Student s JOIN Address a ON a.studentId = s.studentId " +
		       "JOIN Course c ON c.studentId = s.studentId " +
		       "WHERE s.studentId = :id")
    List<AllDTO> getStudentDetailsById(@Param("id") int id);
	}
