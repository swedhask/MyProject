package com.example.assess.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.assess.entity.Course;
import com.example.assess.response.ResponseGenerator;
import com.example.assess.service.Courseservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Course")
public class Coursecontroller {

    @Autowired
    private Courseservice courseservice;

    @GetMapping("/getAll")
    public ResponseEntity<?> getCourse() {
        try {
            List<Course> get = courseservice.getcourse();
            if (get != null && !get.isEmpty()) {
                return ResponseGenerator.successResponse("Course read successfully", get);
            } else {
                return ResponseGenerator.failureResponse("Course read failed");
            }
        } catch (Exception e) {
            return ResponseGenerator.failureResponse("Course not found: " + e.getMessage());
        }
    }

    @GetMapping("/getById/{course_id}")
    public ResponseEntity<?> getCourseById(@PathVariable int course_id) {
        try {
            Optional<Course> getbyid = courseservice.getCourseById(course_id);
            if (getbyid.isPresent()) {
                return ResponseGenerator.successResponse("Course read by id successfully", getbyid.get());
            } else {
                return ResponseGenerator.failureResponse("Course read by id failed");
            }
        } catch (Exception e) {
            return ResponseGenerator.failureResponse("Course not found: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> addcourse(@Valid @RequestBody Course course) {
        try {
            Course added = courseservice.addcourse(course);
            if (added != null) {
                return ResponseGenerator.successResponse("Course creation successful", added);
            } else {
                return ResponseGenerator.failureResponse("Course creation failed");
            }
        } catch (NoSuchElementException e) {
            return ResponseGenerator.failureResponse("Course not found: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{course_id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int course_id) {
        try {
            boolean isDeleted = courseservice.deleteById(course_id);
            if (isDeleted) {
                return ResponseGenerator.successResponse("Course deleted successfully!", null);
            } else {
                return ResponseGenerator.failureResponse("Course deletion failed");
            }
        } catch (NoSuchElementException e) {
            return ResponseGenerator.failureResponse("Course not found: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatecourse(@Valid @RequestBody Course course) {
        try {
            Course updated = courseservice.updatecourse(course);
            if (updated != null) {
                return ResponseGenerator.successResponse("Course updated successfully!", updated);
            } else {
                return ResponseGenerator.failureResponse("Course updation failed");
            }
        } catch (NoSuchElementException e) {
            return ResponseGenerator.failureResponse("Course not found: " + e.getMessage());
        }
    }
}

