package com.ronald.service.impl;

import com.ronald.model.Student;
import com.ronald.repo.IStudentRepo;
import com.ronald.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepo repo;
    @Override
    public Student create(Student student) throws Exception {
        return repo.save(student);
    }

    @Override
    public Student update(Student student) throws Exception{
        return repo.save(student);
    }

    @Override
    public List<Student> readAll() throws Exception{
        return repo.findAll();
    }

    @Override
    public Student getStudentById(Integer id) throws Exception{
        return repo.findById(id).orElse(new Student());
    }

    @Override
    public void delete(Integer id) throws Exception{
        repo.deleteById(id);
    }
}
