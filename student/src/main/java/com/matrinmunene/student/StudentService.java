package com.matrinmunene.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Martin Munene
 */
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public void saveStudent(Student student){
        repository.save(student);
    }

    public List<Student> findAllStudents(){
        return repository.findAll();
    }

    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }
}
