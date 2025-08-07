package com.example.assess.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assess.dto.AllDTO;
import com.example.assess.dto.StudentDto;
import com.example.assess.entity.Student;
import com.example.assess.repository.Addressrepository;
import com.example.assess.repository.Courserepository;
import com.example.assess.repository.Studentrepository;



@Service
public class Studentservice {
	
	@Autowired
    private Studentrepository studentrepository;
	
    @Autowired
    private Addressrepository addressrepository;
    
    @Autowired
    private Courserepository courserepository;
	
	public List<Student> getstudent() {
		return studentrepository.findAll();
		
	}
	public Optional<Student> getStudentById(int student_id) {
        return studentrepository.findById(student_id);
    }
	public Student addstudent(Student student) {
		return studentrepository.save(student);
		
	}

	public boolean deleteStudentById(int student_id) {
		Optional<Student>student = studentrepository.findById(student_id);
		if(student.isPresent()) {
	    studentrepository.deleteById(student_id);
	    return true;
	}
		else {
			return false;
		}
	}
	public Student updateStudent(Student updatedStudent) {
	    Optional<Student> existingStudent = studentrepository.findById(updatedStudent.getStudentId());

	    if (existingStudent.isPresent()) {
	        Student student = existingStudent.get();
	        student.setStudentName(updatedStudent.getStudentName()); 
	        student.setStudentAge(updatedStudent.getStudentAge());  
	        student.setStudentMail(updatedStudent.getStudentMail()); 
	        return studentrepository.saveAndFlush(student);
	    } 
	    return null;
	}
	
	public StudentDto getStudentDetails(int id) {
		Student student = studentrepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
		System.out.println("Student fetched = " + student);

		StudentDto dto = new StudentDto();
		dto.setStudentId(student.getStudentId());
		dto.setStudentName(student.getStudentName());
		dto.setStudentMail(student.getStudentMail());
		dto.setStudentAge(student.getStudentAge());
		dto.setAddress(addressrepository.findByStudentId(dto.getStudentId()));
		dto.setCourse(courserepository.findByStudentId(dto.getStudentId()));
		return dto;
	}
	public List<AllDTO> getFullStudentDetail(int id) {
		return studentrepository.getStudentDetailsById(id);
	}

}
