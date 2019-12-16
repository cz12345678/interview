package src.com.atguigi.my.linkedList;

/**
 * 双向链表的
 */
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.list();

        list.countBoy(1,2,5);// // 2->4->1->5->3

    }
}

class CircleSingleLinkedList{

    // 创建一个没有编号的first节点
    private Boy first = null;

    // 添加小孩，创建一个环形链表
    /**
     *@Description 构建一个有 num 个Boy的环形链表
     *@author  chenzhen-1
     *@time  2019/12/16-18:27
     */
    public void addBoy(int num){

        // 验证数据的准确性
        if (num < 1){
            System.err.println("num的值不正确");
            return;
        }

        // 向链表中添加小孩节点
        // 定义一个辅助指针

        Boy cur = null;
        System.err.println();
        for (int i = 1; i <= num; i++){
            // 根据编号，创建小孩
            Boy boy = new Boy(i);

            if (i == 1){
                // 如果是第一个元素,
                // 将first指向这个节点
                // 并将这个节点的next设置为自身
                first = boy;
                first.setNext(first);
                cur = first;
            } else {
                // 添加其他元素时(2/3/4)
                // 将当前元素 next 指向新添加元素
                // 将新元素的 next 指向first
                // 将当前元素，指向新添加的元素
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }

        }
    }

    /**
     *@Description 遍历环形链表：结束条件
     *      （临时指针的下一个元素指向first）
     *@author  chenzhen-1
     *@time  2019/12/16-18:38
     */
    public void list(){
        // 判空
        if (first == null){
            System.err.println("没有元素！！！");
            return;
        }

        // 定义临时指针
        Boy temp = first;
        while (true){
            // 一定要先打印，然后在判断
            System.err.println(temp);
            if (temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }
    }


    /**
     *@Description
     *@author  chenzhen-1
     *@time  2019/12/16-19:26
     * @param startNo : 从第几个节点开始
     * @param countNum : 向后数几次
     * @param nums : 环形链表节点个数
     */
    public void countBoy(int startNo, int countNum, int nums){

        // 对数据进项校验
        if (first == null || startNo < 1 || countNum > nums){
            System.err.println("参数有误，请重新输入！！");
            return;
        }

        // 创建辅助指针helper，helper是指向next节点指向first节点的指针
        Boy helper = first;
        while (true){
            // 当helper的next指向first时，对应的节点就是辅助指针的节点
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        // 将first指针和Helper指针移动 startNo - 1 个位置，开始小孩的位置
        for (int i = 0; i < startNo - 1; i++){
            first = first.getNext();
            helper = helper.getNext();
        }

        // 到底countNum个位置时，小孩出圈。
        // 即 指针每次移动 countNum - 1下
        while (true){
            // 特殊情况判断，只剩一个一个节点时
            if (first == helper){
                break;
            }

            // 将 first 和 helper 移动 countNum - 1 下（因为开始位置为1）
            for (int i = 0; i < countNum - 1; i++){
                first = first.getNext();
                helper = helper.getNext();
            }

            // 此时first节点是需要被删除的节点
            // helper是指向first的节点
            // 将first的值指向first的下一个节点
            // 将helper的值指向first节点
            System.err.printf("编号是【%d】的小孩出去了", first.getNo());
            first = first.getNext();
            helper.setNext(first);

        }
        System.err.printf("最后一个小孩，编号是【%d】出去了", first.getNo());



    }



}

/**
 * 节点类，Boy
 */
class Boy{

    // 编号ID
    private int no;

    // 指向下一个节点
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}