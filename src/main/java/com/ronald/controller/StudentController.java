package com.ronald.controller;

import com.ronald.model.Student;
import com.ronald.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService service;
    @GetMapping
    public ResponseEntity<List<Student>> readAll() throws Exception{
        List<Student> students = service.readAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> readById(@PathVariable("id") Integer id) throws Exception{
        Student student = service.readById(id);
        if (student == null){
            System.out.println("No existe Estudiante: "+id);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) throws Exception{
        Student student1 = service.create(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) throws Exception{
        Student student1 = service.update(student);
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
