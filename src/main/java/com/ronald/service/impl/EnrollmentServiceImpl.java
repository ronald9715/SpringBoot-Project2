package com.ronald.service.impl;

import com.ronald.model.Enrollment;
import com.ronald.repo.IEnrollmentRepo;
import com.ronald.repo.IGenericRepo;
import com.ronald.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService {
    @Autowired
    private IEnrollmentRepo repo;
    @Override
    IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }
}
