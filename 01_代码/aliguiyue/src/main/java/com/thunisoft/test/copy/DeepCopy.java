package com.thunisoft.test.copy;

public class DeepCopy implements Cloneable{


    public static void main(String[] args) throws Exception{
        DeepCopy d1 = new DeepCopy();

        d1.setAge(100);
        d1.setName("zhangsan");

        DeepCopy d2 = (DeepCopy)d1.clone();

        d1.setName("lisi");

        System.out.println("d1 \t" + d1);
        System.out.println("d2 \t" + d2);

    }




    private Integer age;

    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DeepCopy{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
