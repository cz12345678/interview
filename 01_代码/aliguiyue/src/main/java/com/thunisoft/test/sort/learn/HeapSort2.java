package com.thunisoft.test.sort.learn;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class HeapSort2 {

    public static void main(String[] args) {
        int[] array = ArrayUtils.getArray(20);

        ArrayUtils.forEachArray(array);

        sort(array);

        ArrayUtils.forEachArray(array);
    }

    public static void sort (int[] array){

        final int length = array.length;

        // 外层循环，比较次数
        for (int i = 0; i < length - 1; i++){

            // 创建大堆
            buildMaxHeap(array, length - 1 - i);

            // 交换第一个和最后一个
            swap(array, 0, length - 1 - i);

        }
    }


    private static void buildMaxHeap(int[] array, int lastIndex){

        int lastFather = (lastIndex - 1) >> 1;

        for (int i = lastFather; i >= 0; i--){
            // 保留当前父节点
            int k = i;
            while (2 * k + 1 <= lastIndex){

                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex && array[biggerIndex] < array[biggerIndex + 1]){
                    biggerIndex += 1;
                }

                if (array[k] < array[biggerIndex]){
                    swap(array, k, biggerIndex);
                    k = biggerIndex;
                }else{
                    break;
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
