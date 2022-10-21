package com.ronald.service.impl;

import com.ronald.model.Student;
import com.ronald.repo.IGenericRepo;
import com.ronald.repo.IStudentRepo;
import com.ronald.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {
    @Autowired
    private IStudentRepo repo;

    @Override
    IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

}
