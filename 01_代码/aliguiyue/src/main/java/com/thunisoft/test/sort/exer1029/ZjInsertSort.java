package com.thunisoft.test.sort.exer1029;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class ZjInsertSort {

    public static void main(String[] args) {
        int[] array = ArrayUtils.getArray(20);

        ArrayUtils.forEachArray(array);

        sort(array);

        ArrayUtils.forEachArray(array);
    }


    /**
     * 直接插入排序
     * @param array
     */
    public static void sort(int[] array){

        final int length = array.length;

        int i, j;

        for (i = 0; i < length; i++){
            int temp = array[i];
            for (j = i; j > 0 && array[j - 1] > temp; j--){
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }


    }



}
