package Tests_Math;

import Utils.U;

public class L231_PowerOfTwo {

	public static void main(String[] args) {

		U.print(isPowerOfTwo(8));
	}

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return true;
		int tmp;
		while (n > 1) {
			tmp = n >> 1; // 移位操作还是要赋值的，值不会自己变的啊~~~
			if (n != 2 * tmp)
				return false;
			n = tmp;
		}
		return true;
	}

	// 妈妈嘚，做错了，这是是否是平方数
	public static boolean isSquare(int n) {
		if (n == 1 || n == 0 || n == 4)
			return true;
		else if (n < 9)
			return false;
		int big = n >> 1;
		int small = 1;
		int tmp;
		while (big - small > 1) {
			tmp = small + ((big - small) >> 1);
			if (tmp * tmp > n) {
				big = tmp;
			} else if (tmp * tmp < n) {
				small = tmp;
			} else
				return true;
		}
		return false;
	}
}
