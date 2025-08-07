package com.example.assess;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assess.dto.StudentDto;
import com.example.assess.response.ResponseGenerator;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/students")
public class Studentcontroller {

    @Autowired
    private Studentservice studentservice; 


    @GetMapping("/getAll") 
    public ResponseEntity<?> getstudent() {
     try {
        List<Student> get = studentservice.getstudent();
        if(get!=null) {
        	return ResponseGenerator.successResponse("Student read successfully", get);
        }
        else {
        	return ResponseGenerator.failureResponse("student read failed");
        }
     } catch(Exception e ) { 
    	 return ResponseGenerator.failureResponse("student not found" +e.getMessage());
     }
    	
     }
  
    @GetMapping("/getById/{student_id}")
    public ResponseEntity<?> getStudentById(@PathVariable int student_id) {
    	try {
        Optional<Student> getbyid=studentservice.getStudentById(student_id);
        if(getbyid!=null) {
        	return ResponseGenerator.successResponse("Student read by id issuccessfully", getbyid);
        }
        else {
        	return ResponseGenerator.failureResponse("student read by id is failed");
        }
    	}
    	catch (Exception e) {
    		return ResponseGenerator.failureResponse("Student not found: " + e.getMessage());
        }
        
    }
    @PostMapping("/create")
    public ResponseEntity<?> addstudent(@Valid @RequestBody Student student) {
    	try {
    	Student added = studentservice.addstudent(student);
    	if(added!=null) {
    		return ResponseGenerator.successResponse("Student creation successfully", added);
    	}
    	else {
    		return ResponseGenerator.failureResponse("student creation failed");
    	}
    	}
    	catch (NoSuchElementException e) {
    		return ResponseGenerator.failureResponse("Student not found: " + e.getMessage());
        }
    	
    }
   
    @DeleteMapping("/delete/{student_id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int student_id) {
    	try {
        boolean isDeleted=studentservice.deleteStudentById(student_id);
        if(isDeleted) {
        	return ResponseGenerator.successResponse("Student deleted successfully!",null);
        }
        else {
        	return ResponseGenerator.failureResponse("student creation failed");
        }
    	}
    	catch (NoSuchElementException e) {
    		return ResponseGenerator.failureResponse("Student not found: " + e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody Student student) {
    	try {
		Student updated = studentservice.updateStudent(student);
		 
		if(updated != null) {
			return ResponseGenerator.successResponse("Student updation successfully!",updated);
		}
		else {
			return ResponseGenerator.failureResponse("student updation failed");
		}
    	}
    	catch (NoSuchElementException e) {
    		return ResponseGenerator.failureResponse("Student not found: " + e.getMessage());
        }
    }
    
    @GetMapping("/getByStudentDetails/{student_id}")
    public ResponseEntity<?>getFullDetails(@PathVariable int student_id){
    	try {
    		StudentDto dto= studentservice.getStudentDetails(student_id);
    				return ResponseGenerator.successResponse("All Details Fetched successfully!",dto);		
    	}
    	catch(Exception e) {
    		return ResponseGenerator.failureResponse("Details Fetch failed");
    	}
    }
    @GetMapping("/details/{student_id}")
	public ResponseEntity<?> getFullStudentDetail(@PathVariable int student_id) {
		try {
			List<AllDTO> response = studentservice.getFullStudentDetail(student_id);
			return ResponseGenerator.successResponse("Data fethed successfully!..", response);
		} catch (Exception e) {
			return ResponseGenerator.failureResponse(e.getMessage());
		}
	}

}
    

 