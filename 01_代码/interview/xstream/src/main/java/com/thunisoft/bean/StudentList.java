package com.thunisoft.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * @author chenzhen
 * @create 2019-06-24 下午 10:14
 */
@XStreamAlias("student")
public class StudentList {
    //根据XML生成student集合
    private List<Student> studentList;
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}