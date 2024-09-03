package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private int id;
    private String name;
    @JsonProperty("School")
    private String school;
    @JsonProperty("Age")
    private int age;
    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }
    public Student setName(String name) {
        this.name = name;
        return this;
    }
    public String getSchool() {
        return school;
    }
    public Student setSchool(String school) {
        this.school = school;
        return this;
    }
    public int getAge() {
        return age;
    }
    public Student setAge(int age) {
        this.age = age;
        return this;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", age=" + age +
                '}';
    }
}
