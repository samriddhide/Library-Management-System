package com.xfactor.openlibrary.controllers;

import com.xfactor.openlibrary.domain.Student;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.repository.StudentRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
//import java.util.HashMap;

@RestController
@RequestMapping("student")
public class StudentController {
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //ArrayList<Student> lstudents = new ArrayList<>();
    private StudentRepository studentRepository;

    @PostMapping("/savestudent")
    public Student saveBook(@RequestBody Student student) {
        studentRepository.save(student);
        return student;
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // get student by id
    @GetMapping("/getStudentById")
    public Student findById(@PathVariable long id) {
        Optional<Student> optionalofStudent = studentRepository.findById(id);
        if (optionalofStudent.isPresent()) {
            return optionalofStudent.get();
        }
        return null;
    }

    // get student by name
    @GetMapping("/getStudentByName/{name}")
    public List<Student> findByName(@PathVariable String name) {
        List<Student> optionalofStudent = studentRepository.findByName(name);
        return optionalofStudent;
    }

    // get student by roll number
    @GetMapping("/getStudentByRollNumber/{rollNumber}")
    public List<Student> findByRollNumber(@PathVariable String rollNumber) {
        List<Student> optionalofStudent = studentRepository.findByRollNumber(rollNumber);
        return optionalofStudent;
    }

    // get student by birth date
    @GetMapping("/getStudentByBirthDate/{birthDate}")
    public List<Student> findByBirthDate(@PathVariable String birthDate) {
        List<Student> optionalofStudent = studentRepository.findByBirthDate(birthDate);
        return optionalofStudent;
    }

    // get student by MobileNumber
    @GetMapping("/getStudentByMobileNumber/{mobileNumber}")
    public List<Student> findByMobileNumber(@PathVariable String mobileNumber) {
        List<Student> optionalofStudent = studentRepository.findByMobileNumber(mobileNumber);
        return optionalofStudent;
    }

    // update student
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        if (student.getId() != 0L) {
            Student student2 = studentRepository.save(student);
            return student2;
        }
        return null;
    }

    // delete student
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
    



}
