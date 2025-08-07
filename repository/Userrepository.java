package com.example.assess.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assess.entity.User;



@Repository
public interface Userrepository extends JpaRepository<User, Integer> {

	 User findByUserNameAndUserPassword(String userName, String userPassword);

	 Optional<User> findByUserName(String userName);

	

}
