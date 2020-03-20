package com.thunisoft.test.java8;

import java.util.*;
import java.util.stream.Collectors;

public class DistinctTest {

    public static void main(String[] args) {
        Data data1 = new Data(1,"aaaa");
        Data data2 = new Data(2,"dddd");
        Data data3 = new Data(1,"vvvv");
        Data data4 = new Data(4,"rrrr");
        Data data5 = new Data(1,"ssss");
        List<Data> list = Arrays.asList(data1,data2,data3,data4,data5);
        List<Data> l = test2(list);
        System.out.println(Arrays.toString(l.toArray()));

    }

    //对象去重
    public static List<Data> test2(List<Data> list){
        List<Data> unique = list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<Data>(Comparator.comparingLong(Data::getId))), ArrayList::new)
        );
        return unique;
    }

}

class Data{

    private int id;
    private String name;

    public Data(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
