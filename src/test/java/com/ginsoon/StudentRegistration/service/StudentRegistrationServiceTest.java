package com.ginsoon.StudentRegistration.service;

import com.ginsoon.StudentRegistration.data.entity.Student;
import com.ginsoon.StudentRegistration.data.repository.StudentRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class StudentRegistrationServiceTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentRegistrationService studentRegistrationService;

    @Test
    void getStudents() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        students.add(student);
        given(studentRepository.findAll()).willReturn(students);
        assertThat(studentRegistrationService.getStudents()).isEqualTo(students);
        verify(studentRepository).findAll();
    }

    @Test
    void saveStudent() {
        Student student = new Student();
        given(studentRepository.save(Mockito.any(Student.class))).willReturn(student);
        studentRegistrationService.saveStudent(student);
        verify(studentRepository, times(1)).save(Mockito.any(Student.class));
    }

    @Test
    void deleteStudent() {
        Student student1 = new Student();
        student1.setStudentId(1);
        when(studentRepository.findById(student1.getStudentId())).thenReturn(Optional.of(student1));
        studentRegistrationService.deleteStudent(student1.getStudentId());
        verify(studentRepository).delete(student1);
    }


    @Test
    void getStudent() {
        Student student2 = new Student();
        student2.setStudentId(1);
        given(studentRepository.findById(student2.getStudentId())).willReturn(Optional.of(student2));
        studentRegistrationService.getStudent(student2.getStudentId());
        verify(studentRepository).findById(student2.getStudentId());
    }
}