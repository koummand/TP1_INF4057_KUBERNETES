package com.serviceusers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceusers.model.Userbanque;
import com.serviceusers.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	// save user
	@PostMapping("/adduser")
	public List<Userbanque> addUserController(@RequestBody Userbanque user) {
		userService.addUsers(user);
		userService.getAllUsers();
		return userService.getAllUsers();
	}

	// delete user
	@RequestMapping("/deleteuser/{id}")
	public List<Userbanque> deleteUserController(@PathVariable("id") int id) {
		return userService.deleteUsers(id);
	}

	// get user
	@GetMapping("/getuser/{id}")
	public Userbanque getUserController(@PathVariable("id") int id) {
		return userService.getUsers(id);
	}

	// get alluser
	@GetMapping("/getalluser")
	public List<Userbanque> getAllUserController() {
		return userService.getAllUsers();
	}

	// get user
	@GetMapping("/getuserPhone/{phoneNumber}")
	public int getUserPhoneController(@PathVariable("phoneNumber") String phoneNumber) {
		Userbanque user = userService.getUserByphone(phoneNumber);
		return user.getId();
	}

}
