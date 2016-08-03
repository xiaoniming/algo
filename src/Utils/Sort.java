package Utils;

public class Sort {

	public static void quickSort(int nums[], int left, int right) {
		if (left >= right)
			return;
		int temp = nums[left];
		int i = left;
		int j = right;
		while (i != j) {
			while (nums[j] >= temp && i < j) // Mark!! "=" is very important
				j--;
			while (nums[i] <= temp && i < j)
				i++;
			if (i < j) {
				swap(i, j, nums);
			}
		}

		nums[left] = nums[i];
		nums[i] = temp;
		quickSort(nums, left, i - 1);
		quickSort(nums, i + 1, right);
	}

	public static int[] bubbleSort(int num[]) {
		int n = num.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (num[j] > num[j + 1]) {
					swap(j, j + 1, num);
				}
			}
		}
		return num;
	}

	public static int[] insertSort(int[] num) {
		for (int i = 1; i < num.length; i++) {
			int j = i;
			while (j > 0 && num[j] < num[j - 1]) {
				swap(j, j - 1, num);
				j--;
			}
		}
		return num;
	}

	public boolean checkSorted(int num[]) {
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] > num[i + 1])
				return false;
		}
		return true;
	}

	private static void swap(int i, int j, int num[]) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
