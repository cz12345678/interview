package com.thunisoft.test.sort;

/**
 * 冒泡排序
 */
public class BuddleSort {

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
        sort2(arrays);

        for (int i : arrays){
            System.out.print(i + "\t");
        }

        System.out.println();
    }

    public static void sort1(int[] array){

        final int length = array.length;

        // 外层循环，决定比较次数 length - 1
        for (int i = 0; i < length - 1; i++){

            // 内层循环，第 j 个与第 j + 1个比较，表叫次数为 length - 1 - i(已经比较过的)
            for (int j = 0; j < length - i - 1; j++){

                if ( array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void sort2(int[] array){

        final int length = array.length;
        // 设置一个flag，标识是否需要一直比较下去，如果不需要则flag一直是false，直接跳出循环
        boolean flag = false;

        for (int i = 0; i < length - 1; i++){

            for (int j = 0; j < length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }

        }


    }



}
