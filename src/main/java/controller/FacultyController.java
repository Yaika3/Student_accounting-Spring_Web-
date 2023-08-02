package controller;

import model.Faculty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FacultyService;

import java.util.Collection;

@RequestMapping("/Faculty")
@RestController
public class FacultyController {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }
    @PostMapping
    public Faculty add(@RequestBody Faculty faculty){
        return service.add(faculty);
    }
    @GetMapping
    public Faculty get(@RequestParam long id){
        return  service.get(id);
    }
    @PutMapping
    public Faculty update(@RequestBody Faculty faculty){
        return update(faculty);
    }
    @DeleteMapping
    public ResponseEntity delete (@RequestParam long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllFaculty(){
        return getAllFaculty();
    }
    @GetMapping
    public ResponseEntity getByColourOrName(@RequestParam String colour, @RequestParam String name){
        if(name!= null && !name.isBlank()){
            return ResponseEntity.ok(service.findByColorOrName(name));
        }
        if(colour!= null && !colour.isBlank()){
            return ResponseEntity.ok(service.findByColorOrName(colour));
        }
        return ResponseEntity.ok(getAllFaculty());
    }

}
