package com.example.assess.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class User {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name="user_id")
private int userId;

@NotNull(message="this field shouldn't be null")
@Column(name="user_name")
private String userName;

@NotNull(message="this field shouldn't be null")
@Column(name="user_password")
private String userPassword;


@Column(name="student_id")
private int studentId;

}
