package com.thunisoft.test.sort.exer1029;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class ShellSort {


    public static void main(String[] args) {
        int[] array = ArrayUtils.getArray(20);

        ArrayUtils.forEachArray(array);

        sort(array);

        ArrayUtils.forEachArray(array);
    }

    public static void sort(int[] array){

        final int length = array.length;

        int gap = length >> 1;

        int i, j;

        while (gap > 0){

            for (i = gap; i < length; i++){

                int temp = array[i];

                for (j = i - gap; j >= 0 && array[j] > temp; j -= gap ){
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;
            }
            gap = gap >> 1;
        }



    }

}
