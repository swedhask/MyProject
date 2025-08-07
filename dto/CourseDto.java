package com.example.assess.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

	private int courseId;

	private String courseName;

	private Double coursePercentage;

	private String universityName;

	private int yearOfPassOut;

}
