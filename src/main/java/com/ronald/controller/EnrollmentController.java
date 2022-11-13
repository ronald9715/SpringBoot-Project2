package com.ronald.controller;

import com.ronald.dto.EnrollmentDTO;
import com.ronald.model.Enrollment;
import com.ronald.service.IEnrollmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private IEnrollmentService service;
    @Autowired
    @Qualifier("enrollmentMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> readAll() throws Exception{
        List<EnrollmentDTO> list = service.readAll().stream().map(enrollment -> mapper.map(enrollment, EnrollmentDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Enrollment enrollment = service.readById(id);
        if (enrollment == null){
            throw new Exception("Enrollment not found");
        }
        return new ResponseEntity<>(mapper.map(enrollment, EnrollmentDTO.class), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EnrollmentDTO> create(@RequestBody EnrollmentDTO enrollment) throws Exception{
        Enrollment obj = service.create(mapper.map(enrollment, Enrollment.class));
        return new ResponseEntity<>(mapper.map(obj, EnrollmentDTO.class), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<EnrollmentDTO> update(@RequestBody EnrollmentDTO enrollment) throws Exception{
        Enrollment obj = service.update(mapper.map(enrollment, Enrollment.class));
        return new ResponseEntity<>(mapper.map(obj, EnrollmentDTO.class), HttpStatus.OK);
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
