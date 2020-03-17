package com.thunisoft.test.sort.exercise01;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class MyMergeTest02 {

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

        int[] leftArray = sort(array, low, mid);
        int[] rightArray = sort(array, mid + 1, high);
        int[] newArray = new int[leftArray.length + rightArray.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftArray.length && j < rightArray.length){
            newArray[k++] = leftArray[i] < rightArray[j] ? leftArray[i++] : rightArray[j++];
        }

        while (i < leftArray.length){
            newArray[k++] = leftArray[i++];
        }

        while (j < rightArray.length){
            newArray[k++] = rightArray[j++];
        }

        return newArray;

    }

}
