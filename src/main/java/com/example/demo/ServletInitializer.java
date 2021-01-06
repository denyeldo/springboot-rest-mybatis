package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
	
	@Autowired
    private EmployeeMyBatisRepository employeeRepository;
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void run(String...args) throws Exception {

        logger.info("Inserting -> {}", employeeRepository.insert(new Employee(10011L, "Ramesh", "Fadatare", "ramesh@gmail.com")));
        logger.info("Inserting -> {}", employeeRepository.insert(new Employee(10012L, "John", "Cena", "john@gmail.com")));
        logger.info("Inserting -> {}", employeeRepository.insert(new Employee(10013L, "tony", "stark", "stark@gmail.com")));

        logger.info("Employee id 10011 -> {}", employeeRepository.findById(10011L));

        logger.info("Update 10003 -> {}", employeeRepository.update(new Employee(10011L, "ram", "Stark", "ramesh123@gmail.com")));

        employeeRepository.deleteById(10013L);

        System.out.println("All users -> {}"+ employeeRepository.findAll());
    }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

}
