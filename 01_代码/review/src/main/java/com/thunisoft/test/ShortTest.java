package com.thunisoft.test;
/**
 * @describe: 
 * @author:  chenzhen-1
 * @date: 2019-3-19-下午2:39:44
 */
public class ShortTest {
	
    public static void swap( int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
    public static void main (String[] args) {
        int a = 5, b = 10;
        swap (a, b);
        // a = 10, b = 5;
        System.err.println(" a = " + a + "\tb = " + b);
    }

	private static void extra1() {
		short s = 1;
		
//		s = s + 1;
		s = (short) (s + 1);
		
		s = s += 1;
		
		s = 3 & 9;
		System.err.println(s);
	}
	

}

class Outer {
    class Inner {}
    public static void foo() { new Outer().new Inner(); }
    public void bar() { this.new Inner(); }

    public static void main(String[] args) {
    	new Outer().new Inner();
    }
}

