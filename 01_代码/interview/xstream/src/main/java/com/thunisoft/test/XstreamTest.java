package com.thunisoft.test;


import com.alibaba.fastjson.JSON;
import com.thunisoft.bean.Gender;
import com.thunisoft.bean.IdType;
import com.thunisoft.bean.Student;
import com.thunisoft.bean.StudentList;
import com.thunisoft.util.XStreamUtils;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzhen
 * @create 2019-06-24 下午 9:56
 */
public class XstreamTest {

    @Test
    public void test(){
        StudentList studentList = new StudentList();
        List<Student> list = new ArrayList<Student>();
        Student s = new Student();
        IdType i = new IdType();
        Gender g = new Gender();
        s.setSid("1");
        s.setId("1");
        i.setName("身份证");
        i.setValue("1");
        s.setIdType(i);
        s.setIdNo("1");
        s.setName("张三");
        g.setName("男");
        g.setValue("1");
        s.setGender(g);
        list.add(s);
        Student s1 = new Student();
        IdType i1 = new IdType();
        Gender g1 = new Gender();
        s1.setSid("2");
        s1.setId("2");
        i1.setName("护照");
        i1.setValue("2");
        s1.setIdType(i1);
        s1.setIdNo("2");
        s1.setName("李华");
        g1.setName("女");
        g1.setValue("2");
        s1.setGender(g1);
        list.add(s1);
        studentList.setStudentList(list);
        String xml = XStreamUtils.objectToXml(studentList);
        xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+xml;
        xml = xml.replaceAll("__","_");
        System.out.println(xml);

        StudentList ss = XStreamUtils.xmlToObject(xml,StudentList.class);
        System.out.println(JSON.toJSON(ss));
    }
}


