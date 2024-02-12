package com.example.testCrud.controllers;

import com.example.testCrud.entities.Student;
import com.example.testCrud.repository.Repo;
import com.example.testCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private Repo studentRepository;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    @GetMapping("/getList")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable Long id) {
        Optional<Student> optionalStudent= studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        }else {
            return null;
        }
    }

    @PutMapping("updateStudent/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @PatchMapping("updateStatus/{id}")
    public Student updateIsWorking(@PathVariable Long id, @RequestParam boolean working) {
        return studentService.updateIsWorking(id, working);
    }

    @DeleteMapping("deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}