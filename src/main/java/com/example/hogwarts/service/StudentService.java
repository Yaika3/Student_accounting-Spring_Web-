package com.example.hogwarts.service;

import com.example.hogwarts.model.Student;
import org.springframework.stereotype.Service;
import com.example.hogwarts.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student add(Student student){
        return studentRepository.save(student);
    }
    public Student get(long id){
        return studentRepository.getById(id);
    }
    public Student update(Student student){
        return studentRepository.save(student);
    }
    public void delete (long id){
        studentRepository.deleteById(id);
    }
    public Student getByAge (long age){
         return (Student) studentRepository.findByAgeBetween(age,age);
    }
    public Collection<Student> getAllStudent(){
        return studentRepository.findAll();
    }
}
