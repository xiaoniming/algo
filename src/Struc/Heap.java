package Struc;

import Utils.U;

public class Heap {
	int[] h;
	int N; // max h[N]

	public Heap(int[] data) {
		h = data;
		N = h.length - 1;
	}

	public int[] initMinHeap() {
		// Method 1: up -> bottom one by one
		// for (int i = 0; i <= N; i++) {
		// siftUp(i);
		// }
		// Method 2: bottom -> up every node as root sorted
		for (int i = (N - 1) / 2; i >= 0; i--) {
			siftBigDown(i);
		}
		return h;
	}

	public int[] initMaxHeap() {
		for (int i = (N - 1) / 2; i >= 0; i--) {
			siftSmallDown(i);
		}
		return h;
	}

	public int[] heapSortDecrease() {
		initMinHeap();
		while (N > 0) {
			swap(0, N);
			N--;
			siftBigDown(0);
		}
		return h;
	}

	public int[] heapSortIncrease() {
		initMaxHeap();
		while (N > 0) {
			swap(0, N);
			N--;
			siftSmallDown(0);
		}
		return h;
	}

	public int findXMax(int X) {
		N = X - 1;
		initMinHeap();
		for (int i = X; i < h.length; i++) {
			if (h[i] > h[0]) {
				swap(0, i);
				siftBigDown(0);
			}
		}
		U.print(h);
		return h[0];

	}

	private void swap(int i, int j) {
		int temp = h[i];
		h[i] = h[j];
		h[j] = temp;
	}

	private void siftBigUp(int i) {
		boolean flag = true;
		int up;
		while (i > 0 && flag) {
			up = (i - 1) / 2;
			if (h[up] < h[i]) {
				swap(up, i);
			} else
				flag = false;
		}
	}

	private void siftSmallDown(int i) {
		boolean flag = true;
		int t = i;
		while (i * 2 + 1 <= N && flag) {
			if (h[i * 2 + 1] > h[i]) {
				t = i * 2 + 1;
			}
			if (i * 2 + 2 <= N) {
				if (h[i * 2 + 2] > h[t]) {
					t = i * 2 + 2;
				}
			}
			if (t != i) {
				swap(i, t);
				i = t;
			} else
				flag = false;
		}
	}

	private void siftSmallUp(int i) {
		boolean flag = true;
		int up;
		while (i > 0 && flag) {
			up = (i - 1) / 2;
			if (h[up] > h[i]) {
				swap(up, i);
				i = up;
			} else
				flag = false;
		}
	}

	private void siftBigDown(int i) {
		boolean flag = true;
		int t = i;

		while ((i * 2 + 1) <= N && flag) {
			if (h[i * 2 + 1] < h[i]) {
				t = i * 2 + 1;
			}
			if ((i * 2 + 2) <= N) {
				if (h[i * 2 + 2] < h[t]) {
					t = i * 2 + 2;
				}
			}
			if (t != i) {
				swap(t, i);
				i = t;
			} else
				flag = false;
		}

	}
}
