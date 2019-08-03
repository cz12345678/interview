package com.thunisoft.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @author ceshi
 * @Title: Student
 * @ProjectName ceshi
 * @Description: TODO
 * @date 2018/7/1121:54
 */
//定义内部节点
@XStreamAlias("student_Message")
public class Student {
    //定义<student_Message sid="1">属性
    @XStreamAsAttribute()
    private String sid;

    private String id;
    private IdType idType;
    private String idNo;
    private String name;
    private Gender gender;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IdType getIdType() {
        return idType;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
