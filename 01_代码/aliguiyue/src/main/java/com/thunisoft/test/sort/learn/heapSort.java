package com.thunisoft.test.sort.learn;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class heapSort {


    public static void main(String[] args) {
        int[] array = ArrayUtils.getArray(20);

        ArrayUtils.forEachArray(array);

        sort(array);

        ArrayUtils.forEachArray(array);
    }



    public static void sort(int[] array){
        final int length = array.length;

        for (int i = 0; i < length - 1; i++){
            buildMaxHeap(array, length - 1 - i);
            swap(array, 0, length - 1 - i);
        }

    }


    /**
     * 构建大顶堆
     * @param array
     * @param lastIndex
     */
    private static void buildMaxHeap(int[] array, int lastIndex){

        // 遍历所有的父节点，从最后一个父节点开始
        // 假设lastIndex为最后一个父节点的左子节点，从后向前遍历
        for (int i = (lastIndex - 1 ) >> 1; i >= 0; i--){

            // 保存当前节点的值
            int k = i;

            while (2 * k + 1 <= lastIndex ){
                // 假设k的左子节点是当前树的最大值的下标
                int biggerIndex = 2 * k + 1;

                // 如果左子节点的下标小于最后下标，且左子节点的值小于最后节点下标的值
                if (biggerIndex < lastIndex && array[biggerIndex] < array[biggerIndex + 1]){
                    // 如果左节点的值小于右节点的值，则将最大值下标改成右节点
                    biggerIndex += 1;
                }

                if (array[biggerIndex] > array[k]){
                    swap(array, k, biggerIndex);
                    k = biggerIndex;
                }else {
                    break;
                }
            }
        }

    }


    private static void swap(int[] array,int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
