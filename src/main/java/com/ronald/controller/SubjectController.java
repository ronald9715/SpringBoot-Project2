package com.ronald.controller;

import com.ronald.dto.SubjectDTO;
import com.ronald.model.Student;
import com.ronald.model.Subject;
import com.ronald.service.ISubjectService;
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
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private ISubjectService service;

    @Autowired
    @Qualifier("subjectMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> readAll() throws Exception{
        List<SubjectDTO> subjects = service.readAll().stream().map(subject -> mapper.map(subject, SubjectDTO.class)).collect(Collectors.toList()); ;
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SubjectDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Subject subject = service.readById(id);
        if (subject == null){
            System.out.println("SUBJECT NOT FOUND");
        }
        return new ResponseEntity<>(mapper.map(subject, SubjectDTO.class), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SubjectDTO> create(@Valid @RequestBody SubjectDTO sbj) throws Exception{
        Subject subject = service.create(mapper.map(sbj, Subject.class));
        return new ResponseEntity<>(mapper.map(subject, SubjectDTO.class), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<SubjectDTO> update(@Valid @RequestBody SubjectDTO sbj) throws Exception{
        Subject obj = service.readById(sbj.getId());
        if (obj == null){
            throw new Exception("SUBJECT NOT FOUND");
        }
        Subject subject = service.update(mapper.map(sbj, Subject.class));
        return new ResponseEntity<>(mapper.map(subject, SubjectDTO.class), HttpStatus.OK);
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
