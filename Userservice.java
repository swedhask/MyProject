package com.example.assess;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Userservice implements UserDetailsService {

	@Autowired
	private Userrepository userrepository;

	public List<User> getuser() {
		return userrepository.findAll();

	}

	public Optional<User> getUserById(int userId) {
		return userrepository.findById(userId);
	}

	public User addUser(User user) {
		return userrepository.save(user);

	}

	public boolean deleteUserById(int user_id) {
		Optional<User> user = userrepository.findById(user_id);
		if (user.isPresent()) {
			userrepository.deleteById(user_id);
			return true;
		} else {
			return false;
		}
	}

	public User updateUser(User updatedUser) {
		Optional<User> existingUser = userrepository.findById(updatedUser.getUserId());

		if (existingUser.isPresent()) {
			User user = existingUser.get();
			user.setUserId(updatedUser.getUserId());
			user.setUserPassword(updatedUser.getUserPassword());
			user.setUserName(updatedUser.getUserName());
			user.setStudentId(updatedUser.getStudentId());
			return userrepository.saveAndFlush(user);
		}
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> userOptional = userrepository.findByUserName(userName);
		if (!userOptional.isPresent()) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		User user = userOptional.get();
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

//	public User getUserDetails(String userName, String userPassword) {
//		return userrepository.findByUserNameAndUserPassword(userName, userPassword);
//	}

	public User loginRequest(AuthRequest request) {
		
		return  userrepository.findByUserNameAndUserPassword(request.getUsername(),request.getPassword());
			}

}
