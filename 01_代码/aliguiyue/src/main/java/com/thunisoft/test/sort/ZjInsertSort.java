package com.thunisoft.test.sort;

public class ZjInsertSort {

    public static void main(String[] args) {

        int[] arrays = new int[20];
        for (int i = 0; i < arrays.length; i++){
            arrays[i] = (int)(Math.random() * 100);
        }

        for (int i : arrays){
            System.out.print(i + "\t");
        }
        System.out.println();

        sort(arrays);

        for (int i : arrays){
            System.out.print(i + "\t");
        }

        System.out.println();


    }

    /**
     *  直接插入排序
     * @param array  排序数组
     */
    public static void sort(int[] array){

        // 获取外层循环的循环次数
        final int length = array.length;

        // 变量声明在外面，扩大引用范围（之后用的到）
        int i = 0;
        int j = 0;

        for (; i < length; i++){

            // 获取每一次需要插入的值，将其用final修饰，防止中间过程中操作不当修改
            final int temp = array[i];

            // 将 i 的值赋给 j ，且将 需要插入的值与 j - 1 比较
            for (j = i; j > 0 && array[j - 1] > temp ; j--){
                // 如果 j - 1 的值大于临时值，则将当前下标处的值后移一位。若情况不成立，则意味着循环结束（之后的数组是有序数组）
                array[j] = array[j - 1];
            }

            // 循环结束，执行复制操作。
            array[j] = temp;

        }


    }

}
