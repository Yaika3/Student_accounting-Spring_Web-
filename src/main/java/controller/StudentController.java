package controller;

import model.Faculty;
import model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.Collection;

@RequestMapping("/Student")
@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    public Student add(@RequestBody Student student){
        return service.add(student);
    }
    @GetMapping
    public Student get(@RequestParam long id){
        return  service.get(id);
    }
    @PutMapping
    public Student update(@RequestBody Student student){
        return update(student);
    }
    @DeleteMapping
    public ResponseEntity delete (@RequestParam long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public Student getByAge(@RequestParam long age){
        return service.getByAge(age);
    }
}
