package com.thunisoft.test.sort.exer1029;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class BuddleSort {

    public static void main(String[] args) {
        int[] array = ArrayUtils.getArray(20);

        ArrayUtils.forEachArray(array);

        sort(array);

        ArrayUtils.forEachArray(array);
    }

    public static void sort(int[] array){

        final int length = array.length;

        for (int i = 0; i < length - 1; i++){

            for (int j = 0; j < length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }

        }


    }

}
