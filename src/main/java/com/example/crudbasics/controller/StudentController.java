package com.example.crudbasics.controller;

import com.example.crudbasics.exception.ResourceNotFoundException;
import com.example.crudbasics.model.Student;
import com.example.crudbasics.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //create a student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // get student by ID
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for id" + id));
        return ResponseEntity.ok(student);
    }

    // update a student
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent (@PathVariable long id, @RequestBody Student newStudent) {
        Student oldStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for id" + id));
        oldStudent.setFirstName(newStudent.getFirstName());
        oldStudent.setLastName(newStudent.getLastName());
        oldStudent.setEmail(newStudent.getEmail());
        studentRepository.save(oldStudent);
        return ResponseEntity.ok(oldStudent);
    }

    // delete a student
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent (@PathVariable long id) {
        Student oldStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for id" + id));
        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
