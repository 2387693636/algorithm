package com.util;

public class StudentInfo {
    private String stuName;
    private Integer stuAge;
    private String grade;

    public StudentInfo() {
    }

    public StudentInfo(String stuName, Integer stuAge, String grade) {
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.grade = grade;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
