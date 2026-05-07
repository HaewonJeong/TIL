package com.hw1.model.dto;

public class Student extends Person{
    private int grade;
    private String major;

    public Student() {
    }

    public Student(String name, int age, double height, double weight, int grade, String major) {

        super(age, height, weight);
        this.name = name;
        this.grade = grade;
        this.major = major;
    }
    public String information(){
        String parentInfo = super.information();
        String EmployeeInfo = ", 학생 [학년="+grade+", 전공="+major+"]";
        return parentInfo+EmployeeInfo;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


}
