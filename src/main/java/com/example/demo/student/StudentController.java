package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student) {
        studentService.registerNewStudent(student);
    }

    @PutMapping(path = "{studentId}")
    @Transactional
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody(required = false) String name,
            @RequestBody(required = false) String email ) {
                studentService.updateStudent(studentId, name, email);
    }

    /* if a Json response is needed
    * @PutMapping(path = "{studentId}")
        @Transactional
        public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody Student studentDetails) {
                studentService.updateStudent(studentId, studentDetails);
}
    * */

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
