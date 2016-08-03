package Tests_Math;

import java.util.Arrays;
import java.util.Comparator;

import Utils.U;

public class IntsToMinValue {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 3, 30, 34, 5, 9 };
		Integer[] arr1 = new Integer[] { 3, 30, 34, 5, 9 };
		// Method 1 :
		qs(arr, 0, arr.length - 1);
		U.print(arr);

		// Method 2:
		Arrays.sort(arr1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1.toString() + o2.toString();
				String s2 = o2.toString() + o1.toString();
				return Integer.valueOf(s1 + s2).compareTo(Integer.valueOf(s2 + s1));
			}
		});

		U.print(arr1);
	}

	public static boolean isSmaller(Integer[] data, int a, int b) {
		return Integer.valueOf((Integer.toString(a) + Integer.toString(b))) <= Integer
				.valueOf((Integer.toString(b) + Integer.toString(a)));
	}

	// quick sort using self defined comparator
	public static void qs(Integer[] data, int l, int r) {
		if (l >= r)
			return;
		int i = l, j = r, tmp = data[l], t;
		while (i < j) {
			while (i < j && isSmaller(data, tmp, data[j]))
				j--;
			while (i < j && isSmaller(data, data[i], tmp))
				i++;
			if (i < j) {
				t = data[i];
				data[i] = data[j];
				data[j] = t;
				U.print(data);
			}
		}
		data[l] = data[i];
		data[i] = tmp;
		qs(data, l, i - 1);
		qs(data, i + 1, r);
	}

}
