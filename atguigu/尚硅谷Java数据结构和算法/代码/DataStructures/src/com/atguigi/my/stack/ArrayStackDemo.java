package src.com.atguigi.my.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        //测试一下ArrayStack 是否正确
        //先创建一个ArrayStack对象->表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }

}


/**
 * 数组模拟 栈
 */
class ArrayStack{

    /**  栈的最大存储量   */
    private int maxSize;

    /**  存储栈数据的数组   */
    private int[] stack;

    /**   表示栈顶，初始化为-1  */
    private int top = -1;

    /**
     *@Description 构造器，传入栈的大小
     *@author  chenzhen-1
     *@time  2019/12/17-18:24
     */
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }


    /**
     *@Description 判断数组栈是否已满
     *@author  chenzhen-1
     *@time  2019/12/17-18:26
     */
    public boolean isFull(){
        return top == maxSize - 1;
    }

    /**
     *@Description 判断队列是否为空，即top在初始位置
     *@author  chenzhen-1
     *@time  2019/12/17-18:30
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     *@Description 添加元素到栈中
     *@author  chenzhen-1
     *@time  2019/12/17-18:34
     */
    public void push(int value){
        // 判断栈是否已满
        if (isFull()){
            System.err.println("栈满，无法添加数据");
            return;
        }
        stack[++top] = value;
    }

    /**
     *@Description 从栈中读取数据
     *@author  chenzhen-1
     *@time  2019/12/17-18:35
     */
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，无法读取数据");
        }
        return stack[top--];
    }

    /**
     *@Description 遍历栈元素
     *@author  chenzhen-1
     *@time  2019/12/17-18:36
     */
    public void list(){
        if (isEmpty()){
            System.err.println("栈空，没有数据");
            return;
        }
        // 从栈顶开始遍历元素
        for (int i = top; i >= 0; i--){
            System.out.println(stack[i]);
        }
    }

}
