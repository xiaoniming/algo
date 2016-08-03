package Test_Arrays;

import Utils.U;

public class ProductOfArray {
	public static void main(String[] args) {
		new ProductOfArray();
	}

	public ProductOfArray() {
		int[] nums = { 1, 2, 3 };
		U.print(productExceptSelf(nums));

	}

	public int[] productExceptSelf(int[] nums) {
		int N = nums.length;
		int right = 1;
		int[] ans = new int[N];
		ans[0] = nums[0];
		for (int i = 1; i < N - 1; i++) {
			ans[i] = ans[i - 1] * nums[i];
		}

		for (int i = N - 1; i > 0; i--) {
			ans[i] = ans[i - 1] * right;
			right *= nums[i];
		}
		ans[0] = right;
		return ans;
	}
}
