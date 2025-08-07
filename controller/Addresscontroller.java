package com.example.assess.controller;

import java.util.List;
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

import com.example.assess.entity.Address;
import com.example.assess.response.ResponseGenerator;
import com.example.assess.service.Addressservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Address")
public class Addresscontroller {
	
	@Autowired
	private Addressservice addressservice;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getaddress() {
	    try {
	        List<Address> get = addressservice.getaddress();
	        if (get != null ) {
	            return ResponseGenerator.successResponse("Address read successfully", get);
	        } 
	        else {
	            return ResponseGenerator.failureResponse("No addresses found");
	        }
	    } catch (Exception e) {
	        return ResponseGenerator.failureResponse("Address fetch failed: " + e.getMessage());
	    }
	}
	@GetMapping("/getById/{address_id}")
	 public ResponseEntity<?> getAddressById(@PathVariable int address_id){
		try {
			Optional<Address> getById =addressservice.getAddressById(address_id);
			if(getById != null) {
				 return ResponseGenerator.successResponse("Address read by ID successfully", getById);
			}
			else {
				return ResponseGenerator.failureResponse("No addresses found");
			}
		}catch(Exception e) {
			return ResponseGenerator.failureResponse("Address fetch failed: " + e.getMessage());
		}
	}
	@PostMapping("/create")
	public ResponseEntity<?> added(@Valid @RequestBody Address address) {
	    try {
	        Address added = addressservice.addaddress(address);
	        if (added != null) {
	            return ResponseGenerator.successResponse("Address is created successfully", added);
	        } else {
	            return ResponseGenerator.failureResponse("Address is not created");
	        }
	    } catch (Exception e) {
	        return ResponseGenerator.failureResponse("Address creation failed: " + e.getMessage());
	    }
	}
	@DeleteMapping("/delete/{address_id}")
	public ResponseEntity<?>deleted(@PathVariable int address_id){
		try {
			boolean isdeleted = addressservice.deleteAddressById(address_id);
			if(isdeleted) {
				return ResponseGenerator.successResponse("address is deleted successfully",null);
			}
			else {
				return ResponseGenerator.failureResponse("address deletion went unsuccessfull");
			}
		}catch(Exception e) {
				return ResponseGenerator.failureResponse("Address deletion failed" +e.getMessage());
			}
		
		}		
	@PutMapping("/update")
	public ResponseEntity<?>updated(@Valid @RequestBody Address address) {
		try {
			Address updated = addressservice.updateAddress(address);
			if(updated!=null) {
				return ResponseGenerator.successResponse("address is updated successfully",updated);
			}
			else {
				return ResponseGenerator.failureResponse("address deletion went unsuccessfull");
			}
		}catch(Exception e) {
			return ResponseGenerator.failureResponse("Address deletion failed" +e.getMessage());
		}
			
		}
	

}

	
