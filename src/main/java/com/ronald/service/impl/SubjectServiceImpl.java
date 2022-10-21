package com.ronald.service.impl;

import com.ronald.model.Subject;
import com.ronald.repo.IGenericRepo;
import com.ronald.repo.ISubjectRepo;
import com.ronald.service.ICRUD;
import com.ronald.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends CRUDImpl<Subject,Integer> implements ISubjectService {
    @Autowired
    private ISubjectRepo repo;
    @Override
    IGenericRepo<Subject, Integer> getRepo() {
        return repo;
    }
}
