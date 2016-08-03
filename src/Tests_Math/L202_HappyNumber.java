package Tests_Math;

import java.util.TreeSet;

import Utils.U;

/**
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 */

public class L202_HappyNumber {

	public L202_HappyNumber() {
		U.print(isHappy(17));
		U.print(isHappy2(17));

	}

	// set two flags fast(2 steps per time) and slow(1 step per time)
	// if happy num then either slow or fast will be 1
	// if not happy, there will be a circle and fast will catch up with slow
	public boolean isHappy2(int n) {
		int slow = n;
		int fast = n;
		while (true) {
			slow = getSquaresSum(slow);
			fast = getSquaresSum(getSquaresSum(fast));
			if (slow == 1 || fast == 1)
				return true;
			if (slow == fast)
				return false;
		}

	}

	// My method : use Set to check repeat
	public boolean isHappy(int n) {
		int sum = n;
		TreeSet<Integer> set = new TreeSet<>();
		while (sum != 1) {
			sum = getSquaresSum(sum);
			if (set.contains(sum))
				return false;
			else {
				set.add(sum);
			}
		}
		return true;
	}

	public int getSquaresSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}
}
