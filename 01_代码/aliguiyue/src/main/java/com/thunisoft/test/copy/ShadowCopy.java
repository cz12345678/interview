package com.thunisoft.test.copy;

public class ShadowCopy {


    public static void main(String[] args) throws  CloneNotSupportedException{
        ShadowCopy s1 = new ShadowCopy();

        s1.setAge(100);
        s1.setName("zhangsan");

        ShadowCopy s2 = s1;

        s1.setName("lisi");


        System.out.println("s1 \t" + s1);
        System.out.println("s2 \t" + s2);

    }

//    @Override
//    public ShadowCopy clone() {
//        ShadowCopy student = null;
//        try {
//            student = (ShadowCopy) super.clone();
//        } catch (CloneNotSupportedException ignored) {
//            System.out.println("xxx");
//        }
//        return student;
//    }



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
