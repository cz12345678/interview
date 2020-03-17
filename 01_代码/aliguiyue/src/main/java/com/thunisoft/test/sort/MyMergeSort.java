package com.thunisoft.test.sort;

public class MyMergeSort {


    public static void main(String[] args) {
        int[] nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 10 };
        int[] newNums = mergeSort(nums, 0, nums.length - 1);
        for (int x : newNums) {
            System.out.println(x);
        }
    }


    private static int[] mergeSort(int[] nums, int low, int high ){

        // 生成单个元素的数组
        if (low == high){
            return new int[]{ nums[low] };
        }

        // 计算中间位置---计算公式： ((大数 - 小数)/ 2)  + 1
        int mid = ((high - low) >> 2) + low;

        // 左侧数组
        int[] leftArray = mergeSort(nums, low, mid);

        // 右侧数组: 从mid + 1开始，因为左侧数组已经取到mid了
        int[] rightArray = mergeSort(nums, mid + 1, high);

        // 创建新的数组，存放排序后的数组: 数组的长度一定是 左数组长度 + 右数组长度，不能直接使用 num.length
        int[] newArray = new int[leftArray.length + rightArray.length];


        int l = 0;
        int r = 0;
        int n = 0;

        while (l < leftArray.length && r < rightArray.length){
            newArray[n++] = leftArray[l] < rightArray[r] ? leftArray[l++] : rightArray[r++];
        }

        while (l < leftArray.length){
            newArray[n++] = leftArray[l++];
        }

        while (r < rightArray.length){
            newArray[n++] = rightArray[r++];
        }

        return newArray;


    }
}
