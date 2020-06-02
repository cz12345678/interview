package com.thunisoft.test;

import java.util.Iterator;
import java.util.Stack;

/**
 * @ProjectName: aliguiyue
 * @Package: com.thunisoft.test
 * @ClassName: StackTest
 * @Author: chenzhen
 * @Description: 符号是否全对应上
 * @Date: 2020/6/2 0002 下午 11:11
 * @Version: 1.0
 */
public class StackTest {

    public static void main(String[] args) {

        String str = "{([({{{[)]}}})]}";

        boolean test = test(str);
        System.out.println(test);


    }


    private static boolean test(String str){

        final int length = str.length();

        if (length % 2 != 0){
            return false;
        }


        // 左栈 存储左边符号
        Stack<Character> left = new Stack<>();

        // 右栈 存储右边符号
        Stack<Character> right = new Stack<>();

        char temp;

        boolean flag = true;

        for (int i = 0; i < length; i++){
            temp = str.charAt(i);

            boolean isLeft = '(' == temp || '[' == temp || '{' == temp;

            if (isLeft){
                left.push(temp);
                continue;
            } else {

                if (left.isEmpty()){
                    flag = false;
                    break;
                }
                char leftTop = left.peek();

                boolean isMatch =(temp == ')' && leftTop == '(')
                        || (temp == ']' && leftTop == '[')
                        || (temp == '}' && leftTop == '{');

                if (isMatch){
                    left.pop();
                    continue;
                } else {
                    right.push(temp);
                }
            }
        }

        final boolean lengthEquals = (left.isEmpty() && !right.isEmpty()) || left.size() == right.size();

        if (!lengthEquals){
            flag = false;
        }

        Iterator<Character> leftItr = left.iterator();
        Iterator<Character> rightItr = right.iterator();

        while (leftItr.hasNext()){

            char leftTop = leftItr.next();
            char rightTop = rightItr.next();

            boolean isMatch = (leftTop == '(' && rightTop == ')')
                    ||  (leftTop == '{' && rightTop == '}')
                    ||  ( (leftTop == '[' && rightTop == ']') );

            if (!isMatch){
                flag = false;
            }
        }


        return flag;
    }

}
