package com.ginsoon.StudentRegistration.service;

import com.ginsoon.StudentRegistration.data.entity.Student;
import com.ginsoon.StudentRegistration.data.repository.StudentRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
class StudentRegistrationServiceTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentRegistrationService studentRegistrationService = new StudentRegistrationService(studentRepository);

    @Test
    void getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        given(studentRepository.findAll()).willReturn(students);
        assertThat(studentRegistrationService.getStudents()).isEqualTo(students);
        verify(studentRepository).findAll();
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void getStudent() {
    }
}