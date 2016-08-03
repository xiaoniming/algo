package NowCoder;

import java.util.Arrays;
import java.util.Scanner;

public class NetEase_6174 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		// here you should input a %4d num ****

		while (n != 6174) {
			n = cal(n);
		}
		scanner.close();
	}

	public static int cal(int n) {

		char[] arr = String.valueOf(n).toCharArray();
		Arrays.sort(arr);
		String string = String.valueOf(arr);
		int len = string.length();
		for (int i = 0; i < 4 - len; i++) {
			string = "0" + string;
		}
		StringBuilder sb = new StringBuilder(string);
		int small = Integer.parseInt(sb.toString());
		int big = Integer.parseInt(sb.reverse().toString());
		if (big == small) {
			System.out.printf("%04d - %04d = %04d\n", big, small, 0);
			return 6174;
		}
		System.out.printf("%04d - %04d = %04d\n", big, small, big - small);
		return big - small;
	}

}
