package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeMyBatisRepository employeeRepository;

	@GetMapping(value = "/employees")
	public ResponseEntity<Object> getAuthors() {
		return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/init")
	public ResponseEntity<Object> intialize() {
		logger.info("Inserting -> {}",
				employeeRepository.insert(new Employee(10011L, "Ramesh", "Fadatare", "ramesh@gmail.com")));
		logger.info("Inserting -> {}",
				employeeRepository.insert(new Employee(10012L, "John", "Cena", "john@gmail.com")));
		logger.info("Inserting -> {}",
				employeeRepository.insert(new Employee(10013L, "tony", "stark", "stark@gmail.com")));

		logger.info("Employee id 10011 -> {}", employeeRepository.findById(10011L));

		logger.info("Update 10003 -> {}",
				employeeRepository.update(new Employee(10011L, "ram", "Stark", "ramesh123@gmail.com")));
		return new ResponseEntity<>("{ data : \"Initalized\"}", HttpStatus.OK);
	}

	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		int i = employeeRepository.insert(newEmployee);
		return employeeRepository.findById(i);
	}

	// Single item

	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) {

		return employeeRepository.findById(id);
	}

	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return employeeRepository.findById(id);
	}

	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
	}
}
