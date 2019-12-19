package src.com.atguigu.sort;

import java.util.Arrays;

public class MergeSortTest02 {


    public static void main(String args[]){

        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 1000);
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        array = sort(array, 0, array.length - 1);

        Arrays.stream(array).forEach(x -> {
            System.out.print(x + "\t");
        });
        System.err.println();

    }


    public static int[] sort(int[] array, int low, int high){
//        if (high >= array.length){
//            high = array.length - 1;
//        }

        if (low >= high){
            return new int[]{array[low]};
        }

        int mid = low + ((high - low) >> 1);

        int[] left = sort(array, low, mid);
        int[] right = sort(array, mid + 1, high);

        int[] news = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

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
