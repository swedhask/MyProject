package com.example.assess.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
    @NotEmpty(message="name is required")
	@NotNull(message="name should not be null")
	@Size(min=2,max=50,message="it should contain more than one character")

	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_age")
	private int studentAge;
	
	@Column(name="student_mail")
	private String studentMail;
	
   
}
