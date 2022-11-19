package com.ronald.service;

import com.ronald.model.Enrollment;
import com.ronald.model.Student;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICRUD<Enrollment, Integer>{
    Map<String, List<String>> getStudentsFromCourses();
}
