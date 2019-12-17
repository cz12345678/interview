package src.com.atguigi.my.stack;

public class LikedListStackDemo {


}


class LikedListStack{

    private Node top;


}


/**
 * 节点数据结构
 */
class Node{

    /** 存储数据信息    */
    private int value;

    /**  指向下一个节点    */
    private Node next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}



