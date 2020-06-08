package br.com.school.endpoint;

import br.com.school.controller.StudentController;
import br.com.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("student")
public class StudentEndpoint implements Serializable {

    private final StudentRepositoryInterface dao;

    @Autowired
    public StudentEndpoint(StudentRepositoryInterface dao) {
        this.dao = dao;
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> ListAll() {
        return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(dao.findByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {

        String name = dao.SelecionarPorId(id);

        name = new StudentController().retornoNomeJson(name);

        return new ResponseEntity<>(name, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<?> SaveStudant(@RequestBody Student student) {

        System.out.println(student);

        return new ResponseEntity<>(dao.save(student), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> UpdateStudant(@RequestBody Student student) {
        return new ResponseEntity<>(dao.save(student), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> DeleteStudant(@PathVariable("id") long id) {

        try {
            dao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }




}
