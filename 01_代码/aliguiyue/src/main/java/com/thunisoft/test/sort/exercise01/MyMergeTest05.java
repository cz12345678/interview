package com.thunisoft.test.sort.exercise01;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class MyMergeTest05 {


    public static void main(String[] args) {
        int[] array = ArrayUtils.getArray(20);

        ArrayUtils.forEachArray(array);

        int[] newArrays = sort(array, 0, array.length - 1);

        ArrayUtils.forEachArray(newArrays);
    }
    public static int[] sort(int[] array, int low, int high){

        if (low == high){
            return new int[]{array[low]};
        }

        int mid = low + ((high - low) >> 2);

        int[] left = sort(array, low, mid);
        int[] right = sort(array, mid + 1, high);

        int[] news = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length){
            news[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }

        while (i < left.length){
            news[k++] = left[i++];
        }

        while (j < right.length){
            news[k++] = right[j++];
        }


        return news;

    }

}
