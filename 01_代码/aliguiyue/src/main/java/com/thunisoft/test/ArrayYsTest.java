package com.thunisoft.test;

/**
 * 数组储水问题：
 *      采用双指针的算法
 */
public class ArrayYsTest {


    public static void main(String[] args) {
//        int[] arr = new int[]{2,5,1,2,3,4,7,7,6};
//        int[] arr = new int[]{1,8,6,2,5,4,8,3,7}; // 19
        int[] arr = new int[]{ 5, 2, 3, 2, 4 }; // 5
        int sum = sum(arr);
        System.out.println(sum);
    }

    public static int sum(int[] arr){
        final int length = arr.length;
        // 判断，若是数组长度 length < 3 直接返回
        if (length < 3){
            return 0;
        }
        // 定义总的储水量
        int sum = 0;

        // 定义左右指针
        int left = 0;
        int right = length - 1;

        // 定义左右最大值
        int leftMax = arr[left];
        int rightMax = arr[right];

        // 循环条件：左右指针不能重合
        while (left < right){

            // 如果左边最大值 > 右边最大值，移动右指针。在移动之前要计算当前右指针对应位置的储水量
            // 如果左右最大值相等，设置 左指针 +1 或是 右指针 -1，防止出现死循环
            if (leftMax > rightMax){
                sum += rightMax - arr[right--];
                rightMax = Math.max(rightMax, arr[right]);
            }
            // 同上
            if (leftMax <= rightMax){
                sum += leftMax - arr[left++];
                leftMax = Math.max(leftMax, arr[left]);
            }



        }
        return sum;
    }

}
