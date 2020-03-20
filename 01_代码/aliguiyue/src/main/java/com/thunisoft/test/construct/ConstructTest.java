package com.thunisoft.test.construct;

public class ConstructTest {
}


/**
 * 父类中必须含有默认构造器，否则子类会报错。
 * 若父类不加默认构造器，可以在子类中处理
 */
class Father{

    private Integer age;

    public Father(Integer age){
        this.age = age;
    }

}

class Son extends Father{

    public Son(){
        super(46);
    }

}
