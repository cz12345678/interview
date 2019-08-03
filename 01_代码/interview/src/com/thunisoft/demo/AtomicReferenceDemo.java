package com.thunisoft.demo;


import java.util.concurrent.atomic.AtomicReference;

class User{

    String name;

    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


/**
 * @author chenzhen-1
 * @create 2019-05-31 13:58
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();

        User z3 = new User("z3",22);
        User l4 = new User("l4",25);

        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t current value is " + atomicReference.get());
        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t current value is " + atomicReference.get());


    }

}
