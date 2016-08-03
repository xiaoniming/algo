package Tests_Math;

import Utils.U;

public class MissingNumber {

	public MissingNumber() {
		U.print(missingNumber(new int[] { 0, 1, 2, 4 }));
	}

	public int missingNumber(int[] nums) {

		if (nums.length == 0)
			return 0;
		int ans = 0, i;
		for (i = 0; i < nums.length; i++) {
			ans = ans ^ i ^ nums[i];
		}

		return ans ^ i;

	}

}
