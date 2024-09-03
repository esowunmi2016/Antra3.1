package org.example.pojo;


public class Teacher {
    private int id;
    private String name;
    private String school;
    private int age;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSchool() {
        return school;
    }
    public int getAge() {
        return age;
    }

    public Teacher setId(int id) {
        this.id = id;
        return this;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }
    public Teacher setSchool(String school) {
        this.school = school;
        return this;
    }
    public Teacher setAge(int age) {
        this.age = age;
        return this;
    }
}
