package com.icshop7.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icshop7.delivery.entity.User;
import com.icshop7.delivery.repository.UserRepository;

@CrossOrigin
@RestController
//@RequestMapping("/api/home/")
public class Controller {

	@Autowired
	UserRepository userRepository;

	@RequestMapping("/hello") // REST API End Point
	public String process() {

		return "<Marquee><H1>Hello World</H1></Marquee>";

	}

	@GetMapping("/getusers")
	public List<User> getAllUsers() {

		return userRepository.findAll(); // select * from user;
	}

	// create POST
	// create employee rest api
	@PostMapping("/addusers")
	public User createuser(@RequestBody User user) {
		return userRepository.save(user);
	}

	// Delete By ID

	void hi() {
		System.out.println("Hello");
	}

	@DeleteMapping("/deleteusers/{id}")
	public String deleteUser(@PathVariable("id") int id) {

		userRepository.deleteById(id);

		return "Is deleted";
	}

	@GetMapping("/get")
	public List<User> getJPQL() {
//match with user name and password ,,,tuo can do it
		return userRepository.findAllSortedByName(); // select * from user Order By username;

	}

	@GetMapping("/valid/{username}/{password}")
	public List<User> getJPQL2(@PathVariable("username") String username, @PathVariable("password") String password) {
//match with user name and password ,,,tuo can do it
		// Match all records and compare with above username and Password
		List<User> rec = userRepository.findAll(); // findAll()
		// stream API ---- Simple approch iterarte
		for (User u : rec) {
			// match
			System.out.println(u);

			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				System.out.println(" Valid- Authenticated");
				break;
			} else {
				System.out.println("Not Valid");
			}

		}

		return userRepository.findAll() ;//findAllSortedByName(); // select * from user Order By username;

	}

}