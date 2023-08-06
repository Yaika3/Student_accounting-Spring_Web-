package com.example.hogwarts.repositories;

import com.example.hogwarts.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface StudentRepository extends JpaRepository<Student,Long> {

    public Collection<Student> findByAgeBetween(Long age, Long age2);

}
