package com.matrinmunene.school;

import com.matrinmunene.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Martin Munene
 */
@Service
@RequiredArgsConstructor
public class SchoolService {
    private final StudentClient client;
    private final SchoolRepository repository;


    public void saveSchool(School school){
        repository.save(school);
    }

    public List<School> findAllSchools(){
        return repository.findAll();
    }

    public FullSchoolResponse findAllSchoolsWithStudents(Integer schoolId) {
         var school = repository.findById(schoolId)
                 .orElse(
                         School.builder()
                                 .name("NOT_FOUND")
                                 .email("NOT_FOUND")
                                 .build());
         var students = client.findAllStudentsBySchool(schoolId);

        return  FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
