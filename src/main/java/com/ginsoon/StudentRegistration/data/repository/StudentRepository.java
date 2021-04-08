package com.ginsoon.StudentRegistration.data.repository;

import com.ginsoon.StudentRegistration.data.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This is an interface which extends CrudRepository to provide generic CRUD operations on a repository
 */
@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
}
