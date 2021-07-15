package com.assignment.school.Student;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentNor {
    @JsonProperty("studentid")
    private Integer studentid;
    @JsonProperty("name")
  private String name;
    @JsonProperty("age")
    private String age;
    @JsonProperty("gender")
    private String gender;


    public StudentNor(Integer studentid, String name, String age, String gender) {
        this.studentid = studentid;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public StudentNor() {
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
