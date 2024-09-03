package org.example.config;

import org.example.pojo.Student;
import org.example.pojo.Teacher;
import org.example.service.SqlService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class SqlConfig implements SqlService {
    static final String DB_URL = "jdbc:mysql://localhost:3306/antra";
    static final String USER = "root";
    static final String PASS = "*********";

    public Connection con(){
        Connection con;
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public ArrayList<Student> getAllStudents(){
        final String QUERY = "SELECT * FROM Student";
        ArrayList<Student> res = new ArrayList<>();
        try {
            Statement stmt = con().createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                res.add(new Student()
                        .setId(rs.getInt("id"))
                        .setName(rs.getString("name"))
                        .setSchool(rs.getString("school"))
                        .setAge(rs.getInt("age"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public void createStudent(String name, String school, int age) {
        final String QUERY = "INSERT INTO student(name, school, age) VALUES ('"+name+"', '"+school+"', "+age+");";

        try {
            Statement stmt = con().createStatement();
            int rs = stmt.executeUpdate(QUERY);
            if(rs != 0){
                System.out.println("Create successful");
            }else{
                System.out.println("Create unsuccessful");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudentName(String name, int id){
        final String QUERY = "UPDATE student SET name = '"+name+"' WHERE id = "+id+";";
        try {
            Statement stmt = con().createStatement();
            int rs = stmt.executeUpdate(QUERY);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteStudent(int id){
        String Query = "DELETE FROM student WHERE id ="+id+";";
        try {
            Statement stmt = con().createStatement();
            stmt.executeUpdate(Query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Teacher> getAllTeachers(){
        String query = "SELECT * FROM teacher;";
        ArrayList<Teacher> res = new ArrayList<>();
        try {
            Statement stmt = con().createStatement() ;
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                res.add(
                        new Teacher()
                                .setId(rs.getInt("id"))
                                .setName(rs.getString("name"))
                                .setSchool(rs.getString("school"))
                                .setAge(rs.getInt("age"))

                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

//    Custom sql (student join teacher where s_id > 10
    public ArrayList<String> getStudentJoinTeacher(){
        String query = "SELECT * FROM student JOIN teacher WHERE student.id > 3;";
        ArrayList<String> res = new ArrayList<>();
        try{
            Statement stmt = con().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                res.add(
                        ""+
                        rs.getInt("id")+", "+
                        rs.getString("name")+", "+
                        rs.getString("school")+", "+
                        rs.getInt("age")+", "+
                        rs.getInt("teacher.id")+", "+
                        rs.getString("teacher.name")+", "+
                        rs.getString("teacher.school")+", "+
                        rs.getInt("teacher.age")
                );
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    return res;
    }
}
