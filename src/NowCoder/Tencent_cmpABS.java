package NowCoder;

import java.util.Scanner;
import java.util.Stack;

public class Tencent_cmpABS {

	public static void main(String[] args) {
		readData();

	}

	public static void readData() {
		Scanner scanner = new Scanner(System.in);
		int N, data[];
		while (scanner.hasNext()) {
			N = scanner.nextInt();
			data = new int[N];
			for (int i = 0; i < N; i++) {
				data[i] = scanner.nextInt();
			}
			minMax(data);
		}
		scanner.close();
	}

	public static void reformArray(int[] data, Stack<Integer> stack_array, Stack<Integer> stack_count) {
		int i = 0, count = 0;
		while (i < data.length) {
			stack_array.push(data[i]);
			count = 0;
			while (i < data.length && data[i] == stack_array.peek()) {
				count++;
				i++;
			}
			stack_count.push(count);
		}
		// for (int t : stack_array) {
		// System.out.print(t);
		// }
		// for (int t : stack_count) {
		// System.out.print(t);
		// }
	}

	public static void minMax(int[] data) {
		Stack<Integer> stack_array = new Stack<>();
		Stack<Integer> stack_count = new Stack<>();
		quickSort(data, 0, data.length - 1);
		reformArray(data, stack_array, stack_count);
		int minAbs = Integer.MAX_VALUE;
		int minPair = 0;
		int maxAbs = 0;
		int maxPair = 0;
		if (stack_array.size() == 1) {
			minAbs = 0;
			minPair = stack_count.get(0) * (stack_count.get(0) - 1) / 2;
			maxPair = minPair;
		} else {
			maxAbs = stack_array.peek() - stack_array.get(0);
			maxPair = stack_count.peek() * stack_count.get(0);
			while (!stack_array.isEmpty()) {
				int num = stack_array.pop();
				int count = stack_count.pop();
				if (count > 1) {
					if (minAbs != 0) {
						minPair = 0;
					}
					minAbs = 0;
					minPair += count * (count - 1) / 2;
					continue;
				}
				if (stack_array.isEmpty())
					break;
				if (minAbs > num - stack_array.peek()) {
					minAbs = num - stack_array.peek();
					minPair = 1;
				} else if (minAbs == num - stack_array.peek()) {
					minPair += 1;
				}
			}
		}
		System.out.println(minPair + " " + maxPair);
		// System.out.println("min " + minAbs + ": " + minPair + " pairs");
		// System.out.println("max " + maxAbs + ": " + maxPair + " pairs");
	}

	public static void quickSort(int[] data, int left, int right) {
		if (left >= right)
			return;
		int i = left, j = right;
		int tmp = data[left];
		int swap;
		while (i < j) {
			while (i < j && data[j] >= tmp)
				j--;
			while (i < j && data[i] <= tmp)
				i++;
			if (i < j) {
				swap = data[i];
				data[i] = data[j];
				data[j] = swap;
			}
		}
		data[left] = data[j];
		data[j] = tmp;
		quickSort(data, left, j - 1);
		quickSort(data, j + 1, right);
	}

}
