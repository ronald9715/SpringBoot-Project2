package com.ronald.service;

import com.ronald.model.Student;

import java.util.List;

public interface IStudentService {
    //Lista de Servicios para Alumnos
    Student create(Student student) throws Exception;
    Student update(Student student) throws Exception;
    List<Student> readAll() throws Exception;
    Student getStudentById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;

}
