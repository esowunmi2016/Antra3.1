package org.example.controller;

import org.example.pojo.Student;
import org.example.pojo.Teacher;
import org.example.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.StringTokenizer;


@RestController
public class Controller {

    private final SqlService sql;

    @Autowired
    Controller(SqlService sql){
        this.sql = sql;
    }
    @GetMapping
    public String tst(){
//        sql.qry();
        return "Testing 1,2,3..";
    }

    @GetMapping("/students")
    public ArrayList<Student> getAllStudents(){
        return sql.getAllStudents();
    }
    @PostMapping(path = "/student", params = {"name", "school", "age"})
    public void setStudent(
            @RequestParam("name") String name,
            @RequestParam("school") String school,
            @RequestParam("age") int age
    ){
//        System.out.println(name);
//        System.out.println(school);
//        System.out.println(age);
            sql.createStudent(name, school, age);
    }

    @PatchMapping(path = "/student",params = {"name", "id"})
    public void updateStudentName(@RequestParam("id") int id, @RequestParam("name") String name){
        sql.updateStudentName(name, id);
    }

    @DeleteMapping(path = "/student", params = "id")
    public void deleteStudent(@RequestParam("id") int id){
        sql.deleteStudent(id);
    }

    @GetMapping("/teachers")
    public ResponseEntity<ArrayList<Teacher>> getAllTeachers(){
        return new ResponseEntity<ArrayList<Teacher>>(sql.getAllTeachers(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/studentjointeacher")
    public ResponseEntity<ArrayList<String>> getStudentJoinTeacher(){
        return new ResponseEntity<ArrayList<String>>(sql.getStudentJoinTeacher(), HttpStatusCode.valueOf(200));
    }
}
