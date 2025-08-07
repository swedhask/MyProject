package com.example.assess.dto;

import java.util.List;

import com.example.assess.Address;
import com.example.assess.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

	private int studentId;

	private String studentName;

	private int studentAge;

	private String studentMail;

	private List<Address> address;
	private List<Course> course;
}