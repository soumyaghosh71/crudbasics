package com.example.crudbasics.repository;

import com.example.crudbasics.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
