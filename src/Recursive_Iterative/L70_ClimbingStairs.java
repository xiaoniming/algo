package Recursive_Iterative;

import Utils.U;
/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/

public class L70_ClimbingStairs {

	public L70_ClimbingStairs() {
		int n = 45;
		// U.print(climbStairs(n));
		U.print(climbStairs_rec(n));

	}

	// recursive takes long time. not good
	public int climbStairs_rec(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	// Actually it is fibonacci.
	public int climbStairs(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int pre1 = 1, pre2 = 2, cur = 0;
		while (n - 3 >= 0) {
			cur = pre1 + pre2;
			pre1 = pre2;
			pre2 = cur;
			n--;
		}
		return cur;

	}
}
