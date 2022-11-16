package com.ronald.controller;

import com.ronald.dto.StudentDTO;
import com.ronald.exception.ModelNotFoundException;
import com.ronald.model.Student;
import com.ronald.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private IStudentService service;

    @Autowired
    @Qualifier("studentMapper")
    private ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> students = service.readAll().stream().map(student -> mapper.map(student, StudentDTO.class)).collect(Collectors.toList()); ;
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Student student = service.readById(id);
        if (student == null){
            throw new ModelNotFoundException("STUDENT NOT FOUND");
        }
        return new ResponseEntity<>(mapper.map(student, StudentDTO.class), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO student) throws Exception{

        Student student1 = service.create(mapper.map(student, Student.class));
        return new ResponseEntity<>(mapper.map(student1, StudentDTO.class), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<StudentDTO> update(@Valid @RequestBody StudentDTO student) throws Exception{
        //student.getId()
        Student std = service.readById(student.getId());
        if (std == null){
            throw new ModelNotFoundException("STUDENT NOT FOUND");
        }
        Student student1 = service.update(mapper.map(student, Student.class));
        return new ResponseEntity<>(mapper.map(student1, StudentDTO.class), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Student obj = service.readById(id);
        if (obj == null){
            throw new ModelNotFoundException("STUDENT NOT FOUND");
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //////// Customize Queries/////////////////////
    @GetMapping("/orderbyage")
    public ResponseEntity<List<StudentDTO>> getStudentByAgeDescending() throws Exception{
        List<StudentDTO> list =  service.getStudentByAgeDescending().stream().map(student -> mapper.map(student, StudentDTO.class)).collect(Collectors.toList()); ;
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

}
