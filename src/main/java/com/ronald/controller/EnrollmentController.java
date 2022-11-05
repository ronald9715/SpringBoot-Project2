package com.ronald.controller;

import com.ronald.model.Enrollment;
import com.ronald.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private IEnrollmentService service;

    @GetMapping
    public ResponseEntity<List<Enrollment>> readAll() throws Exception{
        List<Enrollment> list = service.readAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> readById(@PathVariable("id") Integer id) throws Exception{
        Enrollment enrollment = service.readById(id);
        if (enrollment == null){
            throw new Exception("Enrollment not found");
        }
        return new ResponseEntity<>(enrollment, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Enrollment> create(@RequestBody Enrollment enrollment) throws Exception{
        Enrollment obj = service.create(enrollment);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Enrollment> update(@RequestBody Enrollment enrollment) throws Exception{
        Enrollment obj = service.update(enrollment);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) throws Exception{
        Enrollment obj = service.readById(id);
        if (obj == null){
            throw  new Exception("Enrollment is not found");
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
