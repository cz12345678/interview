package com.thunisoft.test.sort;

/**
 * 希尔排序
 */
public class ShellSortTest {

    public static void main(String[] args) {
        int[] arrays = new int[20];
        for (int i = 0; i < arrays.length; i++){
            arrays[i] = (int)(Math.random() * 100);
        }

        for (int i : arrays){
            System.out.print(i + "\t");
        }
        System.out.println();

//        sort1(arrays);
        sort(arrays);

        for (int i : arrays){
            System.out.print(i + "\t");
        }

        System.out.println();
    }


    public static void sort(int[] array){

        final int length = array.length;

        // 设置增量为 长度的一半
        int gap = length >> 2;

        // 设置临时变量保存数据
        int temp = 0;

        while (gap > 0){

            // 从 gap 处开始遍历，增量为gap
            for (int i = gap; i < length; i++){

                // 复值 临时变量，作为比较的 key
                temp = array[i];

                // 设置与其比较的值下标，即 i - gap(增量)
                int preIndex = i - gap;

                // 比较条件，判断前值下标有效，且前值 > 后值
                while (preIndex >= 0 && array[preIndex] > temp){

                    // 处理方式，将低位坐标 赋值给 高位坐标
                    array[preIndex + gap] = array[preIndex];

                    // 前值坐标 - gap 获取新的前值坐标
                    preIndex -= gap;
                }
                // 固定临时值比较后，将其赋值给最后的前值坐标（上述while循环中，要想跳出，必须preIndex < 0)
                array[preIndex + gap] = temp;
            }
            // 减小增量
            gap = gap >> 2;
        }


    }

}
