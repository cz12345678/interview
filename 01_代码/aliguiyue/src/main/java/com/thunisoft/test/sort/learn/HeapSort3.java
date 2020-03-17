package com.thunisoft.test.sort.learn;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class HeapSort3 {
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

    private static void buildMaxHeap(int[] array, int lastIndex){

        for (int i = (lastIndex - 1) >> 1; i >= 0; i--){

            int k = i;
            while (2 * k + 1 <= lastIndex){

                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex && array[biggerIndex] < array[biggerIndex + 1]) {
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
