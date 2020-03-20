package com.thunisoft.test;

import java.util.*;

public class ComparatorTest {

    public static void main(String[] args) {

        Student s1 = new Student(10);
        Student s2 = new Student(10);
        Student s3 = new Student(11);
        Student s4 = new Student(9);

//        Student[] ss = {s1, s2, s3, s4};
//
//        for (Student stu : ss){
//            System.out.print(stu.toString() + "\t");
//        }
//        System.out.println();
//
//        Arrays.sort(ss);
//
//        for (Student stu : ss){
//            System.out.print(stu.toString() + "\t");
//        }
//        System.out.println();

        List<Student> ss1 = new ArrayList<Student>();
        ss1.add(s1);
        ss1.add(s2);
        ss1.add(s3);
        ss1.add(s4);
        System.out.println(ss1);


        Collections.sort(ss1,s1);

        System.out.println(ss1);


    }
}

class Student implements Comparator<Student>, Comparable<Student> {


    private int age;

    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }

    public int compare(Student o1, Student o2){
        return o1.getAge() > o2.getAge() ? 1 : -1;
    }


    public int compareTo(Student o) {
        return o.getAge() > this.getAge() ? 1 : -1;
    }
}
