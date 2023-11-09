package com.matrinmunene.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Martin Munene
 */
@RestController
@RequestMapping("api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    public void save(@RequestBody School school){
        service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAll(){
        return ResponseEntity.ok().body(service.findAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAll(@PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok(service.findAllSchoolsWithStudents(schoolId));
    }
}
