package controller;

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
    @PostMapping("/StudentAdd")
    public Student add(@RequestBody Student student){
        return service.add(student);
    }
    @GetMapping("/StudentGet")
    public Student get(@RequestParam long id){
        return  service.get(id);
    }
    @PutMapping("/StudentUpdate")
    public Student update(@RequestBody Student student){
        return service.update(student);
    }
    @DeleteMapping("/StudentDelete")
    public ResponseEntity delete (@RequestParam long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/StudentGetAge")
    public Student getByAge(@RequestParam long age){
        return service.getByAge(age);
    }
    @GetMapping("/StudentGetAll")
    public Collection<Student> getAllStudent(){
        return service.getAllStudent();
    }
}
