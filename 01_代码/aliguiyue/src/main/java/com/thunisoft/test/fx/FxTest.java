package com.thunisoft.test.fx;

/**
 * 写在泛型括号里的都是泛型类型，失去了其他含义
 *
 * 泛型只具备执行Object类的方法
 * @param <T>
 */
public class FxTest<T> {

    static <A, T, Alibaba> A get(A a, Alibaba alibaba){
        return a;
    }


    public static void main(String[] args) {
        Integer first = 222;

        Long second = 333L;

        Integer result = get(first, second);

        System.out.println(result);
    }

}
