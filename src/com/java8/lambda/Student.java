package com.java8.lambda;

/**
 * Created by zhengxianyou on 2018/11/12.
 */
public class Student {

    private String name;

    private String stuNo;

    private Integer yuWen;

    private Integer math;

    private Integer english;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Integer yuWen) {
        this.name = name;
        this.yuWen = yuWen;
    }

    public Student(String name, String stuNo, Integer yuWen, Integer math, Integer english) {
        this.name = name;
        this.stuNo = stuNo;
        this.yuWen = yuWen;
        this.math = math;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public String getStuNo() {
        return stuNo;
    }

    public Integer getYuWen() {
        return yuWen;
    }

    public Integer getMath() {
        return math;
    }

    public Integer getEnglish() {
        return english;
    }

    public String show(){
        return "测试方法引用.........";
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", yuWen=" + yuWen +
                ", math=" + math +
                ", english=" + english +
                '}';
    }
}
