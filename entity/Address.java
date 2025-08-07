package com.example.assess.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private int addressId;
    
   
    @NotNull(message="this field should not be null")
    @Column(name="address_pincode")
    private int addressPinCode;
    
    @NotEmpty(message="This field should not be empty")
    @Column(name="address_state")
    private String addressState;
    

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;


}

