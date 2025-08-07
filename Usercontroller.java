package com.example.assess;

import java.util.List;
import java.util.NoSuchElementException;
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

import com.example.assess.response.ResponseGenerator;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class Usercontroller {

	@Autowired
	private Userservice userservice;
	@Autowired
	private JwtUtil jwtutil;

	@GetMapping("/getAll")
	public ResponseEntity<?> getuser() {
		try {
			List<User> get = userservice.getuser();
			if (get != null) {
				return ResponseGenerator.successResponse("User read successfully", get);
			} else {
				return ResponseGenerator.failureResponse("User read failed");
			}
		} catch (Exception e) {
			return ResponseGenerator.failureResponse("User not found" + e.getMessage());
		}

	}

	@GetMapping("/getById/{user_id}")
	public ResponseEntity<?> getUserById(@PathVariable int user_id) {
		try {
			Optional<User> getbyid = userservice.getUserById(user_id);
			if (getbyid != null) {
				return ResponseGenerator.successResponse("User read by id issuccessfully", getbyid);
			} else {
				return ResponseGenerator.failureResponse("user read by id is failed");
			}
		} catch (Exception e) {
			return ResponseGenerator.failureResponse("user not found: " + e.getMessage());
		}

	}

	@PostMapping("/create")
	public ResponseEntity<?> addUser(@Valid @RequestBody User user) {
		try {
			User added = userservice.addUser(user);
			if (added != null) {
				return ResponseGenerator.successResponse("user creation successfully", added);
			} else {
				return ResponseGenerator.failureResponse("user creation failed");
			}
		} catch (NoSuchElementException e) {
			return ResponseGenerator.failureResponse("user not found: " + e.getMessage());
		}

	}

	@DeleteMapping("/delete/{user_id}")
	public ResponseEntity<?> deleteUser(@PathVariable int user_id) {
		try {
			boolean isDeleted = userservice.deleteUserById(user_id);
			if (isDeleted) {
				return ResponseGenerator.successResponse("user deleted successfully!", null);
			} else {
				return ResponseGenerator.failureResponse("user creation failed");
			}
		} catch (NoSuchElementException e) {
			return ResponseGenerator.failureResponse("user not found: " + e.getMessage());
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@Valid @RequestBody User user) {
		try {
			User updated = userservice.updateUser(user);

			if (updated != null) {
				return ResponseGenerator.successResponse("user updation successfully!", updated);
			} else {
				return ResponseGenerator.failureResponse("user updation failed");
			}
		} catch (NoSuchElementException e) {
			return ResponseGenerator.failureResponse("user not found: " + e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request) {
		try {
			User userObj = userservice.loginRequest(request);
			UserDto response = new UserDto();
			if (userObj != null) {
				response.setPassword(userObj.getUserPassword());
				response.setUserName(userObj.getUserPassword());
				String token = jwtutil.generateToken(userObj.getUserName());
				response.setToken(token);
				return ResponseGenerator.successResponse("user Login successfully!", response);
			} else
				return ResponseGenerator.failureResponse("user Login failed");
		} catch (NoSuchElementException e) {
			return ResponseGenerator.failureResponse("user not found: " + e.getMessage());
		}
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome, you are authenticated!";
	}

}
