package org.abpc.controller;


import org.abpc.bean.Classes;
import org.abpc.bean.Student;
import org.abpc.bean.to.StudentDisplayTO;
import org.abpc.repository.ClassesRepository;
import org.abpc.repository.StudentRepository;
import org.abpc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StudentController {

    private static final String API_CONTEXT = "/api/v1";

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping(API_CONTEXT + "/students")
    @ResponseBody
    public Iterable<Student> findAll() {
        return studentRepository.findAllByOrderByNameAsc();
    }

    @GetMapping(API_CONTEXT + "/students/classes/{id}")
    @ResponseBody
    public Iterable<Classes> getClassesWithoutStudentPresent(@PathVariable("id") Integer id) {
        return classesRepository.findClassesWithoutStudent(id);
    }

    @PostMapping(API_CONTEXT + "/students")
    @ResponseBody
    public Student create(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping(API_CONTEXT + "/students/display")
    @ResponseBody
    public Collection<StudentDisplayTO> getStudentDisplay() {
        return studentService.getStudentsDisplay(studentRepository.findAllByOrderByNameAsc());
    }
}
