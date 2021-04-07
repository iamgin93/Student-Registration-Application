package com.ginsoon.StudentRegistration.data.repository;

import com.ginsoon.StudentRegistration.data.entity.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * This is an interface which extends CrudRepository to provide generic CRUD operations on a repository
 */
public interface StudentRepository extends CrudRepository<Student,Long> {
}
