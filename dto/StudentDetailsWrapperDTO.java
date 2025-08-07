package com.example.assess.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDetailsWrapperDTO {
	 private StudentDto student;
	    private AddressDto address;
	    private CourseDto course;

}
