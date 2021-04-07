package com.ginsoon.StudentRegistration.controller;

import com.ginsoon.StudentRegistration.data.entity.Student;
import com.ginsoon.StudentRegistration.service.StudentRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Entertains user requests and fetch necessary resource
 * @author Gin
 * @version 0.01
 */
@Controller
@RequestMapping("/students")
public class StudentRegistrationController {
    private final StudentRegistrationService studentRegistrationService;

    public StudentRegistrationController(StudentRegistrationService studentRegistrationService) {
        this.studentRegistrationService = studentRegistrationService;
    }
    /**
     * <p>This method gets the list of students and passes it to the view
     * </p>
     * @param model student model
     * @return the home page which shows a table populated with students
     */
    @GetMapping
    public String getStudents(Model model){
        model.addAttribute("students",studentRegistrationService.getStudents());
        model.addAttribute("student", new Student());
        return "studentHomePage";
    }
    /**
     * <p>This method adds a new student to the database and passes it to the view
     * </p>
     * @param student student object
     * @param model model component
     * @return the home page which shows a table populated with students
     */
    @PostMapping("add")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result,Model model) {
        if(result.hasErrors()){
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        studentRegistrationService.save(student);

        return "redirect:/students";
    }
    /**
     * <p>This method deletes the selected student from the database and returns the view
     * </p>
     * @param id student id
     * @param model model component
     * @return the home page which shows a table populated with students
     */
    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model){
        studentRegistrationService.delete(id);
        return "redirect:/students";
    }
    /**
     * <p>This method accepts the student id and returns a json payload of the student details
     * </p>
     * @param id student id
     * @param model model component
     * @return the home page which shows a table populated with students
     */
    @GetMapping("edit")
    @ResponseBody
    public Student editStudent(@RequestParam(value = "id") String id, Model model){
        Student student = studentRegistrationService.getStudent(Long.parseLong(id));
        model.addAttribute("student",student);
        return student;
    }

    /**
     * <p>This method updates a student's details in the database and returns the updated view
     * </p>
     * @param id student id
     * @param name model component
     * @param emailAddress student's email address
     * @param phoneNumber student's phone number
     * @return the home page which shows a table populated with students
     */
    @PostMapping(value = "/update")
    public String updateStudent(@RequestParam("studentid") String id,
                                @RequestParam("name") String name,
                                @RequestParam("course") String course,
                                @RequestParam("emailAddress") String emailAddress,
                                @RequestParam("phoneNumber") String phoneNumber){
        Student student = studentRegistrationService.getStudent(Long.parseLong(id));
        student.setName(name);
        student.setCourse(course);
        student.setEmailAddress(emailAddress);
        student.setPhoneNumber(phoneNumber);
        studentRegistrationService.save(student);
        return "redirect:/students";

    }

}
