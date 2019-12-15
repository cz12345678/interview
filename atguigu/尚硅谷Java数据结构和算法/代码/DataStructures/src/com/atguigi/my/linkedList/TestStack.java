package com.atguigi.my.linkedList;

import java.util.Stack;

/**
 * @ProjectName: DataStructures
 * @Package: com.atguigi.my.linkedList
 * @ClassName: TestStack
 * @Author: chenzhen
 * @Description: 测试Stack特征，后进先出
 * @Date: 2019/12/15 0015 下午 9:51
 * @Version: 1.0
 */
public class TestStack {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.add("tom");
        stack.add("jerry");
        stack.add("zhangsan");

        // 遍历stack
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }


    }
}
