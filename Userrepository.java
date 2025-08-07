package com.example.assess;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface Userrepository extends JpaRepository<User, Integer> {

	 User findByUserNameAndUserPassword(String userName, String userPassword);

	 Optional<User> findByUserName(String userName);

	

}
