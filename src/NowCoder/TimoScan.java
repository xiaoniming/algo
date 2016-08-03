package NowCoder;

import java.util.Scanner;

import Utils.U;

public class TimoScan {
	int N, M, K;
	int mushroom[][];
	boolean DEBUG = false;

	public TimoScan() {
		readData();
		System.out.println(max2());
		System.out.println(max());
	}

	private void readData() {
		System.out.println("Please enter N M K");
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		K = s.nextInt();
		if (N < 1 || M > 20 || K > 100) {
			System.out.println("Sorry error input");
			System.exit(0);
		}
		if (N < 3)
			N = 3;
		if (M < 3)
			M = 3;

		System.out.println("Please enter array[][]");
		mushroom = new int[N + 1][M + 1];
		int x = 0, y = 0;
		for (int i = 0; i < K; i++) {
			x = s.nextInt();
			y = s.nextInt();
			if (x < 1 || x > N || y < 1 || y > M) {
				System.out.println("Sorry mushroom out of area");
				System.exit(0);
			} else {
				mushroom[x][y]++;
			}
		}
		s.close();
		if (DEBUG) {
			System.out.println("Succeed in reading N M K array[][]" + N + " " + M + " " + K);
			for (int i = 1; i <= N; i++) {
				U.print(mushroom[i]);
			}
		}
	}

	private int max2() {
		int maxSum = 0;
		for (int i = 1; i <= N - 2; i++) {
			for (int j = 1; j <= M - 2; j++) {
				for (int x = 1; x <= N - 2; x++) {
					for (int y = 1; y <= M - 2; y++) {
						maxSum = Math.max(
								(count(i, j, mushroom) + count(x, y, mushroom) - checkRepet(i, j, x, y, mushroom)),
								maxSum);
					}
				}
			}
		}
		return maxSum;
	}

	private int count(int a, int b, int[][] array) {
		int sum = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (mushroom[a + i][b + j] > 0) {
					sum++;
				}
			}
		}
		return sum;
	}

	private int checkRepet(int x1, int y1, int x2, int y2, int[][] array) {
		int repet = 0;
		if (Math.abs(x1 - x2) < 3 || Math.abs(y1 - y2) < 3) {
			for (int x = Math.max(x1, x2); x < Math.min(x1, x2) + 3; x++) {
				for (int y = Math.max(y1, y2); y < Math.min(y1, y2) + 3; y++) {
					if (array[x][y] > 1)
						repet++;
				}
			}
		}
		return repet;

	}

	private int max() {

		int sum1 = 0, sum2 = 0, maxSum = 0;
		int tempStore[][] = new int[3][3];

		for (int i = 1; i <= N - 2; i++) {
			for (int j = 1; j <= M - 2; j++) {

				copyArray(tempStore, 0, 0, mushroom, i, j);
				sum1 = countAndDel(i, j, true);

				for (int x = 1; x <= N - 2; x++) {
					for (int y = 1; y <= M - 2; y++) {

						sum2 = countAndDel(x, y, false);
						if (sum1 + sum2 > maxSum) {
							maxSum = sum1 + sum2;
						}

					}
				}
				copyArray(mushroom, i, j, tempStore, 0, 0);

			}
		}
		return maxSum;

	}

	private int countAndDel(int i, int j, boolean delete) {
		int sum = 0;
		for (int it = 0; it < 3; it++) {
			for (int jt = 0; jt < 3; jt++) {
				if (mushroom[i + it][j + jt] > 0) {
					sum++;
					if (delete) {
						mushroom[i + it][j + jt]--;// delete one mushroom
					}

				}
			}
		}
		return sum;
	}

	private void copyArray(int[][] destArray, int a, int b, int[][] origArray, int x, int y) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				destArray[a + i][b + j] = origArray[x + i][y + j];
			}
		}
	}

}