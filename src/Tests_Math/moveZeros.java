package Tests_Math;
public class moveZeros {

	public moveZeros(int nums[]) {

		int k = 0;
		for (int num : nums) {
			if (num != 0)
				nums[k++] = num;
		}
		while (k < nums.length)
			nums[k++] = 0;
		p(nums);
	}

	public static void p(int num[]) {
		for (int x : num)
			System.out.print(x + " ");
		System.out.println();
	}

}
