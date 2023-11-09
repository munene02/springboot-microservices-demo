package com.matrinmunene.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Martin Munene
 */
@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    public void save(@RequestBody Student student){
        service.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok().body(service.findAllStudents());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok(service.findAllStudentsBySchool(schoolId));
    }
}
