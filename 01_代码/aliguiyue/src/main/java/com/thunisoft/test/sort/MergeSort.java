package com.thunisoft.test.sort;

import com.thunisoft.test.sort.exercise01.utils.ArrayUtils;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = ArrayUtils.getArray(20);

        ArrayUtils.forEachArray(array);

        array = sort(array);

        ArrayUtils.forEachArray(array);
    }

    public static int[] sort(int[] array){
        return mergeSort(array,0, array.length - 1);
    }

    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h){
            return new int[] { nums[l] };
        }

        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newNum[m++] = leftArr[i++];
        while (j < rightArr.length)
            newNum[m++] = rightArr[j++];
        return newNum;
    }

}
