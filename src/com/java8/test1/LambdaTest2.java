package com.java8.test1;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by zhengxianyou on 2018/11/12.
 *
 *
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 *
 * Supplier<T> : 供给型接口
 * 		T get();
 *
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 *
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 *
 */
public class LambdaTest2 {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }


    /**
     * Consumer<T> 消费型接口
     */
    public static void test1(){
        doAction(10000, (m) -> System.out.println("接受一个Double类型的数字：" + m ));
    }

    public static void doAction(double money, Consumer<Double> con){
        con.accept(money);
    }


    /**
     * Supplier<T> 供给型接口
     */
    public static void test2(){
        List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
//        for (Integer num : numList) {
//            System.out.println(num);
//        }
        numList.forEach(System.out::println);
    }

    /**
     * 产生指定个数的整数，并放入集合中
     *
     * @param num
     * @param sup
     * @return
     */
    public static List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }

        return list;
    }


    /**
     * Function<T, R> 函数型接口
     */
    public static void test3(){
        String newStr = strHandler("\t\t\t 去除前后空格   ", (str) -> str.trim());
        System.out.println(newStr);

        String subStr = strHandler("截取该字符串的长度", (str) -> str.substring(2, 5));
        System.out.println(subStr);
    }

    /**
     * 用于处理字符串
     *
     * @param str
     * @param fun
     * @return
     */
    public static String strHandler(String str, Function<String, String> fun){
        return fun.apply(str);
    }


    /**
     * Predicate<T> 断言型接口
     */
    public static void test4(){
        List<String> list = Arrays.asList("Hello", "Java", "Lambda", "Google", "Tim");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);

        for (String str : strList) {
            System.out.println(str);
        }
    }

    /**
     * 将满足条件的字符串，放入集合中
     *
     * @param list
     * @param pre
     * @return
     */
    public static List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();

        for (String str : list) {
            if(pre.test(str)){
                strList.add(str);
            }
        }

        return strList;
    }

}
