package com.thunisoft.test.sort.exercise01.utils;

public final class ArrayUtils {

    private ArrayUtils(){}

    // 获取数组
    public static int[] getArray(int num){
        int[] arrays = new int[num];
        for (int i = 0; i < arrays.length; i++){
            arrays[i] = (int)(Math.random() * 1000);
        }
        return arrays;
    }



    // 遍历数组
    public static void forEachArray(int[] array){
        for (int i : array){
            System.out.print(i + "\t");
        }
        System.out.println();
    }

}
