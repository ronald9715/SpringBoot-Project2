package com.ronald.service;

import com.ronald.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer> {
    List<Student> getStudentByAgeDescending();
}
