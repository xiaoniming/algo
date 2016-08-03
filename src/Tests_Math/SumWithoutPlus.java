package Tests_Math;

import Utils.U;

public class SumWithoutPlus {

	public static void main(String[] args) {
		U.print(getSum(256, 123));

	}

	// Calculate the sum of two integers a and b, but you are not allowed to use
	// the operator + and -.
	public static int getSum(int a, int b) {
		int sum = a ^ b; // 异或求当前位和
		int carry = (a & b) << 1; // 位与左移求进位
		return b == 0 ? a : getSum(sum, carry);// 无进位返回和值，否则递归继续
	}

	public static void pb(int a) {
		U.print(Integer.toBinaryString(a));
	}

}
