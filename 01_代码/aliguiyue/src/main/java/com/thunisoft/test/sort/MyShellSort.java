package com.thunisoft.test.sort;

public class MyShellSort {

    public static void main(String[] args) {
        int[] arrays = new int[20];
        for (int i = 0; i < arrays.length; i++){
            arrays[i] = (int)(Math.random() * 100);
        }

        for (int i : arrays){
            System.out.print(i + "\t");
        }
        System.out.println();

//        sort1(arrays);
        sort(arrays);

        for (int i : arrays){
            System.out.print(i + "\t");
        }

        System.out.println();
    }
    /**
     * 希尔排序
     * @param array
     */
    public static void sort(int[] array){

        final int length = array.length;
        int gap = length >> 1;
        int temp = 0;

        while (gap > 0){

            for (int i = gap; i < length; i++){
                temp = array[i];
                int preIndex = i - gap;

                while (preIndex >= 0 && array[preIndex] > temp){
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }

            gap = gap >> 1;
        }


    }

}
