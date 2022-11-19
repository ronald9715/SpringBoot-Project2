package com.ronald.service.impl;

import com.ronald.model.Enrollment;
import com.ronald.model.EnrollmentDetail;
import com.ronald.model.Student;
import com.ronald.repo.IEnrollmentRepo;
import com.ronald.repo.IGenericRepo;
import com.ronald.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService {
    @Autowired
    private IEnrollmentRepo repo;
    @Override
    IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, List<String>> getStudentsFromCourses() {
        Stream<List<EnrollmentDetail>> listStream = repo.findAll().stream().map(enrollment -> enrollment.getDetails());
        Stream<EnrollmentDetail> enrollmentDetailStream = listStream.flatMap(Collection::stream);
        Map<String, List<String>> mapCourseStudent= enrollmentDetailStream
                .collect(Collectors.groupingBy(element->element.getSubject().getName(), Collectors.mapping(e->e.getEnrollment().getStudent().getName(),Collectors.toList())));
        return mapCourseStudent;
    }
}
