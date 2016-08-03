package NowCoder;

import java.util.Scanner;

public class Tencent_build_palindrome {

	public static void main(String[] args) {
		readData();

	}

	public static int maxSubSequence(String h, String v) {
		if (h == null || v == null || h.length() == 0 || v.length() == 0)
			return 0;
		int[][] b = new int[v.length() + 1][];
		for (int i = 0; i < b.length; i++) {
			b[i] = new int[h.length() + 1];
		}
		for (int i = 1; i <= v.length(); i++) {
			for (int j = 1; j <= h.length(); j++) {
				if (h.charAt(j - 1) == v.charAt(i - 1)) {
					b[i][j] = b[i - 1][j - 1] + 1;
				} else {
					b[i][j] = Math.max(b[i][j - 1], b[i - 1][j]);
				}
			}
		}
		return b[v.length()][h.length()];
	}

	public static void readData() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.next();
			System.out.println(minToDel(string));
		}
		scanner.close();
	}

	public static int minToDel(String s) {
		return s.length() - maxSubSequence(s, new StringBuilder(s).reverse().toString());
	}

}
