package com.ronald.controller;

import com.ronald.model.Student;
import com.ronald.model.Subject;
import com.ronald.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private ISubjectService service;

    @GetMapping
    public ResponseEntity<List<Subject>> readAll() throws Exception{
        List<Subject> subjects = service.readAll();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Subject> readById(@PathVariable("id") Integer id) throws Exception{
        Subject subject = service.readById(id);
        if (subject == null){
            System.out.println("SUBJECT NOT FOUND");
        }
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Subject> create(@RequestBody Subject sbj) throws Exception{
        Subject subject = service.create(sbj);
        return new ResponseEntity<>(subject, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Subject> update(@RequestBody Subject sbj) throws Exception{
        Subject obj = service.readById(sbj.getIdSubject());
        if (obj == null){
            throw new Exception("SUBJECT NOT FOUND");
        }
        Subject subject = service.update(sbj);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Subject obj = service.readById(id);
        if (obj == null){
            throw new ClassNotFoundException("SUBJECT NOT FOUND");
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
