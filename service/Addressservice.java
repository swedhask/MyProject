package com.example.assess.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assess.entity.Address;
import com.example.assess.repository.Addressrepository;

@Service
public class Addressservice {
	
	
	@Autowired
	private Addressrepository addressrepository;
	
	public List<Address> getaddress(){
		return addressrepository.findAll();

}
	public Optional<Address> getAddressById(int address_id) {
		return addressrepository.findById(address_id);
		
	}
	public Address addaddress(Address address) {
		return addressrepository.save(address);
		}
	public boolean deleteAddressById(int address_id) {
		Optional<Address> address= addressrepository.findById(address_id);
		if(address.isPresent()) {
			 addressrepository.deleteById(address_id);
			 return true;
		}
		else {
			return false;
		}
		}
	public Address updateAddress(Address updatedAddress) {
	    Optional<Address> existingAddress = addressrepository.findById(updatedAddress.getAddressId());

	    if (existingAddress.isPresent()) {
	        Address address = existingAddress.get();
	        address.setAddressPinCode(updatedAddress.getAddressPinCode()); 
	        address.setAddressState(updatedAddress.getAddressState());  
	        address.setStudentId(updatedAddress.getStudentId());
	        return addressrepository.saveAndFlush(address);
	    } 
	    return null;
	}


	}
