package com.assignment.school.Student;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "School")
public class Student{

    @Id
    @Column(name = "studentid")
    private Integer studentid;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private String age;
    @Column(name = "gender")
    private String gender;

    public Student(Integer studentid, String name, String age, String gender) {
        this.studentid = studentid;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student() {
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
