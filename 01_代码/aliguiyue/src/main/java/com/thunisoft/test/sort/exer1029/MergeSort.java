package com.thunisoft.test.sort.exer1029;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class MergeSort {


    public static void main(String[] args) {
        int[] array = ArrayUtils.getArray(20);

        ArrayUtils.forEachArray(array);

        array = sort(array);

        ArrayUtils.forEachArray(array);
    }

    public static int[] sort(int[] array){
        return sort(array,0, array.length - 1);
    }



    public static int[] sort(int[] array, int low, int high){

        if (low == high){
            return new int[]{array[low]};
        }

        int mid = low + (high - low) / 2;

        int[] left = sort(array, low, mid);
        int[] right = sort(array, mid + 1, high);

        int[] newArr = new int[left.length + right.length];

        int i = 0, j = 0 , k = 0;

        while (i < left.length && j < right.length){
            newArr[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }

        while (i < left.length){
            newArr[k++] = left[i++];
        }
        while (j < right.length){
            newArr[k++] = right[j++];
        }

        return newArr;
    }

}
