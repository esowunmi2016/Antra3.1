package org.example.service;

import org.example.pojo.Student;
import org.example.pojo.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface SqlService {
//    public void qry();
    ArrayList<Student> getAllStudents();
    void createStudent(String name, String school, int age);

    void updateStudentName(String name, int id);

    void deleteStudent(int id);

    ArrayList<Teacher> getAllTeachers();
    ArrayList<String> getStudentJoinTeacher();
}
