package com.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhengxianyou on 2018/11/12.
 */
public class Java8Test {

    static List<Student> students = Arrays.asList(
            new Student("Tom","001",60,74,95),
            new Student("Jerry","002",43,65,99),
            new Student("John","003",50,80,89),
            new Student("LiHua","004",97,94,85),
            new Student("XiaoMing","005",77,84,65),
            new Student("ZhangWei","006",80,79,55)
    );

    public static void main(String[] args) {

        System.out.println("=========查询所有语文不及格的同学===========");
        test1();
        System.out.println("=========查询所有数学80及以上的同学==========");
        test2();
        System.out.println("======Stream API实现遍历==========");
        test3();
    }

    /**
     * 策略模式-公共方法
     *
     * @param students
     * @param sf
     * @return
     */
    private static List<Student> filterStudent(List<Student> students,StudentFilter<Student> sf){
        List<Student> list = new ArrayList<>();

        for (Student s : students){
            if (sf.test(s)){
                list.add(s);
            }
        }
        return list;
    }

    /**
     * 查询所有语文不及格的同学
     */
    private static void test1(){
        List<Student> list = filterStudent(students,(e) -> e.getYuWen()<60);
        list.forEach(System.out::println);
    }

    /**
     * 查询所有数学80及以上的同学
     */
    private static void test2(){
        List<Student> list = filterStudent(students,(e) -> e.getMath()>=80);
        list.forEach(System.out::println);
    }


    /**
     * Stream API实现
     */
    private static void test3(){
students.stream()
//        .map(Student::getEnglish)
//        .limit(4)
//        .sorted()
        .forEach((e)->System.out.println(e.getEnglish()));
    }

}
