package com.example.hogwarts.repositories;

import com.example.hogwarts.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Long> {

    public Collection<Student> findByAgeBetween(Long age, Long age2);
    @Query(value = "SELECT FROM hogwarts, SUM student ", nativeQuery = true)
    List<Student> getAllStudentNumber();

}
