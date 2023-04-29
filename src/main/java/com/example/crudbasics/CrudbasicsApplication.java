package com.example.crudbasics;

import com.example.crudbasics.model.Student;
import com.example.crudbasics.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudbasicsApplication{

	public static void main(String[] args) {
		SpringApplication.run(CrudbasicsApplication.class, args);
	}


}
