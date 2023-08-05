package service;

import model.Faculty;
import org.springframework.stereotype.Service;
import repositories.FacultyRepository;

import java.util.Collection;

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
        return facultyRepository.findByNameOrColourIgnoreCase(part);
    }
    public Collection<Faculty> getAllFaculty(){
        return facultyRepository.findAll();
    }
}
