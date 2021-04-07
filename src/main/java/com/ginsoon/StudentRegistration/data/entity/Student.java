package com.ginsoon.StudentRegistration.data.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Represents a student object and a JPA entity
 * @author Gin
 * @version 0.01
 */
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;

    @Column(name = "name")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3,max = 30)
    private String name;

    @Column(name = "course")
    @NotBlank(message = "Course is mandatory")
    @Size(min = 3, max = 30)
    private String course;

    @Column(name = "email_address")
    @Email
    @NotBlank(message = "Email is mandatory")
    private String emailAddress;

    @NotBlank(message = "Phone number is mandatory")
    @Column(name = "phone_number")
    @Size(min = 8, max = 15)
    private String phoneNumber;

    /**
     * <p>This method is a getter which returns the student id
     * </p>
     * @return student id
     */
    public long getStudentId() {
        return studentId;
    }

    /**
     * <p>This method is setter which sets the student id
     * </p>
     * @param studentId long: student id, unique identifier
     */
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    /**
     * <p>This method is a getter which returns the student name
     * </p>
     * @return student name
     */
    public String getName() {
        return name;
    }

    /**
     * <p>This method is setter which sets the student name
     * </p>
     * @param name long: student name, unique identifier
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>This method is a getter which returns the student email address
     * </p>
     * @return student's email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * <p>This method is setter which sets the student email address
     * </p>
     * @param emailAddress long: student email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * <p>This method is a getter which returns the student phone number
     * </p>
     * @return student's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * <p>This method is setter which sets the student phone number
     * </p>
     * @param phoneNumber String: student's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * <p>This method is setter which sets the student's course
     * </p>
     * @param course String: student's course
     */
    public void setCourse(String course) {
        this.course = course;
    }
    /**
     * <p>This method is a getter which returns the student course
     * </p>
     * @return student's course
     */
    public String getCourse() {
        return course;
    }
}
