package com.example.assess.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @NotEmpty(message = "Course name should not be empty")
    @Column(name = "course_name")
    private String courseName;

    @NotNull(message = "Course percentage should not be null")
    @DecimalMin(value = "0.0", message = "Percentage must be at least 0")
    @DecimalMax(value = "100.0", message = "Percentage must not exceed 100")
    @Column(name = "course_percentage")
    private Double coursePercentage;

    @NotEmpty(message = "University name should not be empty")
    @Column(name = "university_name")
    private String universityName;

    @Positive(message = "Year of pass out must be a valid year")
    @Column(name = "yearofpassout")
    private int yearOfPassOut;

    @NotNull(message = "Student ID should not be null")
    @Column(name = "student_id")
    private int studentId;
    
   // @OneToOne
    //@JoinColumn(name = "student_id", referencedColumnName = "studentId")
    //private Student student;
    
}

