package com.thunisoft.test.sort;

/**
 * 快速排序
 */
public class QuickSort {



    public static void main(String[] args) {

        int[] arrays = new int[20];
        for (int i = 0; i < arrays.length; i++){
            arrays[i] = (int)(Math.random() * 100);
        }

        for (int i : arrays){
            System.out.print(i + "\t");
        }
        System.out.println();

        quickSort(arrays, 0, arrays.length );

        for (int i : arrays){
            System.out.print(i + "\t");
        }

        System.out.println();


    }




    public static void quickSort(int[] array, int low, int high){
        if (low >= high){
            return;
        }

        int index = low;


        for (int i = low + 1; i < high; i++){
            if (array[low] > array[i]){
                index++;

                // 循环内交换： index处于当前遍历元素i位置交换
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }

        // 循环外交换： low处元素与index处元素交换
        int temp = array[index];
        array[index] = array[low];
        array[low] = temp;

        quickSort(array, low, index - 1);
        quickSort(array, index + 1, high);

    }

}
