package src.com.atguigi.my.sort;

import java.util.Arrays;

/**
 * 桶排序
 *
 */
public class BucketSort {

    public static void main(String args[]) {

        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        sort(array);

        Arrays.stream(array).forEach(x -> {
            System.out.print(x + "\t");
        });

    }


    /**
     * 桶排序：
     *      1.获取数组中的最大值，根据最大值（位数）计算出最外层循环的次数
     *      2.循环遍历个、十位、百位...
     *      3.遍历中
     *          将个位数放置到对应的桶中，完成后，将从0~9桶中的数依次的放回数组中
     *          将十位数放置到对应的桶中，完成后，将从0~9桶中的数依次的放回数组中
     *          。。。。
     *     4.至最高位，返回数组
     * @param array
     */
    public static void sort(int[] array){
        // 1.找出最大值
        int maxIndex = 0;

        for (int i = 1; i < array.length; i++){
            if (array[i] > array[maxIndex]){
                maxIndex = i;
            }
        }
        // 2.得到最大值下标，计算需要遍历的次数
        final int maxLength = String.valueOf(array[maxIndex]).length();

        // 3. 创建10个桶，含有10个一维数组的二维数组，为放置下标越界，一维数组的大小是array.length
        int[][] bucket = new int[10][array.length];

        // 4. 创建一个长度为10的数组，记录每个桶中存放数据的个数
        int[] bucketElementCounts = new int[10];

        // 5. 最外层循环，根据位数遍历，结束循环 maxlength, n
        //      n 是用来获取 对应位置上对应的数字
        for (int i = 0 , n = 1 ; i < maxLength; i++,  n *= 10){

            // 1. 获取每个元素对应位置上的值，放到对应的桶中
            for (int j = 0; j < array.length; j++){
                int digitOfElement = array[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = array[j];
            }

            // 2. 将每个桶中的元素，从桶1 到桶10 依次取出，放到原来的数组中
            // 定义一个临时变量，代表原始数组的指针
            int index = 0;
            // 遍历记录桶元素个数的数组
            for (int j = 0; j < bucketElementCounts.length; j++){

                // 如果bucketElementCounts中 j 位置对应的数值不为0，则表示对应的桶中含有数据
                if (bucketElementCounts[j] != 0){
                    // 获取对应的桶
                    int[] temp = bucket[j];
                    for (int k = 0; k < bucketElementCounts[j]; k++){
                        array[index++] = temp[k];
                    }
                }
                // 将记录桶元素个数的对应的位置置为0
                bucketElementCounts[j] = 0;
            }
        }



    }

}
