package com.example.Auth.Controller;

import com.example.Auth.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(
            List.of( new Student(1,"ram",23), new Student(2,"sham",23)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken csrfToken(HttpServletRequest request){
        return(CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student s){
        students.add(s);
        return "student added successfully";
    }
}
