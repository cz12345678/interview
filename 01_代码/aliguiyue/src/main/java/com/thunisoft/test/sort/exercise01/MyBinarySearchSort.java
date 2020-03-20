package com.thunisoft.test.sort.exercise01;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class MyBinarySearchSort {

    public static void main(String[] args) {
        int[] array = ArrayUtils.getArray(20);

        ArrayUtils.forEachArray(array);

        sort(array);

        ArrayUtils.forEachArray(array);
    }


    public static void sort(int[] array){

        final int length = array.length;

        for (int i = 1; i < length; i++){

            int temp = array[i];

            int low = 0;
            int high = i - 1;
            while (low <= high){
                int mid = (high + low) >> 1;
                if (array[mid] > temp){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            for (int j = i; j > low; j--){
                array[j] = array[j - 1];
            }

            array[low] = temp;


        }


    }




}
