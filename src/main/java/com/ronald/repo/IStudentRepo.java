package com.ronald.repo;

import com.ronald.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//Esta interfaz tiene implementados los metodos para el CRUD
public interface IStudentRepo extends JpaRepository<Student,Integer> {
}
