package com.ginsoon.StudentRegistration.service;

import com.ginsoon.StudentRegistration.data.entity.Student;
import com.ginsoon.StudentRegistration.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * A service class which provide the methods for carrying out CRUD operations on the student objects in the database
 * @author Gin
 * @version 0.01
 */
@Service
public class StudentRegistrationService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentRegistrationService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    /**
     * <p>This method gets the list of students
     * </p>
     * @return a list of students
     */
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        Iterable<Student> studentIterable = studentRepository.findAll();
        studentIterable.forEach(students::add);
        return students;
    }

    /**
     * <p>This method saves student in the database
     * </p>
     * @param student student object
     */
    public void save(Student student) {
        studentRepository.save(student);
    }
    /**
     * <p>This method delete a student from the database
     * </p>
     * @param id student id
     */
    public void delete(long id){
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid student ID:" + id));
        studentRepository.delete(student);
    }
    /**
     * <p>This method gets the list of students and passes it to the view
     * </p>
     * @param id student id
     * @return a student
     */
    public Student getStudent(long id){
        return studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid student ID:" + id));
    }

}
