package com.example.assess.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assess.entity.Course;
import com.example.assess.repository.Courserepository;

@Service
public class Courseservice {
	
@Autowired	
private Courserepository courserepository;

public List <Course> getcourse(){
	return courserepository.findAll();
	}
public Optional <Course> getCourseById(int course_id){
	return courserepository.findById(course_id);
	}
public Course addcourse(Course course) {
	return courserepository.save(course);
	}
public boolean deleteById(int course_id) {
    Optional<Course> course = courserepository.findById(course_id);
    if (course.isPresent()) {
        courserepository.deleteById(course_id);
        return true;
    } else {
        return false;
    }
}
public Course updatecourse(Course updatedcourse) {
    Optional<Course> existingcourse = courserepository.findById(updatedcourse.getCourseId());

    if (existingcourse.isPresent()) {
        Course course = existingcourse.get();
        course.setCourseName(updatedcourse.getCourseName()); 
        course.setCoursePercentage(updatedcourse.getCoursePercentage());  
        course.setUniversityName(updatedcourse.getUniversityName());
        course.setYearOfPassOut(updatedcourse.getYearOfPassOut());
        course.setStudentId(updatedcourse.getStudentId());
        return courserepository.saveAndFlush(course);
    } 
    
    return null;
}
}


