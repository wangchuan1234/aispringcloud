package com.southwind.controller;

import com.southwind.entity.Student;
import com.southwind.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Value("${server.port}")
    private String port;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id) {
        return studentRepository.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student s) {
        studentRepository.saveOrUpdate(s);
    }

    @PutMapping("/update")
    public void Update(@RequestBody Student s) {
        studentRepository.saveOrUpdate(s);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
    }
    @GetMapping("/index")
    public String index(){
        return "当前端口："+this.port;
    }
}
