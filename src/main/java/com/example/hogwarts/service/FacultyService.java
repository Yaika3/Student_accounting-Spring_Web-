package com.example.hogwarts.service;

import com.example.hogwarts.model.Faculty;
import org.springframework.stereotype.Service;
import com.example.hogwarts.repositories.FacultyRepository;

import java.util.Collection;
import java.util.Comparator;

@Service
public class FacultyService {
    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty add(Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public Faculty get(long id){
        return facultyRepository.getById(id);
    }
    public Faculty update(Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public void delete (long id){
        facultyRepository.deleteById(id);
    }
    public Collection<Faculty> findByColorOrName(String part){
        return facultyRepository.findByNameOrColourIgnoreCase(part,part);
    }
    public Collection<Faculty> getAllFaculty(){
        return facultyRepository.findAll();
    }

    public String longestName(){
       return facultyRepository.findAll()
                .stream()
                .map(Faculty::getName)
                .max(Comparator.naturalOrder())
               .orElse(null);
    }

}
