package Tests_Math;

import Utils.U;

public class L263_UglyNum {
	public static void main(String args[]) {
		for (int i = 0; i < 100; i++) {
			if (isUgly1(i)) {
				U.print(i);
			}
		}

	}

	public static boolean isUgly(int num) {
		if (num <= 0)
			return false;
		if (num == 1) {
			return true;
		}
		int[] factor = { 2, 3, 5 };
		int pre;
		while (num > 1) {
			pre = num;
			for (int i = 0; i < 3; i++) {
				if (num % factor[i] == 0)
					num /= factor[i];
			}
			if (pre == num)
				return false;
		}
		return true;
	}

	public static boolean isUgly1(int num) {
		if (num <= 0)
			return false;
		if (num == 1) {
			return true;
		}
		while (num % 2 == 0)
			num /= 2;
		while (num % 3 == 0)
			num /= 3;
		while (num % 5 == 0)
			num /= 5;
		return num == 1;
	}

}
