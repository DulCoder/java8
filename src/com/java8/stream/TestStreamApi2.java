package com.java8.stream;

import com.java8.lambda.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * 一、Stream API 的操作步骤：
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
 * 3. 终止操作(终端操作) 
 * 
 * Created by zhengxianyou on 2018/11/23.
 */
public class TestStreamApi2 {
    
    List<Student> emps = Arrays.asList(
            new Student("Tom","001",60,74,95),
            new Student("Jerry","002",43,65,99),
            new Student("John","003",50,80,89),
            new Student("John","003",50,80,89),
            new Student("John","003",50,80,89),
            new Student("LiHua","004",97,94,85),
            new Student("XiaoMing","005",77,84,65),
            new Student("ZhangWei","006",80,79,55)
    );

    //中间操作
	/*
		映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 */
    @Test
    public void test1(){
        Stream<String> str = emps.stream()
                .map((e) -> e.getName());
        str.forEach(System.out::println);

        System.out.println("-------------------------------------------");

        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        Stream<String> stream = strList.stream()
                .map(String::toUpperCase);

        stream.forEach(System.out::println);

        Stream<Stream<Character>> stream2 = strList.stream()
                .map(TestStreamApi2::filterCharacter);

        stream2.forEach((sm) ->
                sm.forEach(System.out::println)
        );

        System.out.println("---------------------------------------------");

        Stream<Character> stream3 = strList.stream()
                .flatMap(TestStreamApi2::filterCharacter);

        stream3.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }

    /*
        sorted()——自然排序
        sorted(Comparator com)——定制排序
     */
    @Test
    public void test2(){
        emps.stream()
                .map(Student::getName)
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        emps.stream()
                .sorted((x, y) -> {
                    if(x.getYuWen() == y.getYuWen()){
                        return x.getName().compareTo(y.getName());
                    }else{
                        return Integer.compare(x.getYuWen(), y.getYuWen());
                    }
                }).forEach(System.out::println);
    }

}
