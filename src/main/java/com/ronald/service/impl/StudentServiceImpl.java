package com.ronald.service.impl;

import com.ronald.model.Student;
import com.ronald.repo.IGenericRepo;
import com.ronald.repo.IStudentRepo;
import com.ronald.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {
    @Autowired
    private IStudentRepo repo;

    @Override
    IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> getStudentByAgeDescending() {
        List<Student> list = repo.findAll().stream().sorted((x1,x2)->x2.getAge()- x1.getAge()).collect(Collectors.toList());
        return list;
    }
}
