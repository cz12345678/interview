package com.my.wechat.algorithm;

/**
 * @ProjectName: DataStructures
 * @Package: com.my.wechat.algorithm
 * @ClassName: Zdzys
 * @Author: chenzhen
 * @Description: 最大质因数计算
 * @Date: 2019/12/31 0031 下午 9:25
 * @Version: 1.0
 */
public class Zdzys {

    public static void main(String[] args) {
        // 获取最大质因数
//        System.out.println(getZdzys(13195)); // 5、7、13、29

        System.out.println(getZdzys(120));

    }

    public static int getZdzys(int num){
        if (num == 1){
            return num;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0){
                return getZdzys(num / i);
            }
        }
        return num;
    }

}


class test{
    public static void main(String[] args) {
        long sum = 0;
        long fac = 1;
        for (int i = 1; i <= 4; i++) {
            fac = fac * i;
            sum += fac;
        }
        System.out.println(sum);
    }
}