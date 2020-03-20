package com.thunisoft.test.sort;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class MyQuickSortTest {

    public static void main(String[] args) {
        int[] array = ArrayUtils.getArray(20);

        ArrayUtils.forEachArray(array);

        sort(array, 0, array.length );

        ArrayUtils.forEachArray(array);
    }

    public static void sort(int[] array, int low, int high){

        if (low >= high){
            return;
        }

        int begin = low;
        int end = high;

        int index = low;

        for (int i = begin + 1; i < end; i++){

            if (array[begin] > array[i]){

                index++;

                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;

            }
        }

        int temp = array[index];
        array[index] = array[begin];
        array[begin] = temp;

        sort(array, begin, index);
        sort(array, index + 1, end);



    }

}
