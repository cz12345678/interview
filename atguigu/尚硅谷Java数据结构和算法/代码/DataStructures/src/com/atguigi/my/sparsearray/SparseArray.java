package com.atguigi.my.sparsearray;

/**
 * @ProjectName: DataStructures
 * @Package: com.atguigi.my.sparsearray
 * @ClassName: SparseArray
 * @Author: chenzhen
 * @Description: 稀疏数组学习
 * @Date: 2019/12/13 0013 下午 9:22
 * @Version: 1.0
 */
public class SparseArray {

    /**
     * 二维数组 转 稀疏数组的思路
     * 1. 遍历  原始的二维数组，得到有效数据的个数 sum
     * 2. 根据sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]
     * 3. 将二维数组的有效数据数据存入到 稀疏数组
     *
     * 稀疏数组转原始的二维数组的思路     *
     * 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
     * 2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
     */

    public static void main(String[] args) {
        // 1.获取原始二维数组
        int[][] originArray = getOriginArray();

        // 2.遍历原始数组，得到有效数据的个数
        int sparseRows = getSparseRows(originArray);

        // 3. 获取原始数组对应的稀疏数组
        int[][] sparesArray = getSparseArray(originArray, sparseRows);

        // 4. 将原始数组中的数据存储到稀疏数组中
        convert2SparseArray(originArray, sparesArray);

        // 5. 将稀疏数组 转换成 原始数组
        int[][] array = corvertOriginArray(sparesArray);


    }

    /**
     * 将 稀疏数组 复原成 二维数组
     * @param sparesArray
     * @return
     */
    private static int[][] corvertOriginArray(int[][] sparesArray) {
        // 根据首行创建二维数组
        int[][] array = new int[sparesArray[0][0]][sparesArray[0][1]];

        // 遍历稀疏数组，填充原始数组数据
        for (int i = 1; i < sparesArray.length; i++){
            array[sparesArray[i][0]][sparesArray[i][1]] = sparesArray[i][2];
        }
        return array;
    }

    /**
     * 将 二维数组 转换成稀疏数组
     * @param originArray
     * @param sparesArray
     */
    private static void convert2SparseArray(int[][] originArray, int[][] sparesArray) {
        int index = 1;
        for (int i = 0; i < originArray.length; i++) {
            int[] temp = originArray[i];
            for (int j = 0; j < temp.length; j++){
                if (originArray[i][j] != 0){
                    sparesArray[index][0] = i;
                    sparesArray[index][1] = j;
                    sparesArray[index][2] = originArray[i][j];
                    index++;
                }
            }
        }
    }


    /**
     * 获取 记录原始数据信息的稀疏数组
     * @param originArray
     * @param sparseRows
     * @return
     */
    private static int[][] getSparseArray(int[][] originArray, int sparseRows) {
        // 第一行记录原始数组的 行数、列数、有效数据数
        // 之后每一行记录 有效数据 的 行、列、有效数据值
        int[][] sparese = new int[sparseRows + 1][3];

        // 设置稀疏数组的首行
        sparese[0][0] = originArray.length;
        sparese[0][1] = originArray[0].length;
        sparese[0][2] = sparseRows;
        return sparese;
    }

    /**
     * 获取 原始数据的有效数据的个数
     * @param originArray
     * @return
     */
    private static int  getSparseRows(int[][] originArray) {
        int count = 0;
        for (int i = 0; i < originArray.length; i++){
            int[] temp = originArray[i];
            for (int j = 0; j < temp.length; j++){
                if (originArray[i][j] != 0){
                    count += 1;
                }
            }
        }
//        System.out.printf("有%d个有效数据", count);
        return count;
    }

    /**
     * 获得 原始 的 二维数组
     * @return
     */
    private static int[][] getOriginArray(){
        // 1.创建原始数组 11 * 11的二维数组
        int[][] origin = new int[11][11];

        // 2.设置棋子，默认值0表示没有棋子，1表示黑子，2表示白字
        origin[1][2] = 1;
        origin[2][3] = 2;
        origin[4][5] = 2;

//        // 3. 遍历二维数组
//        for (int[] array : origin) {
//            for (int i: array) {
//                System.out.print(i + "\t");
//            }
//            System.out.println();
//        }
        return origin;
    }


    /**
     * 遍历二维数组
     * @param arrays
     */
    private static void traverseArray(int[][] arrays){
        for (int[] array: arrays) {
            for (int value: array) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }




}
