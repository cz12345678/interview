package com.thunisoft.my.test;

/**
 * @author chenzhen-1
 * @create 2019-06-18 15:23
 */
public class Test03 {


    /**
     * 测试main方法
     * @param args
     */
    public static void main(String[] args) {
        Character[] cs = getChars();
        notNull(cs);
        for (Character ch: cs) {
            System.out.print(ch + "\t");
        }
    }


    /**'
     * 当数组中元素为空时，移位
     * @param objs
     */
    public static void notNull(Object[] objs){
        int temp = 0;
        for (int i = 0; i < objs.length - 1 - temp; i++) {
            if (objs[i] == null){
                for (int j = i; j < objs.length - 1; j++){
                    objs[j] = objs[j + 1];
                }
                ++temp;
//                System.out.println(temp);
                objs[objs.length - temp] = null;
            }
        }
    }



    /**
     * 获取字符串数组
     * @return
     */
    public static Character[] getChars(){
        Character[] cs = new Character[26];
        for(int i = (int)'A'; i <= (int)'Z'; i++){
//            if ( (i - (int)'A') % 26 == 0){
//                continue;
//            }
            cs[i - (int)'A'] = (char)i;
        }
        return cs;
    }

}
